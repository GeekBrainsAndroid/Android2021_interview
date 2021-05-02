package ru.geekbrains.customnavigation.flownavigation.extensions

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import ru.geekbrains.customnavigation.flownavigation.base.BaseFlowFragment

inline fun <reified F : BaseFlowFragment<*>> FragmentManager.replaceFlowFragment(
    container: Int
) = commit {
    replace<F>(container)
    setReorderingAllowed(true)
}

inline fun <reified F : Fragment> FragmentManager.replaceFragment(
    container: Int,
    tag: String
) = commit {
    replace<F>(container)
    addToBackStack(tag)
    setReorderingAllowed(true)
}

inline fun <reified F : Fragment> FragmentManager.replaceFragment(
    container: Int,
    tag: String,
    bundle: Bundle
) = commit {
    replace<F>(container, tag, bundle)
    addToBackStack(tag)
    setReorderingAllowed(true)
}