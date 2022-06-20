package ru.geekbrains.mviarchitecture.ui.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ru.geekbrains.mviarchitecture.R
import ru.geekbrains.mviarchitecture.network.ApiHelperImpl
import ru.geekbrains.mviarchitecture.network.RetrofitBuilder
import ru.geekbrains.mviarchitecture.ui.*
import ru.geekbrains.mviarchitecture.ui.model.Model
import ru.geekbrains.mviarchitecture.ui.model.Valute
import ru.geekbrains.mviarchitecture.ui.viewmodel.MainViewModel
import ru.geekbrains.mviarchitecture.ui.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private var adapter = MainAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initViewModel()
        observeViewModel()
    }

    private fun initView(){
        initRecycler()
        initClick()
    }

    private fun initClick() {
        buttonFetchUser.setOnClickListener {
            lifecycleScope.launch {
                mainViewModel.userIntent.send(MainIntent.FetchDaily)
            }
        }

        buttonTest.setOnClickListener {
            lifecycleScope.launch {
                mainViewModel.userIntent.send(MainIntent.NewTest)
              //  mainViewModel.userIntent.send(MainIntent.Test)
              //  mainViewModel.userIntent.send(MainIntent.TestData)
            }
        }

    }

    private fun initRecycler() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.run {
            addItemDecoration(
                DividerItemDecoration(
                    recyclerView.context,
                    (recyclerView.layoutManager as
                            LinearLayoutManager).orientation
                )
            )
        }
        recyclerView.adapter = adapter
    }

    private fun initViewModel() {
        mainViewModel =
            ViewModelProviders.of(this, ViewModelFactory(ApiHelperImpl(RetrofitBuilder.apiService)))
                .get(MainViewModel::class.java)
    }

    private fun observeViewModel() {

        lifecycleScope.launchWhenStarted {
            mainViewModel.event
                .onEach { handleSingleEvent(it) }
                .catch { }
                .collect()
        }



        lifecycleScope.launch {
            mainViewModel.state.collect {
                when (it) {
                    is MainState.Idle -> {
                    }
                    is MainState.Loading -> {
                        renderLoading()
                    }
                    is MainState.DailyData -> {
                        renderData(it)
                    }
                    is MainState.Error -> {
                        renderError(it)
                    }
                    is MainState.Test -> {
                        test()
                    }

                    is MainState.TestData -> {
                        testData(it)
                    }
                }
            }
        }
    }

    private fun handleSingleEvent(it: MainIntent) {
        println("NewTest Activity")
    }

    private fun testData(it: MainState.TestData) {
        println("TestData Activity ${it.i}")
    }

    private fun test() {
        println("Test Activity")
    }

    private fun renderError(it: MainState.Error) {
        progressBar.visibility = View.GONE
        buttonFetchUser.visibility = View.VISIBLE
        Toast.makeText(
            this@MainActivity, it.error,
            Toast.LENGTH_LONG
        ).show()
    }

    private fun renderLoading() {
        buttonFetchUser.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    private fun renderData(data: MainState.DailyData) {
        val model: Model = data.dailyModel
        progressBar.visibility = View.GONE
        buttonFetchUser.visibility = View.GONE
        renderList(model.valutes)
    }

    private fun renderList(valutes: List<Valute>) {
        recyclerView.visibility = View.VISIBLE
        adapter.addData(valutes)
        adapter.notifyDataSetChanged()
    }
}