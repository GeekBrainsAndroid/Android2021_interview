package geekbrains.ru.translator.view.base

import androidx.appcompat.app.AppCompatActivity
import geekbrains.ru.translator.model.data.AppState
import geekbrains.ru.translator.viewmodel.BaseViewModel
import geekbrains.ru.translator.viewmodel.Interactor

abstract class BaseActivity<T : AppState, I : Interactor<T>> : AppCompatActivity() {

    abstract val model: BaseViewModel<T>

    abstract fun renderData(dataModel: T)
}
