package ru.geekbrains.dagger2application.di

import dagger.Module
import dagger.Provides
import ru.geekbrains.dagger2application.App
import javax.inject.Singleton

@Module
class AppModule(val app: App) {
    @Provides
    fun app(): App {
        return app
    }

}