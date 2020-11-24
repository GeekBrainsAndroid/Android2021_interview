package ru.geekbrains.ocp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import kotlin.math.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSqr.setOnClickListener {
            calculate { it.pow(2) }
        }
        buttonSqrRoot.setOnClickListener {
            calculate { sqrt(it) }
        }
        buttonCube.setOnClickListener {
            calculate { it.pow(3) }
        }
        buttonLn.setOnClickListener {
            calculate { log(it, E) }
        }
    }

    private fun calculate(calc: (v: Double) -> Double) {
        val value = editNumber.toDouble()
        val result = calc(value)
        textResult.text = result.toText()
    }

    private fun EditText.toDouble() = this.text.toString().toDouble()

    private fun Double.toText(pattern: String = "#0.00") = DecimalFormat(pattern).format(this)
}