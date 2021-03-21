package ru.geekbrains.koinapplication

interface MainView {
    val value: Int
    fun renderResult(value: Double)
}