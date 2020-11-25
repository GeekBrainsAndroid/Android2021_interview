package ru.geekbrains.lsp

open class Order(private val quantity: Int, private val price: Double) : Orderable {
    override fun isAvailable(): Boolean {
        return quantity > 0
    }

    open fun calcAmount(): Double {
        return quantity * price
    }
}