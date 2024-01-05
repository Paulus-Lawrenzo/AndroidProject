package com.mandiri.appmandiri.presentation.message.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mandiri.appmandiri.databinding.ActivityDetailTransactinBinding
import com.mandiri.appmandiri.model.HistoryTransactionModel
import com.mandiri.appmandiri.model.StatusTransaction

class DetailTransactionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailTransactinBinding
    private var data: HistoryTransactionModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTransactinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.componentToolbar.tvToolbarTitle.text = "Detail History"

        binding.componentToolbar.ivBack.setOnClickListener {
            onBackPressed()
        }

        data = intent?.getParcelableExtra(DATA_TRANSACTION)
        setupViewDetail(data)
    }

    private fun checkStatusTransaction(data: HistoryTransactionModel?): String {
        val dataTrans = data?.statusTransaction
        var resultTransaction = "Berhasil"
        when (dataTrans) {
            StatusTransaction.Berhasil.value -> resultTransaction = "Berhasil"
        }
        return resultTransaction
    }

    private fun setupViewDetail(data: HistoryTransactionModel?) {
        val textDetail = "Transaksi saya " + checkStatusTransaction(data)
        val textTitle = data?.titleTransaction
        val textDate = data?.date
        val textSubtitle = data?.subtitleTransaction
        val textBalance = data?.balanceTransaction

        binding.tvDetailTransaction.text = textDetail
        binding.tvTitleTransaction.text = textTitle
        binding.tvDateTransaction.text = textDate
        binding.tvSubtitleTransaction.text = textSubtitle
        binding.tvBalanceTransaction.text = textBalance
    }

    companion object {
        const val DATA_TRANSACTION = "dataTransaction"

        fun navigateToDetailTransaction(activity: Activity, data: HistoryTransactionModel) {
            val intent = Intent(activity, DetailTransactionActivity::class.java)
            intent.putExtra(DATA_TRANSACTION,data)
            activity.startActivity(intent)
        }
    }
}