package ru.geekbrains.mviarchitecture.mapping

import ru.geekbrains.mviarchitecture.network.model.Valute

fun Valute.map(): ru.geekbrains.mviarchitecture.ui.model.Valute {
    return ru.geekbrains.mviarchitecture.ui.model.Valute(this.charCode, this.name)
}

fun Map<String, Valute>.map(): List<ru.geekbrains.mviarchitecture.ui.model.Valute> {
    return this.map {
        it.value.map()
    }
}