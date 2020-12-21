package ru.geekbrains.factory.listview.data

import ru.geekbrains.factory.data.PhoneContact
import ru.geekbrains.factory.listview.factory.ContactViewHolderFactory

class PhoneContactView(name: String, override val creatorContactViewHolder: ContactViewHolderFactory) : PhoneContact(name), IContactView {
}