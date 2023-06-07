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
import com.cinurawa.propertioid.data.model.ProjectUnit
import com.cinurawa.propertioid.data.model.Property
import com.cinurawa.propertioid.ui.molecules.*
import com.cinurawa.propertioid.ui.theme.Blue500
import com.cinurawa.propertioid.ui.theme.Purple500
import com.cinurawa.propertioid.ui.theme.Red500
import com.google.accompanist.flowlayout.FlowRow


@Composable
fun PropertyItem(
    modifier: Modifier = Modifier,
    onDetailClicked: () -> Unit = {},
    data: Property? = null
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        ThumbnailImage(modifier = Modifier.fillMaxWidth(), imageUrl = if(data?.photosUrl?.isNotEmpty() == true) data.photosUrl[0] else "")
        Row(
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconTextBadge(text = data?.type ?: "Type", icon = R.drawable.ic_house, color = Blue500)
            IconTextBadge(
                text = data?.listingType ?: "Listing Type",
                icon = R.drawable.ic_sell,
                color = Red500
            )
            IconTextBadge(
                text = data?.certificate ?: "Certificate",
                icon = R.drawable.ic_shm,
                color = Purple500
            )
        }
        TitleDetailColumn(
            title = data?.name ?: "Title",
            detail = data?.desc ?: "Detail"
        )
        IconText(
            leadingIcon = Icons.Default.LocationOn,
            text = data?.address ?: "Address",
            iconTint = Red500,
            maxLines = 2
        )
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            mainAxisSpacing = 14.dp,
            crossAxisSpacing = 14.dp
        ) {
            IconTextBadge(text = "${data?.floor} Lantai", leadingIcon = Icons.Default.Stairs)
            IconTextBadge(text = "${data?.surfaceArea} m2", leadingIcon = Icons.Default.AspectRatio)
            IconTextBadge(
                text = "${data?.buildingArea} m2",
                leadingIcon = Icons.Default.OtherHouses
            )
            IconTextBadge(text = "${data?.bedroom} K. Tidur", leadingIcon = Icons.Default.Bed)
            IconTextBadge(text = "${data?.bathroom} K. Mandi", leadingIcon = Icons.Default.Bathroom)
            IconTextBadge(text = "${data?.garage} Garasi", leadingIcon = Icons.Default.Garage)
        }
        HargaDetailRow(harga = data?.price ?: 0, onDetailClick = onDetailClicked, testTag = "lihat_detail_${data?.id}")
    }
}


@Composable
fun ProjectUnitItem(
    modifier: Modifier = Modifier,
    onDetailClicked: () -> Unit = {},
    data: ProjectUnit? = null
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        ThumbnailImage(modifier = Modifier.fillMaxWidth(), imageUrl = data?.photosUrl?.get(0))
        Row(
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconTextBadge(text = data?.type ?: "Type", icon = R.drawable.ic_house, color = Blue500)
        }
        TitleDetailColumn(
            title = data?.name ?: "Title",
            detail = data?.desc ?: "Detail"
        )
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            mainAxisSpacing = 14.dp,
            crossAxisSpacing = 14.dp
        ) {
            IconTextBadge(text = "${data?.floor} Lantai", leadingIcon = Icons.Default.Stairs)
            IconTextBadge(text = "${data?.surfaceArea} m2", leadingIcon = Icons.Default.AspectRatio)
            IconTextBadge(
                text = "${data?.buildingArea} m2",
                leadingIcon = Icons.Default.OtherHouses
            )
            IconTextBadge(text = "${data?.bedroom} K. Tidur", leadingIcon = Icons.Default.Bed)
            IconTextBadge(text = "${data?.bathroom} K. Mandi", leadingIcon = Icons.Default.Bathroom)
            IconTextBadge(text = "${data?.garage} Garasi", leadingIcon = Icons.Default.Garage)
        }
        HargaDetailRow(harga = data?.price ?: 0, onDetailClick = onDetailClicked, testTag = "lihat_detail_${data?.id}")
    }
}