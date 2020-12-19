package ru.geekbrains.factory.listview.data

import ru.geekbrains.factory.data.DataSourceContacts
import ru.geekbrains.factory.data.IContact
import ru.geekbrains.factory.data.MailContact
import ru.geekbrains.factory.listview.factory.MailContactViewHolderFactory
import ru.geekbrains.factory.listview.factory.PhoneContactViewHolderFactory

class DataViewContacts(data: DataSourceContacts) {

    val items: List<IContactView>

    init{
        items = MutableList(data.size) {i -> createContactView(data.items[i])}
    }

    val size: Int
        get() = items.size

    private fun createContactView(contact : IContact): IContactView{
        if (contact is MailContact){
            return MailContactView(contact.name, MailContactViewHolderFactory())
        }
        return PhoneContactView(contact.name, PhoneContactViewHolderFactory())
    }
}