package ru.geekbrains.rxjavaapplication

import io.reactivex.rxjava3.core.Flowable

class ProducerEvenNumber {
    val evenNumber: EvenNumber = EvenNumber()

    fun run(): Flowable<Int> {
        return Flowable.fromIterable(evenNumber).onBackpressureBuffer()
    }
}

class EvenNumber : Iterable<Int> {
    var current: Int = 0

    override fun iterator(): Iterator<Int> {
        return EvenNumberIterator()
    }

    inner class EvenNumberIterator : Iterator<Int> {
        override fun hasNext(): Boolean {
            return this@EvenNumber.current < 100000
        }

        override fun next(): Int {
            this@EvenNumber.current += 2
            return this@EvenNumber.current
        }
    }
}
