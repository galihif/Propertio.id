package com.cinurawa.propertioid.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Infrastructure(
    val name:String,
    val distance:Int,
): Parcelable
