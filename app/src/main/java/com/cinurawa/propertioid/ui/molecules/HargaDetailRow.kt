package com.cinurawa.propertioid.ui.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HargaDetailRow(
    modifier: Modifier = Modifier,
    harga: Int,
    hargaTitle:String = "Harga",
    onDetailClick: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        HargaColumn( hargaTitle = hargaTitle,harga = harga)
        Button(
            onClick = {
                onDetailClick()
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
            shape = RoundedCornerShape(6.dp),
        ) {
            Text(
                text = "Lihat Detail",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}