package ru.geekbrains.strategy.data

import kotlin.random.Random

class DigitList() {

    private val digits = mutableListOf<Int>()
    val count: Int
        get() = digits.size

    constructor(list: List<Int>) : this() {
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

        for (i in 1 until list.size){
            val temp = list[i]
            var j = i - 1
            while (j >= 0 && list[j] > temp){
                list[j + 1] = list[j]
                j--
            }
            list[j + 1] = temp
        }

        return DigitList(list)
    }
}