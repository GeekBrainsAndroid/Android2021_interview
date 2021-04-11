package geekbrains.ru.translator.view.base

import geekbrains.ru.translator.model.data.AppState

interface View {
    fun renderData(appState: AppState)
}
