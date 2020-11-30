package ru.geekbrains.dip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val persister: Persister = PersisterXml()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonConvert.setOnClickListener {
            val user = User(editName.text.toString(), editEmail.text.toString())
            textConvert.text = persister.convert(user)
        }
    }
}