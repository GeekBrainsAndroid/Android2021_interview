package ru.geekbrains.rxjavaapplication

import io.reactivex.rxjava3.core.Single

class ProducerSingle {
    fun run(): Single<UserEntity> {
        return Single.fromCallable {
            return@fromCallable UserEntity("John", "Smith")
        }
    }
}

data class UserEntity(val firstName: String, val secondName: String)

data class UserView(val name: String, val surname: String)