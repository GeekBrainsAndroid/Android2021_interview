package ru.geekbrains.factory.listview.factory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.geekbrains.factory.R
import ru.geekbrains.factory.listview.ContactViewHolder
import ru.geekbrains.factory.listview.MailContactViewHolder

class MailContactViewHolderFactory : ContactViewHolderFactory {
    override fun createContactViewHolder(parent: ViewGroup): ContactViewHolder {
        val view = inflateViewForHolder(parent)
        return MailContactViewHolder(view)
    }

    override fun inflateViewForHolder(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(R.layout.item_mail, parent, false)

    }
}