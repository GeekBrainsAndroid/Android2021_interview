package ru.geekbrains.aidlservice

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        return AidlFiboImpl()
    }
}