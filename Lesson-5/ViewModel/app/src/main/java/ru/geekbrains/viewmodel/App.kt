package ru.geekbrains.viewmodel

import android.app.Application
import org.koin.core.context.startKoin
import ru.geekbrains.viewmodel.di.appModule

class App : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin{
            modules(appModule)
        }
    }
}