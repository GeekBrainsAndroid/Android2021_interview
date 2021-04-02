package ru.geekbrains.room.ui.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.viewmodel.ext.android.viewModel
import ru.geekbrains.room.R
import ru.geekbrains.room.database.Note
import ru.geekbrains.room.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: MainFragmentBinding
    private lateinit var adapter: NotesRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        fabInit()
        val adapter = recyclerAdapterInit()
        valutesObserverInit(adapter)
        return binding.root
    }

    private fun valutesObserverInit(adapter: NotesRecyclerViewAdapter) {
        viewModel.notes.observe(viewLifecycleOwner, Observer<List<Note>> {
            adapter.notes = it
            adapter.notifyDataSetChanged()
        })
    }

    private fun recyclerAdapterInit(): NotesRecyclerViewAdapter {
        adapter = NotesRecyclerViewAdapter(this)
        binding.recyclerView.adapter = adapter
        DividerItemDecoration(context, LinearLayoutManager.VERTICAL).apply {
            setDrawable(context?.getDrawable(R.drawable.separator)!!)
            binding.recyclerView.addItemDecoration(this)
        }
        return adapter
    }

    private fun fabInit() {
        binding.fabAdd.setOnClickListener {
            viewModel.add()
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        //super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = requireActivity().menuInflater
        inflater.inflate(R.menu.item_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.update_context -> {
                viewModel.update(adapter.menuPosition)
            }
            R.id.remove_context -> {
                viewModel.removeNote(adapter.menuPosition)
            }
        }
        return super.onContextItemSelected(item)
    }
}