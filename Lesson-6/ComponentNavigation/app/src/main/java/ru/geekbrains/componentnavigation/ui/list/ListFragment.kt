package ru.geekbrains.componentnavigation.ui.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import ru.geekbrains.componentnavigation.R
import ru.geekbrains.componentnavigation.databinding.FragmentHomeBinding
import ru.geekbrains.componentnavigation.databinding.FragmentListBinding
import ru.geekbrains.componentnavigation.ui.home.HomeViewModel

class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        _binding = FragmentListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.buttonDetails.setOnClickListener {
            val navController = this.findNavController()
            navController.navigate(R.id.action_sub_list_to_sub_details, bundleOf("text" to "Hi from List!"))
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}