package ru.geekbrains.oop.model

import kotlin.math.PI

// абстрактный класс для работы с подтипом объектов "четырехугольники"
// содержит базовую реализацию для объектов "четырехугольники"
abstract class QuadrilateralAbstract (protected val pointA: Point,
                                      protected val pointB: Point,
                                      protected val pointC: Point,
                                      protected val pointD: Point) : ShapeAbstract() {
    override fun sumAngles(): Double = PI*2;
}