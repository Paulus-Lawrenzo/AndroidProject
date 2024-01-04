package com.mandiri.appmandiri.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.appmandiri.R
import com.mandiri.appmandiri.databinding.ItemHistoryTransactionBinding
import com.mandiri.appmandiri.model.HistoryTransactionModel
import com.mandiri.appmandiri.model.StatusTransaction
import com.mandiri.appmandiri.model.StatusTransfer

class HistoryTransactionAdapter(
    private val data: List<HistoryTransactionModel>,
    private val onClickHistoryTransaction: (HistoryTransactionModel) -> Unit
) : RecyclerView.Adapter<HistoryTransactionAdapter.TransactionHistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryTransactionAdapter.TransactionHistoryViewHolder {
        return TransactionHistoryViewHolder(
            ItemHistoryTransactionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TransactionHistoryViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size


    inner class TransactionHistoryViewHolder(val binding: ItemHistoryTransactionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: HistoryTransactionModel) {
            binding.tvDate.text = data.date
            binding.tvTitleNotif.text = data.titleTransaction
            binding.tvSubtitleNotif.text = data.subtitleTransaction
            binding.tvBalance.text = data.balanceTransaction
            binding.ivLogoTransaction.setImageResource(data.iconTransaction)

            when (data.statusTransaction) {
                StatusTransaction.Berhasil.value -> {
                    binding.tvStatusTransaction.text = "Transaksi Berhasil"
                    binding.tvStatusTransaction.setTextColor(binding.root.context.getColor(R.color.green))
                }
                StatusTransaction.Gagal.value -> {
                    binding.tvStatusTransaction.text = "Transaksi Gagal"
                    binding.tvStatusTransaction.setTextColor(binding.root.context.getColor(R.color.red))
                }
                StatusTransaction.Pending.value -> {
                    binding.tvStatusTransaction.text = "Transaksi Sedang diproses"
                    binding.tvStatusTransaction.setTextColor(binding.root.context.getColor(R.color.blue))
                }
            }

            when (data.titleTransaction) {
                StatusTransfer.Credit.value -> {
                    binding.ivLogoTransaction.setImageResource(R.drawable.baseline_account_circle_24)
                }
                StatusTransfer.Debit.value -> {
                    binding.ivLogoTransaction.setImageResource(R.drawable.baseline_copyright_24)
                }
            }

            binding.constraintItemTransaction.setOnClickListener {
                onClickHistoryTransaction.invoke(data)
            }
        }
    }
}