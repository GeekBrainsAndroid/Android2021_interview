package ru.geekbrains.srp

import kotlin.math.PI

class Circle(private val radius: Double) {
    val area: Double
        get() {
            return PI * radius * radius
        }

    val circumference: Double
        get() {
            return PI * radius * 2
        }
}