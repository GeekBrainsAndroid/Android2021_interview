package ru.geekbrains.viewmodellivedatabinding.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var cnt: MutableLiveData<Int> = MutableLiveData(0)

    fun count(){
        cnt.postValue(cnt.value!! + 1)
    }
}