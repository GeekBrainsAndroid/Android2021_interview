package ru.geekbrains.myretrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.geekbrains.myretrofit.model.Valute
import ru.geekbrains.myretrofit.retrofit.RetrofitClient
import java.util.*


class MainActivity : AppCompatActivity(), IViewMainActivity {

    private lateinit var adapter: ValuteRecyclerViewAdapter
    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = Presenter(RetrofitClient.getCbrDaily())

        initRecyclerView()
        button.setOnClickListener {
            presenter.request()
        }
    }

    private fun initRecyclerView() {
        adapter = ValuteRecyclerViewAdapter()
        recyclerViewValutes.adapter = adapter
        DividerItemDecoration(this, LinearLayoutManager.VERTICAL).apply {
            setDrawable(getDrawable(R.drawable.separator)!!)
            recyclerViewValutes.addItemDecoration(this)
        }
    }

    override fun onSuccess(date: Date, valutes: List<Valute>) {
        textDate.text = date.toString()
        adapter.valutes = valutes
        adapter.notifyDataSetChanged()
    }

    override fun onFailure() {
        textDate.text = "Failure!"
    }

    override fun onStart() {
        super.onStart()
        presenter.attach(this)
    }

    override fun onStop() {
        presenter.detach()
        super.onStop()
    }
}