package ru.geekbrains.strategy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_digit.view.*
import ru.geekbrains.strategy.ListRecyclerViewAdapter.ViewHolder
import ru.geekbrains.strategy.data.DigitList

class ListRecyclerViewAdapter(private val digitList: DigitList): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_digit, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = digitList.count

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(digitList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val digit: TextView = itemView.textDigit

        fun setData(value: Int){
            digit.text = value.toString()
        }
    }
}