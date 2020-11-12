package ru.geekbrains.oop.model

import kotlin.math.abs
import kotlin.math.acos
import kotlin.math.pow
import kotlin.math.sqrt

// базовый класс в иерархии
// содержит базовую реализацию
abstract class ShapeAbstract : Shape {

    // функции, для работы со всем семейством классов
    // вынесены в базовый класс
    protected fun calcSide(point1: Point, point2: Point): Double{
        val x = abs(point1.x - point2.x)
        val y = abs(point1.y - point2.y)
        return sqrt(x.pow(2) + y.pow(2))
    }

    protected fun calcAngle(side1: Double, side2: Double, sideOpposite: Double): Double{
        val numerator = side1.pow(2)+side2.pow(2)-sideOpposite.pow(2)
        val denominator = 2*side1*side2
        return acos(numerator/denominator)
    }
}