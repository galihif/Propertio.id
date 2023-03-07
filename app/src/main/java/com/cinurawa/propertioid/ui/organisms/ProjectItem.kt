package com.cinurawa.propertioid.ui.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.ui.molecules.HargaDetailFooter
import com.cinurawa.propertioid.ui.molecules.IconTextBadge
import com.cinurawa.propertioid.ui.molecules.ThumbnailImage
import com.cinurawa.propertioid.ui.theme.Blue500
import com.cinurawa.propertioid.ui.theme.Red500


@Composable
fun ProjectItem(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        ThumbnailImage(modifier = Modifier.fillMaxWidth())
        Row(
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconTextBadge(text = "Rumah", icon = R.drawable.ic_house, color = Blue500)
            IconTextBadge(text = "Jual", icon = R.drawable.ic_sell, color = Red500)
        }
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                text = "Rumah Mewah di Jalan Kebon Sirih",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Lorem ipsum dolor sit amet consectetur. Id viverra nec.",
                style = MaterialTheme.typography.body2
            )
        }
        HargaDetailFooter(harga = "Rp.200.000.000", onDetailClick = {})
    }
}