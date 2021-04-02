package ru.geekbrains.room.utils


fun <T> List<T>.add(newValue: T): List<T> {
    val newNotes = toMutableList()
    newNotes.add(newValue)
    return newNotes
}

fun <T> List<T>.replace(newValue: T, block: (T) -> Boolean): List<T> {
    return map {
        if (block(it)) newValue else it
    }
}

fun <T> List<T>.remove(removedValue: T): List<T> {
    val newNotes = toMutableList()
    newNotes.remove(removedValue)
    return newNotes
}

fun getRandomString(length: Int) : String {
    val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
    return (1..length)
        .map { allowedChars.random() }
        .joinToString("")
}