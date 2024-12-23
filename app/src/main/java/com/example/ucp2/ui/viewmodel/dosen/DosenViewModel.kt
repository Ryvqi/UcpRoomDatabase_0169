package com.example.ucp2.ui.viewmodel.dosen

data class DsnUiState(
    val dosenEvent: DosenEvent = DosenEvent(),
    val isEntityValid: FormErrorState = FormErrorState(),
    val snackBarMessage: String? = null,
)