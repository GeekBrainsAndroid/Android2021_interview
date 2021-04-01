package ru.geekbrains.viewmodellivedatabinding.di

import org.koin.dsl.module
import ru.geekbrains.viewmodellivedatabinding.ui.main.MainViewModel

val appModule = module {
    single { MainViewModel() }
}