package ru.geekbrains.isp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textInput.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                // Анонимный класс зависит от метода, который не использует
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Анонимный класс зависит от метода, который не использует
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                textEcho.text = s
            }
        })
    }
}