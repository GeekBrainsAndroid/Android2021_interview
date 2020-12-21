package ru.geekbrains.factory.listview.data

import ru.geekbrains.factory.data.IContact
import ru.geekbrains.factory.listview.factory.ContactViewHolderFactory

interface IContactView: IContact {
    val creatorContactViewHolder: ContactViewHolderFactory
}