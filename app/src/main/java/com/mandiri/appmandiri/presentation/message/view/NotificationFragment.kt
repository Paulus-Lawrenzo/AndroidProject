package com.mandiri.appmandiri.presentation.message.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mandiri.appmandiri.adapter.NotificationAdapter
import com.mandiri.appmandiri.databinding.FragmentNotificationBinding
import com.mandiri.appmandiri.model.NotificationModel

class NotificationFragment : Fragment() {
    private var _binding: FragmentNotificationBinding? = null
    private val  binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvNotification.adapter = NotificationAdapter(populateNotification())
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