package ru.geekbrains.livedata

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

class DataSource {

    var counterInt = MutableLiveData<Int>()
    var counterString: LiveData<String> = Transformations.map(counterInt) {
        it.toString()
    }

    fun start(){
        counterInt.value = 0
        val handlerThread = HandlerThread("MyHandler")
        handlerThread.start()
        val handler = Handler(handlerThread.looper)
        val handlerUi = Handler(Looper.myLooper()!!)
        handler.post {
            var counter = 0
            while (counter < Int.MAX_VALUE) {
                Thread.sleep(1000)
                counter++
                handlerUi.post {
                    counterInt.value = counter
                }
            }
        }
    }
}