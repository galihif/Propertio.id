package com.cinurawa.propertioid.ui.model

import androidx.annotation.DrawableRes

data class CarouselContent(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)
