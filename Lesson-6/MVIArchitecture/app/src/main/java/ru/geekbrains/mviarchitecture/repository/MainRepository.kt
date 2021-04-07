package ru.geekbrains.mviarchitecture.repository

import ru.geekbrains.mviarchitecture.network.ApiHelper

class MainRepository(private val apiHelper: ApiHelper)
{
    suspend fun getDaily() = apiHelper.getDaily()
}