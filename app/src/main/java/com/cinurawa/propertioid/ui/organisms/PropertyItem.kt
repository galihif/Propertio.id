package com.cinurawa.propertioid.ui.organisms

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.ui.molecules.IconTextBadge
import com.cinurawa.propertioid.ui.molecules.ThumbnailImage
import com.cinurawa.propertioid.ui.theme.Blue500
import com.cinurawa.propertioid.ui.theme.Purple500
import com.cinurawa.propertioid.ui.theme.Red500
import com.google.accompanist.flowlayout.FlowRow


@Composable
fun PropertyItem(
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
            IconTextBadge(text = "SHM", icon = R.drawable.ic_shm, color = Purple500)
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
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Default.LocationOn, contentDescription = "", tint = Red500)
            Text(text = "Jalan Kebon Sirih, Jakarta Pusat", style = MaterialTheme.typography.body2)
        }
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            mainAxisSpacing = 14.dp,
            crossAxisSpacing = 14.dp
        ) {
            IconTextBadge(text = "2 Lantai", icon = Icons.Default.Stairs)
            IconTextBadge(text = "200 m2", icon = Icons.Default.AspectRatio)
            IconTextBadge(text = "100 m2", icon = Icons.Default.OtherHouses)
            IconTextBadge(text = "2 K. Tidur", icon = Icons.Default.Bed)
            IconTextBadge(text = "2 K. Mandi", icon = Icons.Default.Bathroom)
            IconTextBadge(text = "1 Garasi", icon = Icons.Default.Garage)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = "Harga",
                    style = MaterialTheme.typography.body2
                )
                Text(
                    text = "Rp.500.000.000",
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.primary
                )
            }
            Button(
                onClick = {},
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
}
