package com.arkam.vascomm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.arkam.vascomm.DialogDashboardListener
import com.arkam.vascomm.R
import com.arkam.vascomm.adapter.MainAdapter
import com.arkam.vascomm.adapter.MainSecondAdapter
import com.arkam.vascomm.databinding.ActivityMainBinding
import com.arkam.vascomm.model.Kesehatan
import com.arkam.vascomm.model.Pemeriksaan
import com.arkam.vascomm.showDialogDashboard

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupRecyclerViewSecond()

        binding.imgDashboard.setOnClickListener {
            showDialogDashboard(object : DialogDashboardListener{
                override fun onCloseDialog() {
                }
            })
        }
    }

    private fun setupRecyclerView(){
        binding.itemRecylerview.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter  = MainAdapter(createItemList()) { kesehatan, position ->
                Toast.makeText(
                    this@MainActivity,
                    "Clicked on actor : ${kesehatan.name}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun setupRecyclerViewSecond(){
        binding.itemRecylerviewPaketPemeriksaan.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter  = MainSecondAdapter(createItemListSecond()) { pemeriksaan, position ->
                Toast.makeText(
                    this@MainActivity,
                    "Clicked on actor : ${pemeriksaan.name}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun createItemList(): ArrayList<Kesehatan>{
        return arrayListOf(
            Kesehatan("Suntik Steril", R.drawable.image_kesehatan.toString(), "15.0000", "Ready Stock", R.drawable.star.toString(), "3"),
            Kesehatan("Suntik Inpus", R.drawable.image_kesehatan.toString(), "10.0000", "Ready Stock", R.drawable.star.toString(), "4"),
            Kesehatan("Suntik Darah", R.drawable.image_kesehatan.toString(), "10.0000", "Ready Stock", R.drawable.star.toString(), "4"),
            Kesehatan("Suntik Imun", R.drawable.image_kesehatan.toString(), "10.0000", "Ready Stock", R.drawable.star.toString(), "4"),
            Kesehatan("Suntik Injeksi", R.drawable.image_kesehatan.toString(), "10.0000", "Ready Stock", R.drawable.star.toString(), "4"),
        )
    }

    private fun createItemListSecond(): ArrayList<Pemeriksaan>{
        return arrayListOf(
            Pemeriksaan("PCR Swab Test (Drive Thru)\n" + "Hasil 1 Hari Kerja",
                R.drawable.hospital.toString(), "Rp 1.400.000", "Lenmark Surabaya", "Dukuh Pakis, Surabaya", R.drawable.image_hospital.toString(), R.drawable.lokasi.toString()),
            Pemeriksaan("PCR Swab Test (Drive Thru)\n" + "Hasil 1 Hari Kerja",
                R.drawable.hospital.toString(), "Rp 1.400.000", "Lenmark Surabaya", "Dukuh Pakis, Surabaya", R.drawable.image_hospital.toString(), R.drawable.lokasi.toString())

        )

    }
}