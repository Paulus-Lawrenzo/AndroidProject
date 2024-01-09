package com.mandiri.appmandiri.presentation.message.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mandiri.appmandiri.adapter.NotificationAdapter
import com.mandiri.appmandiri.base.BaseFragment
import com.mandiri.appmandiri.databinding.FragmentNotificationBinding
import com.mandiri.appmandiri.model.NotificationModel

class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {

    private var notificationAdapter = NotificationAdapter(populateNotification())
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        binding.rvNotification.adapter = notificationAdapter
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