package ru.geekbrains.lsp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private val orderFactory = OrderFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalc.setOnClickListener {
            val order = orderFactory.create(editQnty.toInt(), editPrice.toDouble())
            textAmount.text = order.calcAmount().toText()
        }
    }

    private fun TextInputEditText.toDouble() = this.text.toString().toDouble()

    private fun TextInputEditText.toInt() = this.text.toString().toInt()

    private fun Double.toText(pattern: String = "#0.00") = DecimalFormat(pattern).format(this)
}