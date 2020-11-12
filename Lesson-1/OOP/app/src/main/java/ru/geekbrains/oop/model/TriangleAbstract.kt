package ru.geekbrains.oop.model

import kotlin.math.*

// абстрактный класс для работы с подтипом объектов "треугольники"
// содержит базовую реализацию для объектов "треугольники"
abstract class TriangleAbstract(protected val pointA: Point,
                                protected val pointB: Point,
                                protected val pointC: Point) : ShapeAbstract() {
    override fun sumAngles(): Double = PI;
}