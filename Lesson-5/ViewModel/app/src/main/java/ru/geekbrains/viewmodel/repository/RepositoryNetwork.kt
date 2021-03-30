package ru.geekbrains.viewmodel.repository

import androidx.lifecycle.LiveData
import ru.geekbrains.viewmodel.model.Valute
import ru.geekbrains.viewmodel.network.CbrDaily

class RepositoryNetwork(private val cbrDaily: CbrDaily): IRepositoryCbr {
    override fun getValutes(): LiveData<List<Valute>> {
        return cbrDaily.loadDailyValute()
    }
}