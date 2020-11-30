package ru.geekbrains.dip

class User(public var name: String, public var email: String) {
    fun convert(): String{
        val persister = PersisterXml()
        return persister.convert(this)
    }
}