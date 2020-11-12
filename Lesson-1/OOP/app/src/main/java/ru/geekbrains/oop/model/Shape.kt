package ru.geekbrains.oop.model

// базовый интерфейс
// описывает контракт работы с классами
interface Shape {
    fun sumAngles():Double
    fun perimeter():Double
    fun area():Double
}