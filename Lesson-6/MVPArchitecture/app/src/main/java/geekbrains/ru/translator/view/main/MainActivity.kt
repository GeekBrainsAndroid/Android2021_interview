package geekbrains.ru.translator.view.main

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import geekbrains.ru.translator.R
import geekbrains.ru.translator.model.data.AppState
import geekbrains.ru.translator.model.data.DataModel
import geekbrains.ru.translator.presenter.Presenter
import geekbrains.ru.translator.view.base.BaseActivity
import geekbrains.ru.translator.view.base.View
import geekbrains.ru.translator.view.main.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<AppState>() {

    private var adapter: MainAdapter? = null
    private val onListItemClickListener: MainAdapter.OnListItemClickListener =
        object : MainAdapter.OnListItemClickListener {
            override fun onItemClick(data: DataModel) {
                Toast.makeText(this@MainActivity, data.text, Toast.LENGTH_SHORT).show()
            }
        }

    override fun createPresenter(): Presenter<AppState, View> {
        return MainPresenterImpl()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        search_fab.setOnClickListener {
            val searchDialogFragment = SearchDialogFragment.newInstance()
            searchDialogFragment.setOnSearchClickListener(object :
                SearchDialogFragment.OnSearchClickListener {
                override fun onClick(searchWord: String) {
                    presenter.getData(searchWord, true)
                }
            })
            searchDialogFragment.show(supportFragmentManager, BOTTOM_SHEET_FRAGMENT_DIALOG_TAG)
        }
    }

    override fun renderData(appState: AppState) {
        val screenViewer: ScreenViewer = when (appState) {
            is AppState.Success -> {
                val dataModel = appState.data
                if (dataModel == null || dataModel.isEmpty()) {
                    ScreenErrorViewer(getString(R.string.empty_server_response_on_success))
                } else {
                    ScreenSuccessViewer(dataModel)
                }
            }
            is AppState.Loading -> {
                ScreenLoadingViewer()
            }
            is AppState.Error -> {
                ScreenErrorViewer(appState.error.message)
            }
        }
        screenViewer.showScreen()
    }

    private interface ScreenViewer{
        fun showScreen()
    }

    private inner class ScreenErrorViewer(private val error: String?) : ScreenViewer{
        override fun showScreen() {
            showViewError()
            error_textview.text = error ?: getString(R.string.undefined_error)
            reload_button.setOnClickListener {
                presenter.getData("hi", true)
            }
        }

        private fun showViewError() {
            success_linear_layout.visibility = GONE
            loading_frame_layout.visibility = GONE
            error_linear_layout.visibility = VISIBLE
        }
    }

    private inner class ScreenSuccessViewer(val dataModel: List<DataModel>) : ScreenViewer{
        override fun showScreen() {
            showViewSuccess()
            if (adapter == null) {
                adapter = createAdapter()
                setAdapterToRecyclerView()
            }
            adapter!!.setData(dataModel)
        }

        private fun createAdapter() : MainAdapter {
            val adapter = MainAdapter(onListItemClickListener)
            return adapter
        }

        private fun setAdapterToRecyclerView(){
            main_activity_recyclerview.layoutManager =
                LinearLayoutManager(applicationContext)
            main_activity_recyclerview.adapter = adapter
        }

        private fun showViewSuccess() {
            success_linear_layout.visibility = VISIBLE
            loading_frame_layout.visibility = GONE
            error_linear_layout.visibility = GONE
        }
    }

    private inner class ScreenLoadingViewer() : ScreenViewer {
        override fun showScreen() {
            showViewLoading()
            progress_bar_horizontal.visibility = GONE
            progress_bar_round.visibility = VISIBLE
        }

        private fun showViewLoading() {
            success_linear_layout.visibility = GONE
            loading_frame_layout.visibility = VISIBLE
            error_linear_layout.visibility = GONE
        }
    }

    companion object {
        private const val BOTTOM_SHEET_FRAGMENT_DIALOG_TAG =
            "74a54328-5d62-46bf-ab6b-cbf5fgt0-092395"
    }
}
