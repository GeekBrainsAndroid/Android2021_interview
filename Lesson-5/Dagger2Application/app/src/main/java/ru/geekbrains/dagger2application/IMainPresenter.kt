package ru.geekbrains.dagger2application

interface IMainPresenter {
    fun attach(view: MainView)
    fun detach(view: MainView)
    fun convert()
    fun getCountInstance()
}