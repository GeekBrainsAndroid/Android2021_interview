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
            val value = editNumber.toDouble()
            val result = value.pow(2)
            textResult.text = DecimalFormat("#0.00").format(result)
        }
        buttonSqrRoot.setOnClickListener {
            val value = editNumber.toDouble()
            val result = sqrt(value)
            textResult.text = DecimalFormat("#0.00").format(result)
        }
        buttonCube.setOnClickListener {
            val value = editNumber.toDouble()
            val result = value.pow(3)
            textResult.text = DecimalFormat("#0.00").format(result)
        }
        buttonLn.setOnClickListener {
            val value = editNumber.toDouble()
            val result = log(value, E)
            textResult.text = DecimalFormat("#0.00").format(result)
        }
    }

    private fun EditText.toDouble() = this.text.toString().toDouble()
}