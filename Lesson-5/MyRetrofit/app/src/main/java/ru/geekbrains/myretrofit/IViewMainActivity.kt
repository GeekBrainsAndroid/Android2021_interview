package ru.geekbrains.myretrofit

import ru.geekbrains.myretrofit.model.Valute
import java.util.*

interface IViewMainActivity {
    fun onSuccess(date: Date, valutes: List<Valute>)
    fun onFailure()
}