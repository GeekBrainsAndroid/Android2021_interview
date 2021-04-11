package geekbrains.ru.translator.view.main.activity

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import geekbrains.ru.translator.R
import geekbrains.ru.translator.databinding.ActivityMainBinding
import geekbrains.ru.translator.model.data.AppState
import geekbrains.ru.translator.model.data.DataModel
import geekbrains.ru.translator.view.base.BaseActivity
import geekbrains.ru.translator.view.main.MainInteractor
import geekbrains.ru.translator.view.main.MainViewModel
import geekbrains.ru.translator.view.main.SearchDialogFragment
import geekbrains.ru.translator.view.main.adapter.MainAdapter

class MainActivity : BaseActivity<AppState, MainInteractor>() {

    override val model: MainViewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)
    }
    private val observer = Observer<AppState> { renderData(it) }
    private val onListItemClickListener: MainAdapter.OnListItemClickListener =
        object : MainAdapter.OnListItemClickListener {
            override fun onItemClick(data: DataModel) {
                Toast.makeText(this@MainActivity, data.text, Toast.LENGTH_SHORT).show()
            }
        }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.searchFab.setOnClickListener {
            val searchDialogFragment =
                SearchDialogFragment.newInstance()
            searchDialogFragment.setOnSearchClickListener(object :
                SearchDialogFragment.OnSearchClickListener {
                override fun onClick(searchWord: String) {
                    model.getData(searchWord, true).observe(this@MainActivity, observer)
                }
            })
            searchDialogFragment.show(supportFragmentManager,
                BOTTOM_SHEET_FRAGMENT_DIALOG_TAG
            )
        }
        binding.reloadButton.setOnClickListener {
            model.getData("hi", true).observe(this, observer)
        }
    }

    override fun renderData(appState: AppState) {
        val screenViewer: IScreenViewer = when (appState) {
            is AppState.Success -> {
                val data = appState.data
                if (data == null || data.isEmpty()) {
                    ScreenErrorViewer(
                        binding,
                        getString(R.string.empty_server_response_on_success)
                    )
                } else {
                    ScreenSuccessViewer(
                        binding,
                        onListItemClickListener,
                        data
                    )
                }
            }
            is AppState.Loading -> {
                ScreenLoadingViewer(
                    binding
                )
            }
            is AppState.Error -> {
                ScreenErrorViewer(
                    binding,
                    appState.error.message ?: getString(R.string.undefined_error)
                )
            }
        }
        screenViewer.showScreen()
    }

    companion object {
        private const val BOTTOM_SHEET_FRAGMENT_DIALOG_TAG =
            "74a54328-5d62-46bf-ab6b-cbf5fgt0-092395"
    }
}

