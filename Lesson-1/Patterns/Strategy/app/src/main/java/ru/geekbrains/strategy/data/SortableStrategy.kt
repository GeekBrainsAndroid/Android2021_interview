package ru.geekbrains.strategy.data

interface SortableStrategy {
    fun sort(list: MutableList<Int>)
}