package ru.geekbrains.factory.listview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.factory.listview.data.DataViewContacts

class ContactListAdapter(private val data: DataViewContacts) : RecyclerView.Adapter<ContactViewHolder>() {

    override fun getItemViewType(position: Int): Int {
         return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ContactViewHolder {
        return data.items[position].creatorContactViewHolder.createContactViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bindData(data.items[position].name)
    }
}