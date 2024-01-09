package com.mandiri.appmandiri.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.mandiri.appmandiri.R
import com.mandiri.appmandiri.base.BaseFragment
import com.mandiri.appmandiri.databinding.FragmentProfileBinding
import com.mandiri.appmandiri.databinding.ActivityProfilBinding

class ProfileFragment : BaseFragment<ActivityProfilBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ActivityProfilBinding {
        return ActivityProfilBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        val imageUrl = "https://dafunda.com/wp-content/uploads/2021/09/AOT.jpg"
        Glide.with(this)
            .load(imageUrl)
            .placeholder(R.drawable.baseline_account_circle_24)
            .error(R.drawable.baseline_copyright_24)
            .into(binding.ivProfileImage)
    }
}