package ru.geekbrains.mviarchitecture.ui

sealed class MainIntent
{
    object FetchDaily : MainIntent()

    object Test: MainIntent()

    object TestData: MainIntent()

}

