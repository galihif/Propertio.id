package com.cinurawa.propertioid.ui.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.R

@Composable
fun ThumbnailImage(modifier: Modifier = Modifier) {
    Box(modifier = modifier.wrapContentSize()) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(shape = RoundedCornerShape(10.dp)),
            painter = painterResource(id = R.drawable.home_banner),
            contentDescription = "",
            contentScale = ContentScale.Crop,
        )
        StarCard(Modifier.align(Alignment.TopStart))
    }
}