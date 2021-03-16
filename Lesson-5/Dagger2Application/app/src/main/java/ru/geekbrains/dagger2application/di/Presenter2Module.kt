package ru.geekbrains.dagger2application.di

import dagger.Module
import dagger.Provides
import ru.geekbrains.dagger2application.IMainPresenter
import ru.geekbrains.dagger2application.MainPresenter
import ru.geekbrains.dagger2application.MainPresenter2
import ru.geekbrains.dagger2application.convert.IConverter
import javax.inject.Named

const val namepresenter2 = "presenter2"

@Module
class Presenter2Module {
    @Named(namepresenter2)
    @Provides
    fun getMainPresenter(): IMainPresenter {
        return MainPresenter2()
    }
}