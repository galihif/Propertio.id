package com.cinurawa.propertioid.ui.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.ui.utils.formatHarga

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
            text = "Rp ${formatHarga(harga.toLong())}",
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.primary
        )
    }
}
@Composable
fun HargaColumn(
    modifier: Modifier = Modifier,
    hargaTerendah:Int,
    hargaTertinggi:Int,
    hargaTitle: String = "Harga",
) {
    Column(
        modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Text(
            text = hargaTitle,
            style = MaterialTheme.typography.body2
        )
        Text(
            text = "Rp ${formatHarga(hargaTerendah.toLong())} - Rp. ${formatHarga(hargaTertinggi.toLong())}",
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.primary
        )
    }
}