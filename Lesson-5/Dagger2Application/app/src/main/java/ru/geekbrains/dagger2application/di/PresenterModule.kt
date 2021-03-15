package ru.geekbrains.dagger2application.di

import dagger.Module
import dagger.Provides
import ru.geekbrains.dagger2application.convert.IConverter
import ru.geekbrains.dagger2application.MainPresenter
import javax.inject.Singleton

@Module
class PresenterModule {
    @Singleton
    @Provides
    fun getMainPresenter(converter: IConverter): MainPresenter {
        return MainPresenter(converter)
    }
}