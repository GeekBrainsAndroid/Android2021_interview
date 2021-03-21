package ru.geekbrains.koinapplication

import ru.geekbrains.koinapplication.convert.IConverter

class MainPresenter constructor(private val converter: IConverter) : IMainPresenter {
    private var view: MainView? = null

    override fun attach(view: MainView) {
        if (this.view != view) {
            this.view = view
        }
    }

    override fun detach(view: MainView) {
        if (this.view == view) {
            this.view = null
        }
    }

    override fun convert(){
        if (view == null){
            return
        }
        val value = view!!.value
        val result = converter.convert(value)
        view!!.renderResult(result)
    }
}