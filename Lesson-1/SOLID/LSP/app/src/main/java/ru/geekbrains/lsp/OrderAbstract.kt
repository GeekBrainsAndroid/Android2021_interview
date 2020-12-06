package ru.geekbrains.lsp

abstract class OrderAbstract(protected val quantity: Int, protected val price: Double) : Orderable {
    override fun isAvailable(): Boolean {
        return quantity > 0
    }
}