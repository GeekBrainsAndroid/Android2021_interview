package ru.geekbrains.customnavigation.flownavigation.extensions

import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.geekbrains.customnavigation.flownavigation.base.BaseFlowFragment

inline fun <reified F : BaseFlowFragment<*>> Fragment.childReplaceFlow(
    container: Int
) = childFragmentManager.replaceFlowFragment<F>(container)

inline fun <reified F : Fragment> Fragment.childReplace(
    container: Int,
    tag: String
) = childFragmentManager.replaceFragment<F>(container, tag)

inline fun <reified F : Fragment> Fragment.childReplace(
    container: Int,
    tag: String,
    bundle: Bundle
) = childFragmentManager.replaceFragment<F>(container, tag, bundle)