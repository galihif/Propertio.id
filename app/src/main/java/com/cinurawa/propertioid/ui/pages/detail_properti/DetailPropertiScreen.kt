package com.cinurawa.propertioid.ui.pages.detail_properti

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.ui.molecules.IconText
import com.cinurawa.propertioid.ui.molecules.IconTextBadge
import com.cinurawa.propertioid.ui.organisms.ImageCarousel
import com.cinurawa.propertioid.ui.theme.Blue500
import com.cinurawa.propertioid.ui.theme.PropertioidTheme
import com.cinurawa.propertioid.ui.theme.Purple500
import com.cinurawa.propertioid.ui.theme.Red500
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun DetailPropertiScreen(
    id: Int
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            ImageCarousel(
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        item {
            Row(
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                IconTextBadge(text = "Rumah", icon = R.drawable.ic_house, color = Blue500)
                IconTextBadge(text = "Jual", icon = R.drawable.ic_sell, color = Red500)
                IconTextBadge(text = "SHM", icon = R.drawable.ic_shm, color = Purple500)
            }
        }
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Old House", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                IconTextBadge(text = "Properti Kode : 5237KM", leadingIcon = null)
            }
        }
        item {
            Text(
                text = "Lorem ipsum dolor sit amet consectetur. Id viverra nec.",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }
        item {
            IconText(
                modifier = Modifier.padding(horizontal = 24.dp),
                leadingIcon = Icons.Default.LocationOn,
                text = "Jl. Kebon Jeruk No. 12, Jakarta Barat",
                iconTint = Red500
            )
        }

    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun DetailPropertiScreenPreview() {
    PropertioidTheme {
        DetailPropertiScreen(1)
    }
}