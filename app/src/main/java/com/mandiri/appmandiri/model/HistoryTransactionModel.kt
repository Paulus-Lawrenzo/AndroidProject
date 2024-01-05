package com.mandiri.appmandiri.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HistoryTransactionModel(
    val date: String,
    val titleTransaction: String,
    val subtitleTransaction: String,
    val statusTransaction: Int,
    val balanceTransaction: String,
    val iconTransaction: Int
) : Parcelable

enum class StatusTransaction(val value: Int) {
    Berhasil(1),
    Gagal(2),
    Pending(3)
}

enum class StatusTransfer(val value: String) {
    Credit("Credit"),
    Debit("Debit")
}