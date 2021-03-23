package ru.geekbrains.myretrofit.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val Url = "https://www.cbr-xml-daily.ru/"

object RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getCbrDaily(): CbrDaily {
        if (retrofit == null) {
            val client = OkHttpClient.Builder()
                .addInterceptor(LoggingInterceptor())
                .build()

            retrofit = Retrofit.Builder()
                .baseUrl(Url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        return retrofit!!.create(CbrDaily::class.java)
    }
}