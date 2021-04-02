package ru.geekbrains.room.repository

import androidx.lifecycle.LiveData
import ru.geekbrains.room.database.Note
import ru.geekbrains.room.database.NoteDao
import kotlin.concurrent.thread

class RepositoryRoom(private val noteDao: NoteDao) : IRepository {
    override fun getAllNotes(): LiveData<List<Note>> = noteDao.getAllNotes()

    override fun insert(note: Note) {
        thread {
            noteDao.insert(note)
        }
    }

    override fun delete(note: Note) {
        thread {
            noteDao.delete(note)
        }
    }

    override fun update(note: Note) {
        thread {
            noteDao.update(note)
        }
    }
}