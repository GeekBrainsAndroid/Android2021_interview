package ru.geekbrains.viewmodel.network

import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.Type

class LiveDataCallAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        return LiveDataCallAdapter()
    }
}