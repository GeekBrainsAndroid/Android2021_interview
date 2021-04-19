package ru.geekbrains.cicerone

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.geekbrains.cicerone.fragments.DetailFragment
import ru.geekbrains.cicerone.fragments.MainFragment
import ru.geekbrains.cicerone.fragments.UserFragment

object Screens {
    fun Main() = FragmentScreen { MainFragment() }
    fun Detail() = FragmentScreen { DetailFragment() }
    fun User(user: String) = FragmentScreen { UserFragment.newInstance(user) }
 }