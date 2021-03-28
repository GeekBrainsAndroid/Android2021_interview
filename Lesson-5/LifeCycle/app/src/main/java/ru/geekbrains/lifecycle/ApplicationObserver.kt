package ru.geekbrains.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class ApplicationObserver : LifecycleObserver {
    private val tag = "ApplicationObserver"

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun events(owner: LifecycleOwner, event: Lifecycle.Event) {
        Log.d(tag, "Event $event")
    }
}