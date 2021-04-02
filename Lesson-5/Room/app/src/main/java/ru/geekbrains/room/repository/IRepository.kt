package ru.geekbrains.room.repository

import androidx.lifecycle.LiveData
import ru.geekbrains.room.database.Note

interface IRepository {
    fun getAllNotes(): LiveData<List<Note>>
    fun insert(note: Note)
    fun delete(note: Note)
    fun update(note: Note)
}