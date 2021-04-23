package ru.geekbrains.tabbed.ui

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import ru.geekbrains.tabbed.R
import ru.geekbrains.tabbed.databinding.ActivityMainBinding
import ru.geekbrains.tabbed.ui.screen.ListFragment
import ru.geekbrains.tabbed.ui.screen.MainFragment
import ru.geekbrains.tabbed.ui.screen.SettingsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}