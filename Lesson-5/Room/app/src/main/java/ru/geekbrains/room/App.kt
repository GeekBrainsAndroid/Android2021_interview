package ru.geekbrains.room

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.geekbrains.room.di.appModule

class App : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@App)
            modules(appModule)
        }
    }
}