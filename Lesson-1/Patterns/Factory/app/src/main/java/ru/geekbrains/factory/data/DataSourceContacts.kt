package ru.geekbrains.factory.data

class DataSourceContacts {
    val items : List<IContact> = listOf(PhoneContact("Peter"),
        PhoneContact("Robert"),
        MailContact("John"),
        PhoneContact("Jimmy"),
        MailContact("Dennis")
    )

    val size: Int
        get() = items.size
}