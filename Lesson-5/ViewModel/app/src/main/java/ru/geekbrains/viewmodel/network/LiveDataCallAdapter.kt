package ru.geekbrains.viewmodel.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import ru.geekbrains.viewmodel.model.Daily
import ru.geekbrains.viewmodel.model.Valute
import java.lang.reflect.Type


class LiveDataCallAdapter :
    CallAdapter<Daily, LiveData<List<Valute>>> {
    override fun adapt(call: Call<Daily>): LiveData<List<Valute>> {
        val liveDataResponse: MutableLiveData<List<Valute>> = MutableLiveData<List<Valute>>()
        call.enqueue(object: Callback<Daily>{
            override fun onFailure(call: Call<Daily>, t: Throwable) {
            }

            override fun onResponse(call: Call<Daily>, response: Response<Daily>) {
                if (call.isCanceled())
                {
                    return
                }

                if (response.isSuccessful() && response.body() != null) {
                    liveDataResponse.postValue(response.body()!!.valute.values.toList());
                } else {
                    return
                }
            }

        })
        return liveDataResponse
    }

    override fun responseType(): Type {
        return Daily::class.java
    }
}
