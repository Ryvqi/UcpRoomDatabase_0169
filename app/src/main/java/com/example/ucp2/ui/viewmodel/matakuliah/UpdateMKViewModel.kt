package com.example.ucp2.ui.viewmodel.matakuliah

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2.repository.RepositoryMK
import com.example.ucp2.ui.navigation.DestanasiUpdateMataKuliah
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class UpdateMKViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryMK: RepositoryMK
): ViewModel(){
    var updateUIState by mutableStateOf(MKUiState())
        private set

    private val _kode: String = checkNotNull(savedStateHandle[DestanasiUpdateMataKuliah.kode])

    init {
        viewModelScope.launch {
            updateUIState = repositoryMK.getMK(_kode)
                .filterNotNull()
                .first()
                .toUiStateMK()
        }
    }

    fun updateState(matakuliahEvent: MataKuliahEvent){
        updateUIState = updateUIState.copy(
            matakuliahEvent = matakuliahEvent,
        )
    }
}