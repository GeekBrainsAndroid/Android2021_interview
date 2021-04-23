package ru.geekbrains.tabbed.ui.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.geekbrains.tabbed.R
import ru.geekbrains.tabbed.databinding.FragmentDetailsBinding

private const val ARG_PARAMID = "paramId"

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private var paramId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            paramId = it.getString(ARG_PARAMID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        paramId?.let {
            binding.detail.text = it
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(paramId: String) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAMID, paramId)
                }
            }
    }
}