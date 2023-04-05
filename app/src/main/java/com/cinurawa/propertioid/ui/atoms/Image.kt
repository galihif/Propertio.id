package com.cinurawa.propertioid.ui.atoms

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun RoundedImage(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    cornerRadius: Int = 14
) {
    Image(
        painter = painterResource(image),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .height(200.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(cornerRadius.dp))
    )
}


@Composable
fun MyImage(
    modifier: Modifier = Modifier,
    height: Int = 200,
    image: String,
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(image)
            .crossfade(true)
            .build(),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .height(height.dp)
            .fillMaxWidth()
    )
}



