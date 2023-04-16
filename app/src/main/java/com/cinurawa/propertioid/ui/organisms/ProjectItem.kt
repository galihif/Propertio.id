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
import com.cinurawa.propertioid.data.model.Project
import com.cinurawa.propertioid.ui.molecules.HargaDetailRow
import com.cinurawa.propertioid.ui.molecules.IconTextBadge
import com.cinurawa.propertioid.ui.molecules.ThumbnailImage
import com.cinurawa.propertioid.ui.molecules.TitleDetailColumn
import com.cinurawa.propertioid.ui.theme.Blue500
import com.cinurawa.propertioid.ui.theme.Purple700


@Composable
fun ProjectItem(
    modifier: Modifier = Modifier,
    onDetailClicked: () -> Unit = {},
    data:Project? = null,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        ThumbnailImage(modifier = Modifier.fillMaxWidth(), imageUrl = if (data?.photosUrl?.isNotEmpty() == true) data.photosUrl[0] else "https://www.cinurawa.com/wp-content/uploads/2021/05/IMG_20210518_105000.jpg")
        Row(
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconTextBadge(text = data?.type ?: "Rumah", icon = R.drawable.ic_house, color = Blue500)
            IconTextBadge(text = data?.certificate ?: "SHGB", icon = R.drawable.ic_shm, color = Purple700)
        }
        TitleDetailColumn(
            title = data?.name ?:"Name",
            detail = data?.address ?: "Address",
        )
        HargaDetailRow(hargaTitle = "Harga mulai dari",harga = data?.startPrice ?: 0, onDetailClick = onDetailClicked)
    }
}