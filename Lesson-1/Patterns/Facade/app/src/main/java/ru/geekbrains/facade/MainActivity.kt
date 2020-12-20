package ru.geekbrains.facade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalc.setOnClickListener {
            val a = editA.toDouble()
            val b = editB.toDouble()
            val c = editC.toDouble()
            val quadraticEquation = QuadraticEquation(a, b, c)
            val d = quadraticEquation.calcDiscriminant()
            if (d < 0) {
                textXValue1.text = "Нет действительных корней"
                textXValue2.text = "Нет действительных корней"
            } else {
                textXValue1.text = quadraticEquation.calcRoot1(d).toString()
                textXValue2.text = quadraticEquation.calcRoot2(d).toString()
            }
        }
    }

    private fun EditText.toDouble() = this.text.toString().toDouble()
}