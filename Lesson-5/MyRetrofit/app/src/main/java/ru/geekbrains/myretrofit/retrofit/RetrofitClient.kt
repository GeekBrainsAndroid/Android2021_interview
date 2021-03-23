package ru.geekbrains.myretrofit.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val Url = "https://www.cbr-xml-daily.ru/"

object RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getCbrDaily(): CbrDaily {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(CbrDaily::class.java)
    }
}