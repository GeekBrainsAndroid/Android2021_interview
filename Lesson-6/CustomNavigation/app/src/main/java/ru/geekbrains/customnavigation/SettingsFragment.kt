package ru.geekbrains.customnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.geekbrains.customnavigation.databinding.FragmentSettingsBinding
import ru.geekbrains.customnavigation.flownavigation.base.BaseFragment
import ru.geekbrains.customnavigation.flownavigation.mainflow.MainNavigation

class SettingsFragment: BaseFragment<MainNavigation>() {

    companion object {
        const val TAG = "SettingsFragment"
    }

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)

        binding.buttonList.setOnClickListener {
            navigation.toList()
        }

        return binding.root
    }
}