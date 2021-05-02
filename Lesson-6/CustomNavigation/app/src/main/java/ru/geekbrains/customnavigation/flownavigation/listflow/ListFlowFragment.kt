package ru.geekbrains.customnavigation.flownavigation.listflow

import android.os.Bundle
import androidx.core.os.bundleOf
import ru.geekbrains.customnavigation.DetailsFragment
import ru.geekbrains.customnavigation.ListFragment
import ru.geekbrains.customnavigation.flownavigation.base.BaseFlowFragment
import ru.geekbrains.customnavigation.flownavigation.extensions.childReplace
import ru.geekbrains.customnavigation.flownavigation.mainflow.MainNavigation

class ListFlowFragment: BaseFlowFragment<MainNavigation>(), ListNavigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            toList()
        }
    }

    override fun toList() {
        childReplace<ListFragment>(container, ListFragment.TAG)
    }

    override fun toDetails(parameter: String) {
        val bundle = bundleOf(DetailsFragment.ARG to parameter)
        childReplace<DetailsFragment>(container, DetailsFragment.TAG, bundle)
    }

    override fun toSettings() {
        navigation.toSettings()
    }
}