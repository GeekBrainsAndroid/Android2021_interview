package ru.geekbrains.room.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Note::class), version = 1)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun notesDao(): NoteDao
}