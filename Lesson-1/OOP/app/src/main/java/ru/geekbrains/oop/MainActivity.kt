package ru.geekbrains.oop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import ru.geekbrains.oop.model.Point
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View {

    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter()
        buttonCalc.setOnClickListener{
            presenter.getData(listOf(
                Point(point1X.toDouble(), point1Y.toDouble()),
                Point(point2X.toDouble(), point2Y.toDouble()),
                Point(point3X.toDouble(), point3Y.toDouble())
            ))
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.attach(this)
    }

    override fun onStop(){
        super.onStop()
        presenter.detach(this)
    }

    override fun renderData(perimeter: Double, area: Double) {
        textPerimeter.text = perimeter.toString()
        textArea.text = area.toString()
    }

    private fun EditText.toDouble () = this.text.toString().toDouble()
}