package ru.geekbrains.customnavigation.flownavigation.mainflow

import android.os.Bundle
import ru.geekbrains.customnavigation.SettingsFragment
import ru.geekbrains.customnavigation.flownavigation.base.BaseFlowFragment
import ru.geekbrains.customnavigation.flownavigation.base.Navigation
import ru.geekbrains.customnavigation.flownavigation.extensions.childReplace
import ru.geekbrains.customnavigation.flownavigation.extensions.childReplaceFlow
import ru.geekbrains.customnavigation.flownavigation.listflow.ListFlowFragment

class MainFlowFragment : BaseFlowFragment<Navigation>(), MainNavigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            toList()
        }
    }

    override fun toList() {
        childReplaceFlow<ListFlowFragment>(container)
    }

    override fun toSettings() {
        childReplace<SettingsFragment>(container, SettingsFragment.TAG)
    }
}