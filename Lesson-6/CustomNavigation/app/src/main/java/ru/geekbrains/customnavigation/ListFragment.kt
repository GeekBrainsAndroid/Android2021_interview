package ru.geekbrains.customnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.geekbrains.customnavigation.databinding.FragmentListBinding
import ru.geekbrains.customnavigation.flownavigation.base.BaseFragment
import ru.geekbrains.customnavigation.flownavigation.listflow.ListNavigation

class ListFragment: BaseFragment<ListNavigation>() {

    companion object {
        const val TAG = "ListFragment"
    }

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)

        binding.buttonDetails.setOnClickListener {
            navigation.toDetails("Parameter")
        }

        binding.buttonSettings.setOnClickListener {
            navigation.toSettings()
        }

        return binding.root
    }
}