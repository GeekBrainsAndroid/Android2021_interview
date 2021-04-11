package geekbrains.ru.translator.view.main.activity

import android.view.View
import geekbrains.ru.translator.databinding.ActivityMainBinding
import geekbrains.ru.translator.model.data.DataModel
import geekbrains.ru.translator.view.main.adapter.MainAdapter

class ScreenSuccessViewer(
    binding: ActivityMainBinding,
    private val onListItemClickListener: MainAdapter.OnListItemClickListener,
    private val dataModel: List<DataModel>
) : ScreenViewer(binding) {

    override fun showScreen() {
        showViewSuccess()
        if (binding.mainActivityRecyclerview.adapter == null) {
            val adapter = createAdapter()
            binding.mainActivityRecyclerview.adapter = adapter
        }
        (binding.mainActivityRecyclerview.adapter as MainAdapter).setData(dataModel)
    }

    private fun createAdapter(): MainAdapter {
        val adapter = MainAdapter(
            onListItemClickListener
        )
        return adapter
    }

    private fun showViewSuccess() {
        binding.successLinearLayout.visibility = View.VISIBLE
        binding.loadingFrameLayout.visibility = View.GONE
        binding.errorLinearLayout.visibility = View.GONE
    }
}