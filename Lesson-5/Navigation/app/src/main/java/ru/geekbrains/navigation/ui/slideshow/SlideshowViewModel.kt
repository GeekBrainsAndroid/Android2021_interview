package ru.geekbrains.navigation.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    val text = MutableLiveData<String>().apply {
        value = "This is slideshow Fragment"
    }
}