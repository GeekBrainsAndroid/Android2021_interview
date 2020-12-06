package ru.geekbrains.dip

interface Persister {
    fun convert(user: Userable): String
}