package ru.geekbrains.dagger2application.convert

import javax.inject.Inject

class Converter @Inject constructor(private val convertTo: IConvertTo) :
    IConverter {

    override fun convert(value: Int): Double {
        return convertTo.calc(value.toDouble())
    }
}