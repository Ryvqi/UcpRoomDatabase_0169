package com.example.ucp2.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ucp2.KRSApp
import com.example.ucp2.ui.viewmodel.dosen.DosenViewModel
import com.example.ucp2.ui.viewmodel.dosen.HomeDsnViewModel
import com.example.ucp2.ui.viewmodel.matakuliah.DetailMKViewModel
import com.example.ucp2.ui.viewmodel.matakuliah.HomeMKViewModel
import com.example.ucp2.ui.viewmodel.matakuliah.MataKuliahViewModel
import com.example.ucp2.ui.viewmodel.matakuliah.UpdateMKViewModel

object PenyediaViewModelKrs{
    val Factory = viewModelFactory {
        initializer {
            DosenViewModel(
                KRSApp().containerApp.repositoryDsn
            )
        }
        initializer {
            HomeDsnViewModel(
                KRSApp().containerApp.repositoryDsn
            )
        }

        initializer {
            MataKuliahViewModel(
                KRSApp().containerApp.repositoryMK
            )
        }
        initializer {
            HomeMKViewModel(
                KRSApp().containerApp.repositoryMK
            )
        }
        initializer {
            UpdateMKViewModel(
                createSavedStateHandle(),
                KRSApp().containerApp.repositoryMK
            )
        }
        initializer {
            DetailMKViewModel(
                createSavedStateHandle(),
                KRSApp().containerApp.repositoryMK
            )
        }
    }
}

fun CreationExtras.KRSApp(): KRSApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KRSApp)