package ru.geekbrains.koinapplication

import android.app.Application
import org.koin.core.context.startKoin
import ru.geekbrains.koinapplication.di.appModule

class App : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin{
            modules(appModule)
        }
    }
}