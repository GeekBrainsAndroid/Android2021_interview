package ru.geekbrains.dagger2application

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.geekbrains.dagger2application.di.namepresenter1
import ru.geekbrains.dagger2application.di.namepresenter2
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity(), MainView {
    @Inject
    @field:Named(namepresenter1)
    lateinit var presenter: IMainPresenter

    @Inject
    @field:Named(namepresenter2)
    lateinit var presenter2: IMainPresenter

    @Inject
    lateinit var convertHelper: ConvertHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.instance.component.inject(this)

        buttonConvert.setOnClickListener {
            presenter.convert()
        }

        buttonConvert2.setOnClickListener {
            presenter2.convert()
        }

        buttonInstance.setOnClickListener {
            presenter.getCountInstance()
            presenter2.getCountInstance()
            convertHelper.getCountInstance()
        }
    }

    override fun onStart() {
        super.onStart()
        App.instance.addActivityComponent()
        presenter.attach(this)
        presenter2.attach(this)
        convertHelper.attach(this)
    }

    override fun onStop(){
        presenter.detach(this)
        presenter2.detach(this)
        convertHelper.detach(this)
        App.instance.clearActivityComponent()
        super.onStop()
    }

    override val value: Int
        get() = editValue.text.toString().toInt()

    override fun renderResult(value: Double) {
        textResult.text = value.toString()
    }

    override val value2: Int
        get() = editValue2.text.toString().toInt()

    override fun renderResult2(value: Double) {
        textResult2.text = value.toString()
    }

    override fun countInstancePresenter1(value: Int) {
        textPres1.text = value.toString()
    }

    override fun countInstancePresenter2(value: Int) {
        textPres2.text = value.toString()
    }

    override fun countInstanceConvertHelper(value: Int) {
        textConverHelper.text = value.toString()
    }
}