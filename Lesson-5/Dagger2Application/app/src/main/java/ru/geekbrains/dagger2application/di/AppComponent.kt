package ru.geekbrains.dagger2application.di

import dagger.Component
import ru.geekbrains.dagger2application.convert.ConvertVelocity
import ru.geekbrains.dagger2application.convert.Converter
import ru.geekbrains.dagger2application.MainActivity
import ru.geekbrains.dagger2application.MainPresenter2
import javax.inject.Singleton

@Singleton
@Component(modules = [ConvertModule::class, AppModule::class, PresenterModule::class, Presenter2Module::class])
interface AppComponent {
    fun getConverter(): Converter
    fun getConvertVelocity(): ConvertVelocity

    fun inject(act: MainActivity)
    fun inject(pres2: MainPresenter2)
}