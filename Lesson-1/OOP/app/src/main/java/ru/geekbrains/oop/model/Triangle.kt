package ru.geekbrains.oop.model

import kotlin.math.*

// Пример инкапсуляции

// класс реализации объекта "произвольный треугольник"
class Triangle (pointA: Point,
                pointB: Point,
                pointC: Point) : TriangleAbstract(pointA, pointB, pointC) {

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
    override fun area(): Double{
        return 0.5 * side_a * side_b * sin(angleC)
    }

    override fun perimeter(): Double{
        return side_a + side_b + side_c
    }

    // приватные методы для внутреннего расчета
    // о них знает только класс
    private fun calcSides() {
        this.side_a = calcSide(this.pointB, this.pointC)
        this.side_b = calcSide(this.pointA, this.pointC)
        this.side_c = calcSide(this.pointA, this.pointB)
    }

    private fun calcAngles() {
        this.angleA = calcAngle(side_b, side_c, side_a)
        this.angleB = calcAngle(side_a, side_c, side_b)
        this.angleC = calcAngle(side_a, side_b, side_c)
    }
}