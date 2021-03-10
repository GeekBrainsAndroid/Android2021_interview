package ru.geekbrains.rxjavaapplication

import io.reactivex.rxjava3.core.Completable
import java.lang.RuntimeException
import kotlin.random.Random

class ProducerCompletable {
    fun run() : Completable {
        return Completable.create {
            Thread.sleep(5_000)
            if (Random.nextBoolean()){
                it.onComplete()
            }else{
                it.onError(RuntimeException())
            }
        }
    }
}