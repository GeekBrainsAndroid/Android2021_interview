package ru.geekbrains.oop.model

import kotlin.math.*

// класс реализации объекта "произвольный четырехугольник"
class Quadrilateral(pointA: Point,
                    pointB: Point,
                    pointC: Point,
                    pointD: Point) : QuadrilateralAbstract(pointA,
                                                        pointB,
                                                        pointC,
                                                        pointD) {

    override fun perimeter(): Double {
        val sideAB = calcSide(pointA, pointB)
        val sideBC = calcSide(pointB, pointC)
        val sideCD = calcSide(pointC, pointD)
        val sideDA = calcSide(pointD, pointA)
        return sideAB + sideBC + sideCD + sideDA
    }

    override fun area(): Double {
        val diagonalAC = calcSide(pointA, pointC)
        val diagonalBD = calcSide(pointB, pointD)
        val sideAB = calcSide(pointA, pointB)
        val sideBC = calcSide(pointB, pointC)
        val sideCD = calcSide(pointC, pointD)
        val sideDA = calcSide(pointD, pointA)
        return 0.25*sqrt(4*diagonalAC.pow(2)*diagonalBD.pow(2)-(sideAB.pow(2)+sideCD.pow(2)-sideBC.pow(2)-sideDA.pow(2)).pow(2))
    }
}