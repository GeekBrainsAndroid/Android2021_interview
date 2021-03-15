package ru.geekbrains.dagger2application

import ru.geekbrains.dagger2application.convert.IConverter
import javax.inject.Inject

class MainPresenter @Inject constructor(private val converter: IConverter) {
    private var view: MainView? = null

    fun attach(view: MainView) {
        if (this.view != view) {
            this.view = view
        }
    }

    fun detach(view: MainView) {
        if (this.view == view) {
            this.view = null
        }
    }

    fun convert(){
        if (view == null){
            return
        }
        val value = view!!.value
        val result = converter.convert(value)
        view!!.renderResult(result)
    }
}