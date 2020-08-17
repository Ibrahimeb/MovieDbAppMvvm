package com.ibrahim.dev.moviedbmvvm.presentation.adapter.actions

sealed class EventGenericAdapter {

    class LaunchSpecificListFragment(val nameList: String) : EventGenericAdapter()
    class LaunchDetailsItem(val id: Int, typeItem: String)

}