package ru.geekbrains.koinapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityScope
import org.koin.core.scope.Scope

class MainActivity : AppCompatActivity(), AndroidScopeComponent, MainView {
    override val scope : Scope by activityScope()

    private val presenter: IMainPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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