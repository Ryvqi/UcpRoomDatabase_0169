package com.example.ucp2.ui.viewmodel.matakuliah

data class DetailUiState(
    val detailUiEvent: MataKuliahEvent = MataKuliahEvent(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = "",
){
    val isUiEventEmpty: Boolean
        get() = detailUiEvent == MataKuliahEvent()
    val isUiEventNotEmpty: Boolean
        get() = detailUiEvent != MataKuliahEvent()
}