package ru.geekbrains.dagger2application.di

import dagger.Module
import dagger.Provides
import ru.geekbrains.dagger2application.IMainPresenter
import ru.geekbrains.dagger2application.convert.IConverter
import ru.geekbrains.dagger2application.MainPresenter
import javax.inject.Named
import javax.inject.Singleton

const val namepresenter1 = "presenter1"

@Module
class PresenterModule {
    @Singleton
    @Named(namepresenter1)
    @Provides
    fun getMainPresenter(converter: IConverter): IMainPresenter {
        return MainPresenter(converter)
    }
}