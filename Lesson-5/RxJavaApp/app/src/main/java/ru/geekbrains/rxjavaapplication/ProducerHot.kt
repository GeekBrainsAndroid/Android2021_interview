package ru.geekbrains.rxjavaapplication

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ProducerHot {
    fun run() = Observable
            .interval(1, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.computation())
            .publish()
}