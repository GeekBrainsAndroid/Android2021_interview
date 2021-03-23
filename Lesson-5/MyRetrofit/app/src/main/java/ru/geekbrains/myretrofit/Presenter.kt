package ru.geekbrains.myretrofit

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.geekbrains.myretrofit.retrofit.CbrDaily
import ru.geekbrains.myretrofit.model.Daily

class Presenter constructor(private val cbrDaily: CbrDaily) {

    private var view: IViewMainActivity? = null
    private var daily: Daily? = null

    fun attach(view: IViewMainActivity) {
        this.view = view
    }

    fun detach() {
        view = null
    }

    fun request() {
        if (view == null) {
            return
        }
        cbrDaily.loadDailyValute()
            .enqueue(object : Callback<Daily> {
                override fun onFailure(call: Call<Daily>, t: Throwable) {
                    view?.let { it.onFailure() }
                }

                override fun onResponse(call: Call<Daily>, response: Response<Daily>) {
                    if (response.isSuccessful && response.body() != null) {
                        val daily = response.body()!!
                        view?.let { it.onSuccess(daily.date, daily.valute.values.toList()) }
                    } else {
                        view?.let { it.onFailure() }
                    }
                }
            })
    }
}