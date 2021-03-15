package ru.geekbrains.dagger2application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.geekbrains.dagger2application.convert.IConverter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {
    @Inject
    lateinit var converter: IConverter
    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.instance.component.inject(this)

        buttonConvert.setOnClickListener {
            presenter.convert()
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.attach(this)
    }

    override fun onStop(){
        presenter.detach(this)
        super.onStop()
    }

    override val value: Int
        get() = editValue.text.toString().toInt()

    override fun renderResult(value: Double) {
        textResult.text = value.toString()
    }
}