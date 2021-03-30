package ru.geekbrains.viewmodel.network

import androidx.lifecycle.LiveData
import retrofit2.http.GET
import ru.geekbrains.viewmodel.model.Valute

//https://www.cbr-xml-daily.ru/daily_json.js
interface CbrDaily {
    @GET("daily_json.js")
    fun loadDailyValute(): LiveData<List<Valute>>
}