package ru.geekbrains.oop

import ru.geekbrains.oop.model.Point
import ru.geekbrains.oop.model.Triangle

class MainPresenter : Presenter {

    private var view: View? = null
    private lateinit var triangle: Triangle

    override fun attach(v: View) {
        if (view != v) {
            view = v
        }
    }

    override fun detach(v: View) {
        if (view == v){
            view = null
        }
    }

    override fun getData(points: List<Point>) {
        triangle =
            Triangle(points[0], points[1], points[2])
        val perimeter = triangle.perimeter()
        val area: Double = triangle.area()
        view?.renderData(perimeter, area)
    }
}