package ru.geekbrains.dagger2application

import ru.geekbrains.dagger2application.convert.IConverter
import javax.inject.Inject

class MainPresenter2 : IMainPresenter {
    private var view: MainView? = null

    @Inject
    lateinit var converter: IConverter

    init {
        App.instance.component.inject(this)
    }

    override fun attach(view: MainView) {
        this.view = view
    }

    override fun detach(view: MainView) {
        this.view = null
    }

    override fun convert() {
        if (view == null){
            return
        }
        val value = view!!.value2
        val result = converter.convert(value)
        view!!.renderResult2(result)
    }
}