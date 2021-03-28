package ru.geekbrains.livedata

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import androidx.lifecycle.MutableLiveData

class DataSource {

    var counterString = MutableLiveData<String>()

    fun start(){
        counterString.value = "0"
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
                    counterString.value = counter.toString()
                }
            }
        }
    }


}