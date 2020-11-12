package ru.geekbrains.oop

import ru.geekbrains.oop.model.Point

interface Presenter {
    fun attach(v :View)
    fun detach(v: View)
    fun getData(points: List<Point>)
}