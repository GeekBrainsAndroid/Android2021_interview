package ru.geekbrains.mviarchitecture.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*
import ru.geekbrains.mviarchitecture.R
import ru.geekbrains.mviarchitecture.ui.model.Valute


class MainAdapter(private val valutes: ArrayList<Valute>) :
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(valute: Valute) {
            itemView.textCbrCode.text = valute.cbrCode
            itemView.textName.text = valute.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout, parent, false
        )
    )

    override fun getItemCount(): Int = valutes.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(valutes[position])
    }

    fun addData(list: List<Valute>) {
        valutes.addAll(list)
    }
}