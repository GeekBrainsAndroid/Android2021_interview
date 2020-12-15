package ru.geekbrains.decorator

import android.content.Context
import android.widget.Toast

class GreetingToast(private val greeting: Greetable, private val context: Context) : Greetable {

    override fun sayHello(str: String): String {
        val answer = greeting.sayHello(str)
        Toast.makeText(context, answer, Toast.LENGTH_SHORT).show()
        return answer
    }
}