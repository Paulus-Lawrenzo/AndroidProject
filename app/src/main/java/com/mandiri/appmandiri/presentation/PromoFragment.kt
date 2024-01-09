package com.mandiri.appmandiri.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mandiri.appmandiri.base.BaseFragment
import com.mandiri.appmandiri.databinding.FragmentPromoBinding

class PromoFragment : BaseFragment<FragmentPromoBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPromoBinding {
        return FragmentPromoBinding.inflate(inflater, container, false)
    }

    override fun setupView() {

    }
}