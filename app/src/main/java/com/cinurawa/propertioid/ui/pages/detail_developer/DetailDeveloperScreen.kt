package com.cinurawa.propertioid.ui.pages.detail_developer

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.ui.atoms.TitleSectionText
import com.cinurawa.propertioid.ui.molecules.*
import com.cinurawa.propertioid.ui.organisms.ProjectItem
import com.cinurawa.propertioid.ui.theme.Red500

@Composable
fun DetailDeveloperScreen(
    id:Int,
    onProjectClicked: (slug:String) -> Unit = {},
    viewModel: DetailDeveloperViewModel = hiltViewModel()
) {
    viewModel.setId(id)
    val context = LocalContext.current
    val developer by remember{
        viewModel.developer
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
                imageUrl = developer.imageUrl,
                isAgent = true,
            )
        } // ThumbnailImage
        item{
            Row(
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconTextBadge(
                    text = "${developer.projectCount} Properti",
                    icon = R.drawable.ic_house,
                    color = MaterialTheme.colors.primary
                )
            }
        } // Label
        item{
            TitleDetailColumn(
                title = developer.name,
                detail = "",
            )
            IconText(
                text = developer.address,
                leadingIcon = Icons.Default.LocationOn,
                iconTint = Red500
            )
        } // Title & Location
        item {
            ContactCard(
                text = developer.phone,
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
        items(developer.projectList){
            ProjectItem(
                modifier = Modifier.fillMaxWidth(),
                onDetailClicked = {
                                  onProjectClicked(it.slug)
                },
                data = it
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}