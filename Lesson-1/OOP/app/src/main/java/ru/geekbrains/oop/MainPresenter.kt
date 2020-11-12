package ru.geekbrains.oop

import ru.geekbrains.oop.model.Point
import ru.geekbrains.oop.model.Quadrilateral
import ru.geekbrains.oop.model.Triangle

class MainPresenter : Presenter {

    private var view: View? = null

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
        val triangle = Triangle(points[0], points[1], points[2])
        val quadrilateral = Quadrilateral(points[3], points[4], points[5], points[6])
        val perimeter = triangle.perimeter() + quadrilateral.perimeter()
        val area: Double = triangle.area() + quadrilateral.area()
        view?.renderData(perimeter, area)
    }
}