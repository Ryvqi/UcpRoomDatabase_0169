package com.example.ucp2.ui.viewmodel.matakuliah

data class MataKuliahEvent(
    val kode: String = "",
    val nama: String = "",
    val sks: Int = 0,
    val semester: Int = 0,
    val jenis: String = "",
    val dosenpengampu: String = "",
)