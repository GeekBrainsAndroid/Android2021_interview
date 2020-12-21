package ru.geekbrains.decorator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var greetable: Greetable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        greetable = GreetingToast(Greeting(this.baseContext), this.baseContext)
        button.setOnClickListener{
            this.textView.text = greetable.sayHello(textEdit.text.toString())
        }
    }
}