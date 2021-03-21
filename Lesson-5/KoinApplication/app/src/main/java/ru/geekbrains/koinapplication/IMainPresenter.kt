package ru.geekbrains.koinapplication

interface IMainPresenter {
    fun attach(view: MainView)
    fun detach(view: MainView)
    fun convert()
}