package ru.geekbrains.koinapplication.di

import org.koin.dsl.module
import ru.geekbrains.koinapplication.IMainPresenter
import ru.geekbrains.koinapplication.MainPresenter
import ru.geekbrains.koinapplication.convert.ConvertVelocity
import ru.geekbrains.koinapplication.convert.Converter
import ru.geekbrains.koinapplication.convert.IConvertTo
import ru.geekbrains.koinapplication.convert.IConverter

val appModule = module {
    single<IConvertTo> { ConvertVelocity() }
    single<IConverter> { Converter(get()) }

    factory<IMainPresenter> { MainPresenter(get()) }
}