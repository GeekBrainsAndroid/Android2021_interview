package ru.geekbrains.dagger2application.di

import dagger.Subcomponent
import ru.geekbrains.dagger2application.ConvertHelper

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun getConvertHelper(): ConvertHelper
}