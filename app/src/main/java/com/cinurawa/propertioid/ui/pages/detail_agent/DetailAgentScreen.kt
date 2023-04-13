package com.cinurawa.propertioid.ui.pages.detail_agent

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.data.model.Property
import com.cinurawa.propertioid.ui.atoms.TitleSectionText
import com.cinurawa.propertioid.ui.molecules.*
import com.cinurawa.propertioid.ui.organisms.PropertyItem
import com.cinurawa.propertioid.ui.theme.Red500

@Composable
fun DetailAgentScreen(
    id:Int,
    onPropertyClicked: (Property) -> Unit = {},
    viewModel: DetailAgentViewModel = hiltViewModel()
) {
    viewModel.setId(id)
    val context = LocalContext.current
    val agent by remember{
        viewModel.agent
    }.collectAsState()
    val isLoading by remember{
        viewModel.loading
    }.collectAsState()
    val error by remember{
        viewModel.error
    }.collectAsState()

    LaunchedEffect(error){
        if (error.isNotEmpty()){
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        }
    }

    LazyColumn(
        contentPadding = PaddingValues(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ){
        item{
            if (isLoading){
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
        item{
            ThumbnailImage(
                modifier = Modifier.fillMaxWidth(),
                imageUrl = agent.photoUrl,
                isAgent = true,
            )
        } // ThumbnailImage
        item{
            Row(
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconTextBadge(
                    text = "${agent.propertyCount} Properti",
                    icon = R.drawable.ic_house,
                    color = MaterialTheme.colors.primary
                )
                IconTextBadge(
                    text = "${agent.propertySold} Terjual",
                    leadingIcon = Icons.Filled.LocalOffer,
                    color = Color(0xFF43936C)
                )
                IconTextBadge(
                    text = "${agent.propertyRented} Tersewa",
                    leadingIcon = Icons.Default.Key,
                    color = Color(0xFFCD7B2E)
                )
            }
        } // Label
        item{
            TitleDetailColumn(
                title = agent.name,
                detail = "",
            )
            IconText(
                text = agent.address,
                leadingIcon = Icons.Default.LocationOn,
                iconTint = Red500
            )
        } // Title & Location
        item {
            ContactCard(
                text = agent.phone,
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
            TitleSectionText(
                title = "Daftar Properti",
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }
        items(agent.propertyList){
            PropertyItem(
                modifier = Modifier.fillMaxWidth(),
                onDetailClicked = {
                    onPropertyClicked(it)
                },
                data = it
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}