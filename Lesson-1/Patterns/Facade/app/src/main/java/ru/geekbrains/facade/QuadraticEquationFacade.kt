package ru.geekbrains.facade

class QuadraticEquationFacade(private val a: Double, private val b: Double, private val c: Double) {

    private val quadraticEquation: QuadraticEquation = QuadraticEquation(a, b, c)

    fun calculate(): Roots{
        val d = quadraticEquation.calcDiscriminant()
        if (d < 0){
            throw NegativeDiscriminantException("Discriminant has got a negative value")
        }
        val root1 = quadraticEquation.calcRoot1(d)
        val root2 = quadraticEquation.calcRoot2(d)
        return Roots(root1, root2)
    }

    class Roots(val root1: Double, val root2: Double)
}