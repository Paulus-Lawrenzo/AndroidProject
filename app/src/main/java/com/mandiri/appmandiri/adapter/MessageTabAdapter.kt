package com.mandiri.appmandiri.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MessageTabAdapter(
    fragment: Fragment,
) : FragmentStateAdapter (
    fragment.childFragmentManager,
    fragment.lifecycle
) {

    private val fragmentContent = arrayListOf<Fragment>()

    fun addlistFragment(fragment: Fragment) {
        fragmentContent.add(fragment)
    }

    override fun getItemCount() = fragmentContent.size
    override fun createFragment(position: Int): Fragment {
        return fragmentContent[position]
    }
}