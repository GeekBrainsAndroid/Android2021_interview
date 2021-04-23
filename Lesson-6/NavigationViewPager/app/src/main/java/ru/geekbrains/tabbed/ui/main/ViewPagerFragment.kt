package ru.geekbrains.tabbed.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import ru.geekbrains.tabbed.R
import ru.geekbrains.tabbed.databinding.FragmentViewPagerBinding
import ru.geekbrains.tabbed.ui.ViewPagerAdapter
import ru.geekbrains.tabbed.ui.screen.ListFragment
import ru.geekbrains.tabbed.ui.screen.MainFragment
import ru.geekbrains.tabbed.ui.screen.SettingsFragment

class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPagerBinding.inflate(layoutInflater, container, false)
        val fragmentList = arrayListOf<Fragment>(
            MainFragment.newInstance(),
            ListFragment.newInstance(),
            SettingsFragment.newInstance()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.setText(when(position){
                0 -> R.string.main
                1 -> R.string.list
                else -> R.string.settings
            })
        }.attach()

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ViewPagerFragment()
    }
}