package ru.geekbrains.rxjavaapplication

import io.reactivex.rxjava3.core.Observable

class ProducerNaturalRow {
    fun run(): Observable<Int> {
        return Observable.create<Int> { emitter ->

            var current: Int = 0
            do {
                current++
                emitter.onNext(current)
                Thread.sleep(10)
            } while (current <= 1_000)

            emitter.onComplete()
        }
    }
}