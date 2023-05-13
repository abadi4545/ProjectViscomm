package com.arkam.vascomm.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arkam.vascomm.databinding.ItemTipeLayananKesehatanBinding
import com.arkam.vascomm.model.Pemeriksaan

class MainSecondAdapter(
    private val itemList : ArrayList<Pemeriksaan>,
    private val listener: (Pemeriksaan, Int) -> Unit
): RecyclerView.Adapter<MainSecondAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTipeLayananKesehatanBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(itemList[position])
        holder.itemView.setOnClickListener { listener(itemList[position], position) }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(var itemBinding: ItemTipeLayananKesehatanBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(dataItem: Pemeriksaan) {
            itemBinding.imgHospitalDesc.setImageResource(dataItem.image_Hospital_Desc.toInt())
            itemBinding.imgHospital.setImageResource(dataItem.image_Hospital.toInt())
            itemBinding.imgLokasi.setImageResource(dataItem.image_lokasi.toInt())
            itemBinding.tvTitle.text = dataItem.name
            itemBinding.tvHarga.text = dataItem.harga
            itemBinding.tvHospital.text = dataItem.hospital
            itemBinding.tvLokasi.text = dataItem.alamat
        }
    }
}

