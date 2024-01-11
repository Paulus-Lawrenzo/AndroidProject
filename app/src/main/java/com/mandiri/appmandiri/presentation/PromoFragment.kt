package com.mandiri.appmandiri.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.mandiri.appmandiri.R
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
        binding.btnLoadImage.setOnClickListener {
            loadImage()
        }
    }

    private fun loadImage() {
        val imageUrl = "https://picsum.photos/200"

        Glide.with(this)
            .load(imageUrl)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .placeholder(R.drawable.ic_placeholder)
            .into(binding.ivGlide)
    }
}