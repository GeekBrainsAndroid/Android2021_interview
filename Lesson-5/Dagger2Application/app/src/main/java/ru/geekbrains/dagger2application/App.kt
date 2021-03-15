package ru.geekbrains.dagger2application

import android.app.Application
import ru.geekbrains.dagger2application.di.*

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}


