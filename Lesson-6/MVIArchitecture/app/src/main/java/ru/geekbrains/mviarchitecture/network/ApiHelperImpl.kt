package ru.geekbrains.mviarchitecture.network

import ru.geekbrains.mviarchitecture.network.model.Daily

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {
    override suspend fun getDaily(): Daily {
        return apiService.getDaily()
    }
}