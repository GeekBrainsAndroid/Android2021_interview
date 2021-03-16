package ru.geekbrains.dagger2application

import ru.geekbrains.dagger2application.convert.IConverter
import javax.inject.Inject

class MainPresenter @Inject constructor(private val converter: IConverter) : IMainPresenter {
    private var view: MainView? = null

    init {
        countInstances++
    }

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

    override fun getCountInstance() {
        if (view == null){
            return
        }
        view!!.countInstancePresenter1(countInstances)
    }

    companion object{
        var countInstances: Int = 0
    }
}