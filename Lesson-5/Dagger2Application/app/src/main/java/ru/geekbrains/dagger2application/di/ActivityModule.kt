package ru.geekbrains.dagger2application.di

import dagger.Module
import dagger.Provides
import ru.geekbrains.dagger2application.ConvertHelper
import ru.geekbrains.dagger2application.IMainPresenter
import ru.geekbrains.dagger2application.MainPresenter2
import javax.inject.Named

@Module
class ActivityModule {
    @Provides
    fun getConvertHelper(): ConvertHelper {
        return ConvertHelper()
    }
}