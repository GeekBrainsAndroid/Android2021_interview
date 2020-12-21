package ru.geekbrains.strategy.data

import kotlin.random.Random

class DigitList(private val sorter: SortableStrategy) {

    private val digits = mutableListOf<Int>()
    val count: Int
        get() = digits.size

    constructor(list: List<Int>, sorter: SortableStrategy) : this(sorter) {
        for (element in list){
            digits.add(element)
        }
    }

    fun initRandom(){
        val rnd = Random
        for (x in 0 until 10) {
            digits.add(rnd.nextInt(10))
        }
    }

    operator fun get(index: Int) = digits[index]

    fun sort(): DigitList{
        val list: MutableList<Int> = MutableList(count) {i -> this[i]}

        sorter.sort(list)

        return DigitList(list, sorter)
    }
}