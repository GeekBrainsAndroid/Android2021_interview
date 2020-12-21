package ru.geekbrains.factory.listview.factory

import android.content.Context
import android.view.View
import android.view.ViewGroup
import ru.geekbrains.factory.listview.ContactViewHolder

interface ContactViewHolderFactory {
    fun createContactViewHolder(parent: ViewGroup): ContactViewHolder
    fun inflateViewForHolder(parent: ViewGroup): View
}