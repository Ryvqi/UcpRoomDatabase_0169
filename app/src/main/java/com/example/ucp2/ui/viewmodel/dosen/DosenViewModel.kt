package com.example.ucp2.ui.viewmodel.dosen

import android.view.View
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.ucp2.repository.RepositoryDsn

class DosenViewModel(private val repositoryDsn: RepositoryDsn): ViewModel() {
    var uiState by mutableStateOf(DsnUiState())

    //memperbarui state berdasarkan input pengguna
    fun updateState(dosenEvent: DosenEvent){
        uiState = uiState.copy(
            dosenEvent = dosenEvent
        )
    }
}

data class DosenEvent(
    val nidn: String = "",
    val nama: String = "",
    val jeniskelamin: String = "",
)

data class DsnUiState(
    val dosenEvent: DosenEvent = DosenEvent(),
    val isEntityValid: FormErrorState = FormErrorState(),
    val snackBarMessage: String? = null,
)

data class FormErrorState(
    val nidn: String? = null,
    val nama: String? = null,
    val jeniskelamin: String? = null,
){
    fun isValid(): Boolean{
        return nidn == null && nama == null && jeniskelamin == null
    }
}