package ru.geekbrains.cicerone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.androidx.AppNavigator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigator = AppNavigator(this, R.id.container)
        CiceroneApplication.INSTANCE.navigatorHolder.setNavigator(navigator)

        button.setOnClickListener {
            CiceroneApplication.INSTANCE.router.navigateTo(Screens.Main())
        }
        button2.setOnClickListener {
            CiceroneApplication.INSTANCE.router.navigateTo(Screens.Detail())
        }
        button3.setOnClickListener {
            CiceroneApplication.INSTANCE.router.navigateTo(Screens.User("Vova"))
        }
    }
}