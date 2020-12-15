package ru.geekbrains.decorator

import android.content.Context

class Greeting(private val context: Context) : Greetable {

    override fun sayHello(str: String): String {
        val hello = context.resources.getString(R.string.hello)
        return "$hello $str"
    }
}