package ru.geekbrains.customnavigation.flownavigation.listflow

import ru.geekbrains.customnavigation.flownavigation.base.Navigation

interface ListNavigation : Navigation {
    fun toList()
    fun toDetails(parameter: String)
    fun toSettings()
}