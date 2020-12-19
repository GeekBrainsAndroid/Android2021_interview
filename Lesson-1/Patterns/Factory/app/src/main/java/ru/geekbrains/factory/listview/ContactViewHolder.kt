package ru.geekbrains.factory.listview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_mail.view.*
import ru.geekbrains.factory.R

abstract class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bindData(text: String){
        val textView = itemView.findViewById<TextView>(R.id.textName)
        textView.text = text
    }
}