package ru.geekbrains.customnavigation.flownavigation.mainflow

import ru.geekbrains.customnavigation.flownavigation.base.Navigation

interface MainNavigation : Navigation {
    fun toList()
    fun toSettings()
}