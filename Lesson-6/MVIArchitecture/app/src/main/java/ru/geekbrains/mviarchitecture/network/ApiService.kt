package ru.geekbrains.mviarchitecture.network

import retrofit2.http.GET
import ru.geekbrains.mviarchitecture.network.model.Daily

interface ApiService {
    @GET("daily_json.js")
    suspend fun getDaily(): Daily
}