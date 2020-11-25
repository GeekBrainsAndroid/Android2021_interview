package ru.geekbrains.lsp

class FreeOrder(quantity : Int, price : Double) : Order(quantity, price) {
    override fun calcAmount(): Double {
        return 0.0
    }
}