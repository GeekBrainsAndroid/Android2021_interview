package ru.geekbrains.koinapplication.convert

class ConvertVelocity :
    IConvertTo {

    override fun calc(param: Double): Double {
        return param * 1000 / 3600
    }
}