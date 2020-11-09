package ru.geekbrains.oop.model

import kotlin.math.*

// Пример инкапсуляции
class Triangle (private val pointA: Point,
                private val pointB: Point,
                private val pointC: Point) {

    // Данные и код, который обрабатывает эти данные
    // хранятся в одном месте
    // Извне нельзя править эти данные, они приватные
    private var side_a: Double = 0.0
    private var side_b: Double = 0.0
    private var side_c: Double = 0.0

    private var angleA: Double = 0.0
    private var angleB: Double = 0.0
    private var angleC: Double = 0.0

    init {
        calcSides()
        calcAngles()
    }

    // Это публичные методы контракта
    fun area(): Double{
        return 0.5 * side_a * side_b * sin(angleC)
    }

    fun perimeter(): Double{
        return side_a + side_b + side_c
    }

    // приватные методы для внутреннего расчета
    // о них знает только класс
    private fun calcSide(point1: Point, point2: Point): Double{
        val x = abs(point1.x - point2.x)
        val y = abs(point1.y - point2.y)
        return sqrt(x.pow(2) + y.pow(2))
    }

    private fun calcSides() {
        this.side_a = calcSide(this.pointB, this.pointC)
        this.side_b = calcSide(this.pointA, this.pointC)
        this.side_c = calcSide(this.pointA, this.pointB)
    }

    private fun calcAngle(side1: Double, side2: Double, sideOpposite: Double): Double{
        val numerator = side1.pow(2)+side2.pow(2)-sideOpposite.pow(2)
        val denominator = 2*side1*side2
        return acos(numerator/denominator)
    }

    private fun calcAngles() {
        this.angleA = calcAngle(side_b, side_c, side_a)
        this.angleB = calcAngle(side_a, side_c, side_b)
        this.angleC = calcAngle(side_a, side_b, side_c)
    }
}