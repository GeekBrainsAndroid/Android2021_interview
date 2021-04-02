package ru.geekbrains.room.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.room.database.Note
import ru.geekbrains.room.repository.IRepository
import ru.geekbrains.room.utils.*

class MainViewModel(private val repository: IRepository) : ViewModel() {
    var notes: MutableLiveData<List<Note>> = MutableLiveData()

    init {
        reload()
    }

    fun reload() {
        repository.getAllNotes().observeForever {
            notes.postValue(it)
        }
    }

    fun add(){
        val note = Note(message = getRandomString(10))
        addNote(note)
    }

    fun addNote(note: Note) {
        repository.insert(note)
    }

    fun update(index: Int) {
        val note = notes.value!!.elementAt(index)
        val newNote = Note(note.id, message = getRandomString(10))
        updateNote(newNote)
    }

    fun updateNote(note: Note) {
        repository.update(note)
    }

    fun removeNote(index: Int) {
        val note = notes.value!!.elementAt(index)
        repository.delete(note)
    }
}
