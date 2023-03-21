package com.cinurawa.propertioid.ui.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.ui.molecules.HargaDetailRow
import com.cinurawa.propertioid.ui.molecules.IconTextBadge
import com.cinurawa.propertioid.ui.molecules.ThumbnailImage
import com.cinurawa.propertioid.ui.molecules.TitleDetailColumn
import com.cinurawa.propertioid.ui.theme.Blue500
import com.cinurawa.propertioid.ui.theme.Red500


@Composable
fun ProjectItem(
    modifier: Modifier = Modifier,
    onDetailClicked: () -> Unit = {}
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
        TitleDetailColumn(
            title = "Rumah Mewah di Jalan Kebon Sirih\"",
            detail = "Lorem ipsum dolor sit amet consectetur. Id viverra nec."
        )
        HargaDetailRow(harga = 200000000, onDetailClick = onDetailClicked)
    }
}