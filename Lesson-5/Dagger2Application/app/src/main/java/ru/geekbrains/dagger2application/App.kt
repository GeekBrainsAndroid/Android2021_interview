package ru.geekbrains.dagger2application

import android.app.Application
import ru.geekbrains.dagger2application.di.*

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var component: AppComponent
    var activityComponent: ActivityComponent? = null

    override fun onCreate() {
        super.onCreate()
        instance = this

        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    fun addActivityComponent(): ActivityComponent {
        if (activityComponent == null){
            activityComponent = component.addActivityComponent(ActivityModule())
        }
        return activityComponent!!
    }

    fun clearActivityComponent() {
        activityComponent = null
    }
}


