package ru.geekbrains.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataSource = DataSource()
        val liveData: LiveData<String> = dataSource.counterString
        liveData.observe(this,
            Observer<String> { textCounter.text = it })
        dataSource.start()
    }
}