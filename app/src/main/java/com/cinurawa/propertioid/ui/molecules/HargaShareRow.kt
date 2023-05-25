package com.cinurawa.propertioid.ui.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.ui.atoms.MyIconButton

@Composable
fun HargaShare(
    modifier: Modifier = Modifier,
    harga: Int = 0,
    hargaTerendah: Int = 0,
    hargaTertinggi: Int = 0,
    hargaTitle: String = "Harga",
    onShareClick: () -> Unit = {}
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (hargaTerendah != 0 && hargaTertinggi != 0) {
            HargaColumn(
                modifier = Modifier.weight(1f),
                hargaTerendah = hargaTerendah,
                hargaTertinggi = hargaTertinggi,
                hargaTitle = hargaTitle
            )
        }
        else {
            HargaColumn(hargaTitle = hargaTitle, harga = harga)
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
//            MyIconButton(icon = Icons.Default.Print, onClick = { /*TODO*/ })
            MyIconButton(icon = Icons.Default.Share, onClick = onShareClick)
//            MyIconButton(icon = Icons.Default.Favorite, onClick = { /*TODO*/ })
        }
    }
}