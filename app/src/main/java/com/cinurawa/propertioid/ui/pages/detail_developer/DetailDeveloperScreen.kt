package com.cinurawa.propertioid.ui.pages.detail_developer

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.ui.atoms.TitleSectionText
import com.cinurawa.propertioid.ui.molecules.ContactCard
import com.cinurawa.propertioid.ui.molecules.ErrorColumn
import com.cinurawa.propertioid.ui.molecules.IconText
import com.cinurawa.propertioid.ui.molecules.IconTextBadge
import com.cinurawa.propertioid.ui.molecules.ThumbnailImage
import com.cinurawa.propertioid.ui.molecules.TitleDetailColumn
import com.cinurawa.propertioid.ui.organisms.ProjectItem
import com.cinurawa.propertioid.ui.theme.Red500

@Composable
fun DetailDeveloperScreen(
    id: Int,
    onProjectClicked: (slug: String) -> Unit = {},
    viewModel: DetailDeveloperViewModel = hiltViewModel()
) {
    viewModel.setId(id)
    val context = LocalContext.current
    val developer by remember {
        viewModel.developer
    }.collectAsState()
    val isLoading by remember {
        viewModel.loading
    }.collectAsState()
    val error by remember {
        viewModel.error
    }.collectAsState()

    LaunchedEffect(error) {
        if (error.isNotEmpty()) {
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        }
    }

    if (error.isNotEmpty()) {
        ErrorColumn(error = error)
    } else {
        LazyColumn(
            contentPadding = PaddingValues(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.testTag("detail_developer_screen")
        ) {
            item {
                if (isLoading) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
            item {
                ThumbnailImage(
                    modifier = Modifier.fillMaxWidth().testTag("thumbnail_image"),
                    imageUrl = developer.imageUrl,
                    isAgent = true,
                )
            } // ThumbnailImage
            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    IconTextBadge(
                        text = "${developer.projectCount} Project",
                        icon = R.drawable.ic_house,
                        color = MaterialTheme.colors.primary
                    )
                }
            } // Label
            item {
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
                    modifier = Modifier.fillMaxWidth(),
                    text = developer.phone,
                    leadingIcon = R.drawable.ic_phone,
                    onClick = {}
                )
            }// Phone
            item {
                ContactCard(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Chat via Whatsapp",
                    leadingIcon = R.drawable.ic_wa,
                    bgColor = Color(0xFFF6F6F6),
                    onClick = {}
                )
            } // Whatsapp
            item {
                TitleSectionText(
                    title = "Daftar Project",
                    modifier = Modifier
                        .fillMaxWidth(),
                )
            }
            items(developer.projectList) {
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
}