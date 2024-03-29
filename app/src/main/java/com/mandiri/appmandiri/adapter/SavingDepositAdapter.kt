package com.mandiri.appmandiri.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.appmandiri.databinding.ItemSavingDepositBinding
import com.mandiri.appmandiri.model.SavingDepositModel

class SavingDepositAdapter(
    private val savingDepositData: MutableList<SavingDepositModel>
) : RecyclerView.Adapter<SavingDepositAdapter.SavingDepositViewHolder>() {
    private var maximumItems = 2
    inner class SavingDepositViewHolder(private val itemBinding: ItemSavingDepositBinding):
        RecyclerView.ViewHolder(itemBinding.root){
        fun bind(data: SavingDepositModel){
            itemBinding.tvSavingDepositName.text = data.savingName
            itemBinding.ivCardHolder.setImageResource(data.imageCard)
            itemBinding.tvAccountNumber.text = data.accountNumber
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavingDepositViewHolder {
        return SavingDepositViewHolder(
            ItemSavingDepositBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = if (savingDepositData.size>=5) maximumItems else savingDepositData.size
    override fun onBindViewHolder(holder: SavingDepositViewHolder, position: Int) {
        holder.bind(savingDepositData[position])
    }

    fun updateQuantityDepositSize(sizeUpdated: Int){
        maximumItems= sizeUpdated
        notifyDataSetChanged()
    }
}