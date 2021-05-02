package ru.geekbrains.customnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.geekbrains.customnavigation.databinding.FragmentDetailsBinding
import ru.geekbrains.customnavigation.flownavigation.base.BaseFragment
import ru.geekbrains.customnavigation.flownavigation.listflow.ListNavigation

class DetailsFragment: BaseFragment<ListNavigation>() {

    companion object {
        const val ARG = "text"
        const val TAG = "DetailsFragment"
    }

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        arguments?.let {
            binding.textView2.text = it.getString(ARG)
        }

        return binding.root
    }
}