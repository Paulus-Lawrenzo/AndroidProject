package com.mandiri.appmandiri.presentation.message.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mandiri.appmandiri.adapter.NotificationAdapter
import com.mandiri.appmandiri.base.BaseFragment
import com.mandiri.appmandiri.databinding.FragmentNotificationBinding
import com.mandiri.appmandiri.model.NotificationModel
import com.mandiri.appmandiri.presentation.viewmodel.NotificationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {

    private val viewModel: NotificationViewModel by viewModels()
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewModel.setNotificationData()
        binding.rvNotification.setOnClickListener {
            viewModel.updateCustomData()
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.notificationData.observe(viewLifecycleOwner) {
            setNotificationData(it)
        }
    }

    private fun setNotificationData(data: List<NotificationModel>) {
        binding.rvNotification.adapter = NotificationAdapter(data)
    }

    private fun populateNotification(): List<NotificationModel> {
        return listOf(
            NotificationModel(
                date = "3 Januari 2024",
                title = "Anda mendapatkan uang tunai",
                subtitle = "Uang tunai yang anda dapatkan sebesar 10.000.000 Rupiah"
            ),
            NotificationModel(
                date = "3 Januari 2024",
                title = "Anda mendapatkan uang tunai",
                subtitle = "Uang tunai yang anda dapatkan sebesar 10.000.000 Rupiah"
            ),
            NotificationModel(
                date = "3 Januari 2024",
                title = "Anda mendapatkan uang tunai",
                subtitle = "Uang tunai yang anda dapatkan sebesar 10.000.000 Rupiah"
            ),
            NotificationModel(
                date = "3 Januari 2024",
                title = "Anda mendapatkan uang tunai",
                subtitle = "Uang tunai yang anda dapatkan sebesar 10.000.000 Rupiah"
            ),
            NotificationModel(
                date = "3 Januari 2024",
                title = "Anda mendapatkan uang tunai",
                subtitle = "Uang tunai yang anda dapatkan sebesar 10.000.000 Rupiah"
            ),
            NotificationModel(
                date = "3 Januari 2024",
                title = "Anda mendapatkan uang tunai",
                subtitle = "Uang tunai yang anda dapatkan sebesar 10.000.000 Rupiah"
            ),
        )
    }
}