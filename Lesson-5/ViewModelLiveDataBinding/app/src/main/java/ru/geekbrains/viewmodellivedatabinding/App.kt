package ru.geekbrains.viewmodellivedatabinding

import android.app.Application
import org.koin.core.context.startKoin
import ru.geekbrains.viewmodellivedatabinding.di.appModule

class App : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin{
            modules(appModule)
        }
    }
}