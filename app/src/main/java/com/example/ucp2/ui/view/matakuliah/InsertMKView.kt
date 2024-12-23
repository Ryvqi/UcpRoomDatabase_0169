package com.example.ucp2.ui.view.matakuliah

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.ucp2.ui.viewmodel.matakuliah.FormErrorState
import com.example.ucp2.ui.viewmodel.matakuliah.MataKuliahEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormMataKuliah(
    matakuliahEvent: MataKuliahEvent = MataKuliahEvent(),
    onValueChange: (MataKuliahEvent) -> Unit,
    errorState: FormErrorState = FormErrorState(),
    modifier: Modifier = Modifier
){
    val jenis = listOf("Wajib", "Peminatan")

    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = matakuliahEvent.kode,
            onValueChange = {
                onValueChange(matakuliahEvent.copy(kode = it))
            },
            label = { Text("Kode") },
            isError = errorState.kode != null,
            placeholder = { Text("Masukan kode Matakuliah") }
        )
        Text(
            text = errorState.kode ?: "",
            color = Color.Red
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = matakuliahEvent.nama,
            onValueChange = {
                onValueChange(matakuliahEvent.copy(nama = it))
            },
            label = { Text("Nama") },
            isError = errorState.nama != null,
            placeholder = { Text("Masukan nama Matakuliah") }
        )
        Text(
            text = errorState.nama ?: "",
            color = Color.Red
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = matakuliahEvent.sks.toString(), // Menampilkan nilai Int sebagai String
            onValueChange = {
                val parsedValue = it.toIntOrNull() ?: 0 // Parsing input ke Int, default ke 0 jika tidak valid
                onValueChange(matakuliahEvent.copy(sks = parsedValue))
            },
            label = { Text("SKS") },
            isError = errorState.sks != null, // Menandai jika ada kesalahan
            placeholder = { Text("Masukan jumlah SKS Matakuliah") }
        )
        Text(
            text = errorState.sks?.toString() ?: "",
            color = Color.Red
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = matakuliahEvent.semester.toString(), // Menampilkan nilai Int sebagai String
            onValueChange = {
                val parsedValue = it.toIntOrNull() ?: 0 // Parsing input ke Int, default ke 0 jika tidak valid
                onValueChange(matakuliahEvent.copy(semester = parsedValue))
            },
            label = { Text("Semester") },
            isError = errorState.semester != null, // Menandai jika ada kesalahan
            placeholder = { Text("Masukan Semester") }
        )
        Text(
            text = errorState.sks?.toString() ?: "",
            color = Color.Red
        )
    }
}