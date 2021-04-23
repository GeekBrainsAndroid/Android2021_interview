package ru.geekbrains.tabbed.ui.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import ru.geekbrains.tabbed.R
import ru.geekbrains.tabbed.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        binding.button.setOnClickListener {
            val navController = findNavController()
            val bundle = bundleOf("paramId" to "Identifier!")
            navController.navigate(R.id.action_listFragment_to_DetailsFragment, bundle)
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }
}