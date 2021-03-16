package ru.geekbrains.dagger2application

import javax.inject.Inject

class ConvertHelper @Inject constructor() {

    private var view: MainView? = null

    init {
        countInstances++
    }

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

    fun getCountInstance() {
        if (view == null){
            return
        }
        view!!.countInstanceConvertHelper(countInstances)
    }

    companion object{
        var countInstances: Int = 0
    }
}