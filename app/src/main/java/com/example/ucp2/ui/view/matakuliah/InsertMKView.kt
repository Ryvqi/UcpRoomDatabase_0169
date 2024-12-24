package com.example.ucp2.ui.view.matakuliah

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ucp2.ui.viewmodel.matakuliah.FormErrorState
import com.example.ucp2.ui.viewmodel.matakuliah.MataKuliahEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormMataKuliah(
    matakuliahEvent: MataKuliahEvent = MataKuliahEvent(),
    onValueChange: (MataKuliahEvent) -> Unit,
    errorState: FormErrorState = FormErrorState(),
    dosenList: List<String>,
    modifier: Modifier = Modifier
){
    var chosenDosen by remember { mutableStateOf(matakuliahEvent.dosenpengampu) } // Default to the current value
    var expanded by remember { mutableStateOf(false) }

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

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Jenis Matakuliah")
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            jenis.forEach { jm ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    RadioButton(
                        selected = matakuliahEvent.jenis == jm,
                        onClick = {
                            onValueChange(matakuliahEvent.copy(jenis = jm))
                        }
                    )
                    Text(text = jm)
                }
            }
        }

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = chosenDosen,
                onValueChange = { },
                readOnly = true,
                label = { Text("Dosen Pengampu") },
                isError = errorState.dosenpengampu != null,
                modifier = Modifier.menuAnchor().fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null
                    )
                }
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                dosenList.forEach { dosen ->
                    DropdownMenuItem(
                        onClick = {
                            chosenDosen = dosen
                            onValueChange(matakuliahEvent.copy(dosenpengampu = dosen))
                            expanded = false
                        },
                        text = { Text(dosen) }
                    )
                }
            }
        }
        Text(text = errorState.dosenpengampu ?: "", color = Color.Red)
    }
}