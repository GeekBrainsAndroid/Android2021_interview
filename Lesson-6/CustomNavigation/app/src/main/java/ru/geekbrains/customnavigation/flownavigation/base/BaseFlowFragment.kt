package ru.geekbrains.customnavigation.flownavigation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.geekbrains.customnavigation.R
import ru.geekbrains.customnavigation.databinding.FragmentBaseFlowBinding

const val MIN_SCREEN_COUNT = 1

abstract class BaseFlowFragment<F : Navigation> : BaseFragment<F>() {
    protected open val container: Int = R.id.main_container

    private lateinit var binding: FragmentBaseFlowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBaseFlowBinding.inflate(inflater, container, false)

        return binding.root
    }

    fun onBackPressed(): Boolean {
        val fragment = childFragmentManager.findFragmentById(container)
        if (fragment is BaseFlowFragment<*>){
            return fragment.onBackPressed()
        }

        if (childFragmentManager.backStackEntryCount > MIN_SCREEN_COUNT){
            childFragmentManager.popBackStack()
            return true
        }

        return false
    }
}