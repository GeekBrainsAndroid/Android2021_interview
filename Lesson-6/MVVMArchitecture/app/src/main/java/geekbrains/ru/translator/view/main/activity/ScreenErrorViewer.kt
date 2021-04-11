package geekbrains.ru.translator.view.main.activity

import android.view.View
import geekbrains.ru.translator.databinding.ActivityMainBinding

class ScreenErrorViewer(binding: ActivityMainBinding, private val error: String) :
    ScreenViewer(binding) {
    override fun showScreen() {
        showViewError()
        binding.errorTextview.text = error
    }

    private fun showViewError() {
        binding.successLinearLayout.visibility = View.GONE
        binding.loadingFrameLayout.visibility = View.GONE
        binding.errorLinearLayout.visibility = View.VISIBLE
    }
}