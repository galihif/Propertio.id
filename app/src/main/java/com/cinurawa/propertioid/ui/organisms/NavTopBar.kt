package com.cinurawa.propertioid.ui.organisms

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.R

@Composable
fun NavTopBar(onMenuClick: () -> Unit) {
    TopAppBar(
        modifier = Modifier,
        navigationIcon = {
            IconButton(onClick = {
                onMenuClick()
            }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = ""
                )
            }
        },
        title = {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 8.dp),
                painter = painterResource(id = R.drawable.logo_propertio),
                contentDescription = "",
                alignment = Alignment.CenterStart
            )
        },
        backgroundColor = MaterialTheme.colors.background,
        elevation = 0.dp
    )
}