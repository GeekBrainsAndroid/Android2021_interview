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
            val quadraticEquationFacade = QuadraticEquationFacade(a, b, c)
            try{
                val roots = quadraticEquationFacade.calculate()
                textXValue1.text = roots.root1.toString()
                textXValue2.text = roots.root2.toString()
            }
            catch (e: NegativeDiscriminantException){
                textXValue1.text = "Нет действительных корней"
                textXValue2.text = "Нет действительных корней"
            }
        }
    }

    private fun EditText.toDouble() = this.text.toString().toDouble()
}