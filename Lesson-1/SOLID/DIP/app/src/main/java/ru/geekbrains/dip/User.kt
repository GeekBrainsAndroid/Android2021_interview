package ru.geekbrains.dip

class User(override var name: String, override var email: String)
    : Userable {
}