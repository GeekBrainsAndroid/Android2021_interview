package ru.geekbrains.dip

import com.google.gson.Gson

class PersisterJson : Persister {
    override fun convert(user: Userable): String {
        val gson = Gson()
        return gson.toJson(user)
    }
}