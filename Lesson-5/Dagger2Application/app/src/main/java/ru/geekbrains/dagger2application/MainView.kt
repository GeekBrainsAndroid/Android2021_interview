package ru.geekbrains.dagger2application

interface MainView {
    val value: Int
    fun renderResult(value: Double)
}