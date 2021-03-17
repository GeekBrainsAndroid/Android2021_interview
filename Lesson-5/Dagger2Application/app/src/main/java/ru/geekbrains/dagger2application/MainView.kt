package ru.geekbrains.dagger2application

interface MainView {
    val value: Int
    fun renderResult(value: Double)
    val value2: Int
    fun renderResult2(value: Double)
    fun countInstancePresenter1(value: Int)
    fun countInstancePresenter2(value: Int)
    fun countInstanceConvertHelper(value: Int)
}