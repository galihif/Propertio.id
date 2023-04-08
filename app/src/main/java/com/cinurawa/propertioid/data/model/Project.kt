package com.cinurawa.propertioid.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Project(
    val id: Int,
    val name: String,
    val desc: String,
    val concept:String,
    val address: String,
    val startPrice: Int,
    val finalPrice: Int,
    val code: String,

    val photosUrl: List<String>,

    val type: String,
    val certificate: String,

    val virtualTour: String? = null,
    val site3DPlan: String? = null,
    val arApps: String? = null,
    val video: String? = null,

    val latitude: Double,
    val longitude: Double,

    val dokumen: List<String>? = null,
    val fasilitas: List<String>? = null,
    val infrastruktur: List<Infrastructure>? = null,

    val agentImage: String,
    val agentName: String,
    val agentPhone: String,

    ) : Parcelable