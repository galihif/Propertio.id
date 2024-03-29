package com.cinurawa.propertioid.ui.molecules

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.ui.atoms.RoundedImage

@Composable
fun HomeBanner(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.wrapContentSize(),
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
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .matchParentSize()
                .padding(16.dp)
        )
    }
}