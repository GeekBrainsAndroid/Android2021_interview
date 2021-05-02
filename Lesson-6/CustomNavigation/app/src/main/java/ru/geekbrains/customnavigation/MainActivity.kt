package ru.geekbrains.customnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.geekbrains.customnavigation.databinding.ActivityMainBinding
import ru.geekbrains.customnavigation.flownavigation.base.BaseFlowFragment
import ru.geekbrains.customnavigation.flownavigation.extensions.replaceFlowFragment
import ru.geekbrains.customnavigation.flownavigation.mainflow.MainFlowFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.replaceFlowFragment<MainFlowFragment>(R.id.app_container)
        }
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager
            .findFragmentById(R.id.app_container) as? BaseFlowFragment<*>
        if (fragment == null) {
            super.onBackPressed()
            return
        }

        if (!fragment.onBackPressed()) {
            super.onBackPressed()
        }
    }
}