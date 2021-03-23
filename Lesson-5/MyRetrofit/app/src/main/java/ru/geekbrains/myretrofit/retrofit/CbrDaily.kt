package ru.geekbrains.myretrofit.retrofit

import retrofit2.Call
import retrofit2.http.GET
import ru.geekbrains.myretrofit.model.Daily

//https://www.cbr-xml-daily.ru/daily_json.js
interface CbrDaily {
    @GET("daily_json.js")
    fun loadDailyValute(): Call<Daily>
}