package com.example.ucp2.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ucp2.KRSApp

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
            DeleteMKViewModel(
                createSavedStateHandle(),
                KRSApp().containerApp.repositoryMK
            )
        }
    }
}

fun CreationExtras.KRSApp(): KRSApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KRSApp)