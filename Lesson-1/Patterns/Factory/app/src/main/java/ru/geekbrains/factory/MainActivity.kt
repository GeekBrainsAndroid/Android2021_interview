package ru.geekbrains.factory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.geekbrains.factory.data.DataSourceContacts
import ru.geekbrains.factory.listview.ContactListAdapter
import ru.geekbrains.factory.listview.data.DataViewContacts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listContact.adapter = ContactListAdapter(DataViewContacts(DataSourceContacts()))
    }
}