package com.cinurawa.propertioid.ui.organisms

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.ui.atoms.PrimaryButton
import com.cinurawa.propertioid.ui.molecules.IconText
import com.cinurawa.propertioid.ui.molecules.IconTextBadge
import com.cinurawa.propertioid.ui.molecules.ThumbnailImage
import com.cinurawa.propertioid.ui.molecules.TitleDetailColumn
import com.cinurawa.propertioid.ui.theme.Red500


@Composable
fun AgentItem(
    modifier: Modifier = Modifier,
    onDetailClicked: (Int) -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        ThumbnailImage(
            modifier = Modifier.fillMaxWidth(),
            image = R.drawable.jisoo,
            isAgent = true,
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconTextBadge(
                text = "10 Properti",
                icon = R.drawable.ic_house,
                color = MaterialTheme.colors.primary
            )
            IconTextBadge(
                text = "10 Terjual",
                leadingIcon = Icons.Filled.LocalOffer,
                color = Color(0xFF43936C)
            )
            IconTextBadge(
                text = "10 Tersewa",
                leadingIcon = Icons.Default.Key,
                color = Color(0xFFCD7B2E)
            )
        }
        TitleDetailColumn(
            title = "Jisoo Park",
            detail = "The most beautiful woman in the world",
        )
        IconText(
            text = "Gunpo, Gyeonggi Province, South Korea",
            leadingIcon = Icons.Default.LocationOn,
            iconTint = Red500
        )
        PrimaryButton(
            title = "Lihat Detail",
            onClick = { onDetailClicked(1) },
            contentPadding = PaddingValues(vertical = 12.dp)
        )
    }
}