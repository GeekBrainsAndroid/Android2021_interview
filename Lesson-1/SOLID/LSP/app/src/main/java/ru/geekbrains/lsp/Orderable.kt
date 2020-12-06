package ru.geekbrains.lsp

interface Orderable {
    fun isAvailable(): Boolean
    fun calcAmount(): Double
}