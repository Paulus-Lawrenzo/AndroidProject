package com.mandiri.appmandiri.presentation.message.view

import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mandiri.appmandiri.adapter.MessageTabAdapter
import com.mandiri.appmandiri.base.BaseFragment
import com.mandiri.appmandiri.databinding.FragmentMessageBinding
import com.mandiri.appmandiri.presentation.message.view.HistoryTransactionFragment
import com.mandiri.appmandiri.presentation.message.view.NotificationFragment

class MessageFragment : BaseFragment<FragmentMessageBinding>() {

    private var _testBool = false
    private var adapterMessage : MessageTabAdapter? = null
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMessageBinding {
        return FragmentMessageBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        setupTabView()
    }

    private fun setupTabView() {
        val tabLayout = binding.tabMessage
        val viewPager = binding.vpMessage
        adapterMessage = MessageTabAdapter(this)
        adapterMessage?.addlistFragment(NotificationFragment())
        adapterMessage?.addlistFragment(HistoryTransactionFragment())
        viewPager.adapter = adapterMessage

        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            when(position) {
                0 -> {
                    tab.text = "Notification"
                }
                1 -> {
                    tab.text = "History"
                }
            }
        }.attach()
    }
}