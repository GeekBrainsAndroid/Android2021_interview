package ru.geekbrains.mviarchitecture.network

import ru.geekbrains.mviarchitecture.network.model.Daily

interface ApiHelper {
    suspend fun getDaily(): Daily
}