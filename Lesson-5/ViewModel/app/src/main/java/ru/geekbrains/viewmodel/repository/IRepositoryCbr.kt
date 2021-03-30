package ru.geekbrains.viewmodel.repository

import androidx.lifecycle.LiveData
import ru.geekbrains.viewmodel.model.Valute

interface IRepositoryCbr {
    fun getValutes(): LiveData<List<Valute>>
}