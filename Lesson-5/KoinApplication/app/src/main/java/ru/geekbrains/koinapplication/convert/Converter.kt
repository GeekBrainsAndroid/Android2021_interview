package ru.geekbrains.koinapplication.convert

class Converter constructor(private val convertTo: IConvertTo) :
    IConverter {

    override fun convert(value: Int): Double {
        return convertTo.calc(value.toDouble())
    }
}