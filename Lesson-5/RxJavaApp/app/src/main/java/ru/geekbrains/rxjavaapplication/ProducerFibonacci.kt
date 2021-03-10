package ru.geekbrains.rxjavaapplication

import io.reactivex.rxjava3.core.Observable

class ProducerFibonacci {
    private var prev: Int = 0
    private var current: Int = 1

    private fun getFibonacci(): Int {
        Thread.sleep(100)
        val temp = current
        current += prev
        prev = temp
        if (current > 10000){
            prev = 0
            current = 1
        }
        return current
    }

    fun run(): Observable<Int> {
        return Observable.fromCallable{
            return@fromCallable getFibonacci()
        }
    }
}