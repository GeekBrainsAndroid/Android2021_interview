package ru.geekbrains.factory.listview.data

import ru.geekbrains.factory.data.MailContact
import ru.geekbrains.factory.listview.factory.ContactViewHolderFactory

class MailContactView(name: String, override val creatorContactViewHolder: ContactViewHolderFactory) : MailContact(name), IContactView {
}