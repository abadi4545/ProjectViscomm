package com.arkam.vascomm.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arkam.vascomm.databinding.ItemKesehatanBinding
import com.arkam.vascomm.model.Kesehatan
import java.util.EventListener

class MainAdapter(
    private val itemList : ArrayList<Kesehatan>,
    private val listener: (Kesehatan, Int) -> Unit
): RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemKesehatanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(itemList[position])
        holder.itemView.setOnClickListener { listener(itemList[position], position) }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(var itemBinding: ItemKesehatanBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(kesehatan: Kesehatan) {
            itemBinding.imgKesehatan.setImageResource(kesehatan.image.toInt())
            itemBinding.imgStar.setImageResource(kesehatan.star.toInt())
            itemBinding.tvTitle.text = kesehatan.name
            itemBinding.tvHarga.text = kesehatan.harga
            itemBinding.tvStar.text = kesehatan.titleStar
            itemBinding.tvReadyStock.text = kesehatan.stock
        }
    }



}