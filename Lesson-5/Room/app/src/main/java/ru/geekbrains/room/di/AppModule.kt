package ru.geekbrains.room.di

import androidx.room.Room
import org.koin.dsl.module
import ru.geekbrains.room.database.NoteDao
import ru.geekbrains.room.database.NotesDatabase
import ru.geekbrains.room.repository.IRepository
import ru.geekbrains.room.repository.RepositoryRoom
import ru.geekbrains.room.ui.main.MainViewModel

val appModule = module {
    single { MainViewModel(get()) }
    single<NotesDatabase> {
        Room.databaseBuilder(get(), NotesDatabase::class.java, "notes.db")
            .build()
    }
    single { get<NotesDatabase>().notesDao() }
    factory<IRepository> { RepositoryRoom(get()) }
}

