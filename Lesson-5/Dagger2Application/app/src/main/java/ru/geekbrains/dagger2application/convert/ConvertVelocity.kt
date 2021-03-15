package ru.geekbrains.dagger2application.convert

import javax.inject.Inject

class ConvertVelocity @Inject constructor() :
    IConvertTo {

    override fun calc(param: Double): Double {
        return param * 1000 / 3600
    }
}