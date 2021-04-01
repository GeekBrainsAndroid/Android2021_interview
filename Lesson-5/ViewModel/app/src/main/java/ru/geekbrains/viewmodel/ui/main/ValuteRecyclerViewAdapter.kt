package ru.geekbrains.viewmodel.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.viewmodel.databinding.ItemBinding
import ru.geekbrains.viewmodel.model.Valute


class ValuteRecyclerViewAdapter() : RecyclerView.Adapter<ValuteRecyclerViewAdapter.ValuteHolder>()  {

    var valutes: List<Valute> = listOf()

    class ValuteHolder(private var item: ItemBinding) : RecyclerView.ViewHolder(item.root) {
        fun bind(valute: Valute){
            item.valute = valute
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValuteHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val item = ItemBinding.inflate(layoutInflater, parent, false)
        return ValuteHolder(item)
    }

    override fun getItemCount(): Int = valutes.size

    override fun onBindViewHolder(holder: ValuteHolder, position: Int) {
        val listItem = valutes[position]
        holder.bind(listItem)
    }
}