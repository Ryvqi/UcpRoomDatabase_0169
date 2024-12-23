package com.example.ucp2.ui.viewmodel.dosen

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