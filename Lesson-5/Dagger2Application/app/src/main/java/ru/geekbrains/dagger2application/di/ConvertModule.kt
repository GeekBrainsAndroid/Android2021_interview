package ru.geekbrains.dagger2application.di

import dagger.Module
import dagger.Provides
import ru.geekbrains.dagger2application.convert.ConvertVelocity
import ru.geekbrains.dagger2application.convert.Converter
import ru.geekbrains.dagger2application.convert.IConvertTo
import ru.geekbrains.dagger2application.convert.IConverter

@Module
class ConvertModule {
    @Provides
    fun provideConverter(convertTo: IConvertTo): IConverter {
        return Converter(convertTo)
    }

    @Provides
    fun provideConvertVelocity(): IConvertTo {
        return ConvertVelocity()
    }
}