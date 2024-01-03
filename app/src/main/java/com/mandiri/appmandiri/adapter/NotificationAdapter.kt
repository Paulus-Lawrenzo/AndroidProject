package com.mandiri.appmandiri.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.appmandiri.databinding.ItemNotificationBinding
import com.mandiri.appmandiri.model.NotificationModel

class NotificationAdapter(
    private val listNotification: List<NotificationModel>
) : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder(
            ItemNotificationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(listNotification[position])
    }

    override fun getItemCount(): Int {
        return listNotification.size
    }

    inner class NotificationViewHolder(private val itemBinding: ItemNotificationBinding):
        RecyclerView.ViewHolder(itemBinding.root){
        fun bind(data: NotificationModel){
            itemBinding.tvDate.text = data.date
            itemBinding.tvTitleNotif.text = data.title
            itemBinding.tvSubtitleNotif.text= data.subtitle
        }
    }
}