package ru.geekbrains.lsp

class OrderFactory {
    fun create(quantity: Int, price: Double): Order{
        return FreeOrder(quantity, price)
    }
}