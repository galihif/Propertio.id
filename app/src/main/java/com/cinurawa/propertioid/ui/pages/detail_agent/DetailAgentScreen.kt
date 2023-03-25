package com.cinurawa.propertioid.ui.pages.detail_agent

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.cinurawa.propertioid.ui.atoms.TitleSectionText
import com.cinurawa.propertioid.ui.molecules.*
import com.cinurawa.propertioid.ui.organisms.PropertyItem
import com.cinurawa.propertioid.ui.theme.Red500

@Composable
fun DetailAgentScreen(
    id:Int,
    onPropertyClicked: (Int) -> Unit = {}
) {
    LazyColumn(
        contentPadding = PaddingValues(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ){
        item{
            ThumbnailImage(
                modifier = Modifier.fillMaxWidth(),
                image = R.drawable.jisoo,
                isAgent = true,
            )
        } // ThumbnailImage
        item{
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
        } // Label
        item{
            TitleDetailColumn(
                title = "Jisoo Park",
                detail = "The most beautiful woman in the world",
            )
            IconText(
                text = "Gunpo, Gyeonggi Province, South Korea",
                leadingIcon = Icons.Default.LocationOn,
                iconTint = Red500
            )
        } // Title & Location
        item {
            ContactCard(
                text = "08123456789",
                leadingIcon = R.drawable.ic_phone,
                onClick = {}
            )
        }// Phone
        item{
            ContactCard(
                text = "Chat via Whatsapp",
                leadingIcon = R.drawable.ic_wa,
                bgColor = Color(0xFFF6F6F6),
                onClick = {}
            )
        } // Whatsapp
        item{
            TitleSectionText(title = "Daftar Properti")
        }
        items(5){
            PropertyItem(
                modifier = Modifier.fillMaxWidth(),
                onDetailClicked = {
                    onPropertyClicked(it)
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}