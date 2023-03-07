package com.cinurawa.propertioid.ui.molecules

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.ui.atoms.RoundedImage

@Composable
fun HomeBanner() {
    Box(
        modifier = Modifier.wrapContentSize(),
    ) {
        RoundedImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            image = R.drawable.home_banner
        )
        Text(
            text = "Temukan Hunian Impian Anda Hanya Disini!",
            color = Color.White,
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .matchParentSize()
                .padding(16.dp)
        )
    }
}