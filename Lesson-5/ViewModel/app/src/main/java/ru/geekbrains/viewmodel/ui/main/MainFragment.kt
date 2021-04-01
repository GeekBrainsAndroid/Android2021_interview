package ru.geekbrains.viewmodel.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.viewmodel.ext.android.viewModel
import ru.geekbrains.viewmodel.R
import ru.geekbrains.viewmodel.databinding.MainFragmentBinding
import ru.geekbrains.viewmodel.model.Valute

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        fabInit()
        val adapter = recyclerAdapterInit()
        valutesObserverInit(adapter)
        return binding.root
    }

    private fun valutesObserverInit(adapter: ValuteRecyclerViewAdapter) {
        mainViewModel.valutes.observe(viewLifecycleOwner, Observer<List<Valute>> {
            adapter.valutes = it
            adapter.notifyDataSetChanged()
        })
    }

    private fun recyclerAdapterInit(): ValuteRecyclerViewAdapter {
        val adapter = ValuteRecyclerViewAdapter()
        binding.recyclerViewCbr.adapter = adapter
        DividerItemDecoration(context, LinearLayoutManager.VERTICAL).apply {
            setDrawable(context?.getDrawable(R.drawable.separator)!!)
            binding.recyclerViewCbr.addItemDecoration(this)
        }
        return adapter
    }

    private fun fabInit() {
        binding.fabReload.setOnClickListener {
            mainViewModel.getCurrentValutes()
        }
    }
}