package ru.geekbrains.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class ActivityObserver : LifecycleObserver {
    private val tag = "ActivityObserver"

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun eventStart(){
        Log.d(tag, "Event start")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun eventResume() {
        Log.d(tag, "Event resume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun eventPause() {
        Log.d(tag, "Event pause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun eventStop(){
        Log.d(tag, "Event stop")
    }
}

