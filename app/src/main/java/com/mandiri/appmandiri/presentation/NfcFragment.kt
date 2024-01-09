package com.mandiri.appmandiri.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mandiri.appmandiri.base.BaseFragment
import com.mandiri.appmandiri.databinding.FragmentMessageBinding

class NfcFragment : BaseFragment<FragmentMessageBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMessageBinding {
        return FragmentMessageBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
    }
}