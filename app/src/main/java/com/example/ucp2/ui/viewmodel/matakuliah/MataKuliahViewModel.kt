package com.example.ucp2.ui.viewmodel.matakuliah

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.ucp2.repository.RepositoryMK

class MataKuliahViewModel(private val repositoryMK: RepositoryMK): ViewModel(){
    var uiState by mutableStateOf(MKUiState())

    fun updateState(matakuliahEvent: MataKuliahEvent){
        uiState = uiState.copy(
            matakuliahEvent = matakuliahEvent
        )
    }

    private fun validateFields(): Boolean{
        val event = uiState.matakuliahEvent
        val errorState = FormErrorState(
            kode = if (event.kode.isNotEmpty()) null else "Kode tidak boleh kosong",
            nama = if (event.nama.isNotEmpty()) null else "Nama tidak boleh kosong",
            sks = if (event.sks != 0) null else null,
            semester = if (event.semester != 0) null else null,
            jenis = if (event.jenis.isNotEmpty()) null else "Jenis Matakuliah tidak boleh kosong",
            dosenpengampu = if (event.dosenpengampu.isNotEmpty()) null else "Dosen Pengampu tidak boleh kosong",
        )
        uiState = uiState.copy(isEntityValid = errorState)
        return errorState.isValid()
    }
}

data class MataKuliahEvent(
    val kode: String = "",
    val nama: String = "",
    val sks: Int = 0,
    val semester: Int = 0,
    val jenis: String = "",
    val dosenpengampu: String = "",
)

data class MKUiState(
    val matakuliahEvent: MataKuliahEvent = MataKuliahEvent(),
    val isEntityValid: FormErrorState = FormErrorState(),
    val snackBarMessage: String? = null,
)

data class FormErrorState(
    val kode: String? = null,
    val nama: String? = null,
    val sks: Int? = null,
    val semester: Int? = null,
    val jenis: String? = null,
    val dosenpengampu: String? = null,
){
    fun isValid(): Boolean{
        return kode == null && nama == null && sks == null &&
                semester == null && jenis == null && dosenpengampu == null
    }
}