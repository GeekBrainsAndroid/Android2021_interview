package ru.geekbrains.rxjavaapplication

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

class ProducerOddNumber {
    fun run(): Observable<Long>{
        return Observable.interval(1, TimeUnit.SECONDS).filter {
            it % 2 == 1L
        }
    }
}