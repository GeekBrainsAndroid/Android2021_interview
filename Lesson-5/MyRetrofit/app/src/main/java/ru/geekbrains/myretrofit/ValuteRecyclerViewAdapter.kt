package ru.geekbrains.myretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.myretrofit.model.Valute
import kotlinx.android.synthetic.main.item_layout.view.*
import ru.geekbrains.myretrofit.databinding.ItemLayoutBinding

class ValuteRecyclerViewAdapter() : RecyclerView.Adapter<ValuteRecyclerViewAdapter.ValuteHolder>()  {

    var valutes: List<Valute> = listOf()

    class ValuteHolder(private var item: ItemLayoutBinding) : RecyclerView.ViewHolder(item.root) {
        fun bind(valute: Valute){
            item.textCharCode.text = valute.charCode
            item.textNominal.text = valute.nominal.toString()
            item.textName.text = valute.name
            item.textValue.text = valute.value.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValuteHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val item = ItemLayoutBinding.inflate(layoutInflater, parent, false)
        return ValuteHolder(item)
    }


    override fun getItemCount(): Int = valutes.size

    override fun onBindViewHolder(holder: ValuteHolder, position: Int) {
        val listItem = valutes[position]
        holder.bind(listItem)
    }
}