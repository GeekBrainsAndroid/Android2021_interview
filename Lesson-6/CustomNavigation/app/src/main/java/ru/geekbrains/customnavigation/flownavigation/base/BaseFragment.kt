package ru.geekbrains.customnavigation.flownavigation.base

import android.content.Context
import androidx.fragment.app.Fragment

abstract class BaseFragment<F : Navigation> : Fragment() {
    private var _navigation: F? = null
    protected val navigation: F
        get() {
            return _navigation!!
        }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (parentFragment != null){
            _navigation = parentFragment as F
        }
    }
}