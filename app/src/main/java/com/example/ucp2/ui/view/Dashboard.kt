package com.example.ucp2.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Dashboard(
    onNavigateToDsn: () -> Unit,
    onNavigateToMk: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "KRS Universitas Muhammadiyah Yogyakarta", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        Button (
            onClick = onNavigateToDsn,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Dosen")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = onNavigateToMk,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Mata Kuliah")
        }
    }
}
