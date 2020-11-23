package ru.geekbrains.ocp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import kotlin.math.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSqr.setOnClickListener(this)
        buttonSqrRoot.setOnClickListener(this)
        buttonCube.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val value = editNumber.toDouble()
        var result: Double = 0.0
        when(v!!.id){
            R.id.buttonSqr -> {
                result = value.pow(2)
            }
            R.id.buttonSqrRoot ->{
                result = sqrt(value)
            }
            R.id.buttonCube ->{
                result = value.pow(3)
            }
        }
        textResult.text = DecimalFormat("#0.00").format(result)
    }

    private fun EditText.toDouble () = this.text.toString().toDouble()
}