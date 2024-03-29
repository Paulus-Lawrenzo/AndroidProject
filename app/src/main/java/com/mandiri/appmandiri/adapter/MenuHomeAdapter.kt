package com.mandiri.appmandiri.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.appmandiri.databinding.ItemMenuHomeBinding
import com.mandiri.appmandiri.model.MenuModel

class MenuHomeAdapter(
    private val listMenu : List<MenuModel>
) : RecyclerView.Adapter<MenuHomeAdapter.MenuViewHolder>(){
    private var _onClickMenu: (MenuModel)->Unit={}

    fun setOnClickMenu(listener: (MenuModel)-> Unit){
        _onClickMenu = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
            ItemMenuHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(listMenu[position], _onClickMenu)
    }

    override fun getItemCount(): Int {
        return listMenu.size
    }

    inner class MenuViewHolder(val binding: ItemMenuHomeBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: MenuModel, onClickMenu: (MenuModel) -> Unit){
            binding.tvTitleMenu.text = data.menuTitle
            binding.ivMenuHome.setImageResource(data.image)
            binding.constraintItemHome.setOnClickListener{
                onClickMenu.invoke(data)
            }
        }
    }

}