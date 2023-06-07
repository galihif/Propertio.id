package com.cinurawa.propertioid.ui.organisms

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.data.model.Developer
import com.cinurawa.propertioid.ui.atoms.PrimaryButton
import com.cinurawa.propertioid.ui.molecules.IconText
import com.cinurawa.propertioid.ui.molecules.IconTextBadge
import com.cinurawa.propertioid.ui.molecules.ThumbnailImage
import com.cinurawa.propertioid.ui.molecules.TitleDetailColumn
import com.cinurawa.propertioid.ui.theme.Red500


@Composable
fun DeveloperItem(
    modifier: Modifier = Modifier,
    onDetailClicked: () -> Unit = {},
    data: Developer? = null
) {
    if (data != null) {
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            ThumbnailImage(
                imageUrl = data.imageUrl,
                modifier = Modifier.fillMaxWidth(),
                isAgent = true
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconTextBadge(
                    text = "${data.projectCount} Project",
                    icon = R.drawable.ic_house,
                    color = MaterialTheme.colors.primary
                )
            }
            TitleDetailColumn(
                title = data.name,
                detail = "",
            )
            IconText(
                text = data.address,
                leadingIcon = Icons.Default.LocationOn,
                iconTint = Red500
            )
            PrimaryButton(
                title = "Lihat Detail",
                onClick = onDetailClicked,
                contentPadding = PaddingValues(vertical = 12.dp),
                modifier = Modifier.testTag("lihat_detail_${data.id}")
            )
        }
    }
}