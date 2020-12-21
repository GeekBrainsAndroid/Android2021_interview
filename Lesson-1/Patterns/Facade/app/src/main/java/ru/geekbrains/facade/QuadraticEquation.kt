package ru.geekbrains.facade

import kotlin.math.*

class QuadraticEquation(private val a: Double, private val b: Double, private val c: Double) {

    fun calcDiscriminant(): Double = b * b - 4 * a * c

    fun calcRoot1(d: Double): Double = (-b + sqrt(d)) / (2 * a)

    fun calcRoot2(d: Double): Double = (-b - sqrt(d)) / (2 * a)
}