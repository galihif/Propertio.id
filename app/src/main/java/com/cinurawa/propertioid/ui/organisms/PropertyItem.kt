package com.cinurawa.propertioid.ui.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.ui.molecules.*
import com.cinurawa.propertioid.ui.theme.Blue500
import com.cinurawa.propertioid.ui.theme.Purple500
import com.cinurawa.propertioid.ui.theme.Red500
import com.google.accompanist.flowlayout.FlowRow


@Composable
fun PropertyItem(
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
            IconTextBadge(text = "SHM", icon = R.drawable.ic_shm, color = Purple500)
        }
        TitleDetailColumn(
            title = "Rumah Mewah di Jalan Kebon Sirih\"",
            detail = "Lorem ipsum dolor sit amet consectetur. Id viverra nec."
        )
        IconText(
            leadingIcon = Icons.Default.LocationOn,
            text = "Jl. Kebon Jeruk No. 12, Jakarta Barat",
            iconTint = Red500
        )
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            mainAxisSpacing = 14.dp,
            crossAxisSpacing = 14.dp
        ) {
            IconTextBadge(text = "2 Lantai", leadingIcon = Icons.Default.Stairs)
            IconTextBadge(text = "200 m2", leadingIcon = Icons.Default.AspectRatio)
            IconTextBadge(text = "100 m2", leadingIcon = Icons.Default.OtherHouses)
            IconTextBadge(text = "2 K. Tidur", leadingIcon = Icons.Default.Bed)
            IconTextBadge(text = "2 K. Mandi", leadingIcon = Icons.Default.Bathroom)
            IconTextBadge(text = "1 Garasi", leadingIcon = Icons.Default.Garage)
        }
        HargaDetailFooter(harga = "Rp.500.000.000", onDetailClick = onDetailClicked)
    }
}
