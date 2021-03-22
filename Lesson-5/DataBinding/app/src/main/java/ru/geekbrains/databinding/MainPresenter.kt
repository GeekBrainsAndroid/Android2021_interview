package ru.geekbrains.databinding

class MainPresenter(private val view: IViewMainActivity) {

    var sourceValue: String = "0"
    var resultValue: String = ""

    fun convert() {
        val source = sourceValue.toDouble()
        val result = source * 1000.0 / 3600.0
        resultValue = result.toString()
        view.renderData()
    }
}