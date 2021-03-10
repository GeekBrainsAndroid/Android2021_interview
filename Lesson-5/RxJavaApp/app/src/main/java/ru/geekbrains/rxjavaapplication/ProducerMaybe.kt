package ru.geekbrains.rxjavaapplication

import io.reactivex.rxjava3.core.Maybe
import kotlin.random.Random

class ProducerMaybe {
    fun run() = Maybe.create<String> {
        when (Random.nextInt(3)){
            0 -> it.onComplete()
            1 -> it.onSuccess("Success")
            else -> it.onError(Exception("Error"))
        }
    }
}