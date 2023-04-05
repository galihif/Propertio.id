package com.cinurawa.propertioid.ui.molecules

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.cinurawa.propertioid.R

@Composable
fun ThumbnailImage(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int = R.drawable.home_banner,
    isAgent: Boolean = false,
) {
    Box(modifier = modifier.wrapContentSize()) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(shape = RoundedCornerShape(10.dp)),
            painter = painterResource(id = image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
        )
        if(!isAgent){
            StarBadge(Modifier.align(Alignment.TopStart))
        }
    }
}

@Composable
fun ThumbnailImage(
    modifier: Modifier = Modifier,
    imageUrl:String?,
    isAgent: Boolean = false,
) {
    Box(modifier = modifier.wrapContentSize()) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(shape = RoundedCornerShape(10.dp)),
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = "",
            contentScale = ContentScale.Crop,
        )
        if(!isAgent){
            StarBadge(Modifier.align(Alignment.TopStart))
        }
    }
}



