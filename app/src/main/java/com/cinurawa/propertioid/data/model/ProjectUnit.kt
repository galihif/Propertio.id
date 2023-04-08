package com.cinurawa.propertioid.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProjectUnit(
    val id: Int,
    val name: String,
    val desc: String,
    val spec: String,
    val price: Int,
    val code: String,

    val photosUrl: List<String>,

    val type: String,

    val floor: Int,
    val surfaceArea: Int,
    val buildingArea: Int,
    val bedroom: Int,
    val bathroom: Int,
    val garage: Int,
    val powerSupply: String,
    val waterType: String,

    val virtualTour: String? = null,
    val model3D:String? = null,
    val video: String? = null,

    ): Parcelable
