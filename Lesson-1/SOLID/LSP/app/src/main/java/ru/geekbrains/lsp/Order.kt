package ru.geekbrains.lsp

class Order(quantity: Int, price: Double) : OrderAbstract(quantity, price) {
    override fun calcAmount(): Double {
        return quantity * price
    }
}