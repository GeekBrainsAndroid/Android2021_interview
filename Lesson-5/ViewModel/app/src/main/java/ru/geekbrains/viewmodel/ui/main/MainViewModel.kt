package ru.geekbrains.viewmodel.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.viewmodel.model.Valute
import ru.geekbrains.viewmodel.repository.IRepositoryCbr

class MainViewModel(private val repositoryNetwork: IRepositoryCbr) : ViewModel() {

    var valutes = MutableLiveData<List<Valute>>(listOf())

    init{
        getCurrentValutes()
    }

    fun getCurrentValutes(){
        repositoryNetwork.getValutes().observeForever {
            valutes.postValue(it)
        }
    }
}