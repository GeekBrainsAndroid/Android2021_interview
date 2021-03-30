package ru.geekbrains.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.geekbrains.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonHello.setOnClickListener {
            binding.textHelloName.text = "Привет ${binding.editName.text}"
        }
    }
}