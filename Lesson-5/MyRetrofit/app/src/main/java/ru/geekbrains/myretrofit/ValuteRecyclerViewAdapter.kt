package ru.geekbrains.myretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.myretrofit.model.Valute
import kotlinx.android.synthetic.main.item_layout.view.*

class ValuteRecyclerViewAdapter() : RecyclerView.Adapter<ValuteRecyclerViewAdapter.ValuteHolder>()  {

    var valutes: List<Valute> = listOf()

    class ValuteHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtCharCode: TextView = view.textCharCode
        val txtNominal: TextView = view.textNominal
        val txtName: TextView = view.textName
        val txtValue: TextView = view.textValue

        fun bind(valute: Valute){
            txtCharCode.text = valute.charCode
            txtNominal.text = valute.nominal.toString()
            txtName.text = valute.name
            txtValue.text = valute.value.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValuteHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ValuteHolder(itemView)
    }

    override fun getItemCount(): Int = valutes.size

    override fun onBindViewHolder(holder: ValuteHolder, position: Int) {
        val listItem = valutes[position]
        holder.bind(listItem)
    }
}