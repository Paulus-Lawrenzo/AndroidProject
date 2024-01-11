package com.mandiri.appmandiri.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mandiri.appmandiri.model.NotificationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor() : ViewModel() {

    private val _notificationData = MutableLiveData<List<NotificationModel>>()
    val notificationData : LiveData<List<NotificationModel>>
        get() = _notificationData

    fun setNotificationData() = viewModelScope.launch {
        _notificationData.postValue(populateDataNotification())
    }

    private fun populateDataNotification(): List<NotificationModel> {
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

    fun updateCustomData() {
        val notificationData = _notificationData.value
        notificationData?.forEach{ it.date = "test"}
        _notificationData.postValue(notificationData ?: listOf())
    }

}