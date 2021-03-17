package ru.geekbrains.dagger2application.di

import dagger.Module
import dagger.Provides
import ru.geekbrains.dagger2application.ConvertHelper

@Module
class ActivityModule {
    @Provides
    @ActivityScope
    fun getConvertHelper(): ConvertHelper {
        return ConvertHelper()
    }
}