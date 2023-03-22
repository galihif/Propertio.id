package com.cinurawa.propertioid.ui.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun HargaColumn(
    harga:Int,
    hargaTitle: String = "Harga",
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Text(
            text = hargaTitle,
            style = MaterialTheme.typography.body2
        )
        Text(
            text = "Rp. $harga",
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.primary
        )
    }
}