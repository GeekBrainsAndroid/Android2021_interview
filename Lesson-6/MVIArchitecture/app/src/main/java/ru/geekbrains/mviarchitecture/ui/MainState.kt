package ru.geekbrains.mviarchitecture.ui

import ru.geekbrains.mviarchitecture.ui.model.Model

sealed class MainState {
    object Idle : MainState()
    object Loading : MainState()
    data class DailyData(val dailyModel: Model) : MainState()
    data class Error(val error: String?) : MainState()
    object Test : MainState()
}