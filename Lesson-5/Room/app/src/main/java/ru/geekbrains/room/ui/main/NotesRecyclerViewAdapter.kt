package ru.geekbrains.room.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.room.database.Note
import ru.geekbrains.room.databinding.ItemBinding


class NotesRecyclerViewAdapter(private val fragment: Fragment) : RecyclerView.Adapter<NotesRecyclerViewAdapter.NoteHolder>()  {

    var notes: List<Note> = listOf()
    var menuPosition: Int = 0
        private set

    class NoteHolder(internal var item: ItemBinding) : RecyclerView.ViewHolder(item.root) {
        fun bind(note: Note){
            item.note = note
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val item = ItemBinding.inflate(layoutInflater, parent, false)
        return NoteHolder(item)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val listItem = notes[position]
        holder.item.textNote.setOnLongClickListener {
            menuPosition = position
            false
        }
        fragment.registerForContextMenu(holder.item.textNote)
        holder.bind(listItem)
    }
}