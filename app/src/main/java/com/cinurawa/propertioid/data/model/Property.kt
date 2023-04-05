package com.cinurawa.propertioid.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Property(
    val id: Int,
    val name: String,
    val desc: String,
    val address: String,
    val price: Int,
    val propertyCode: String,

    val photo: List<String>,

    val type: String,
    val listingType: String,
    val certificate: String,

    val condition: String,
    val facing: String,
    val yearBuilt: Int,

    val floor: Int,
    val surfaceArea: Int,
    val buildingArea: Int,
    val bedroom: Int,
    val bathroom: Int,
    val garage: Int,
    val carport: Int,
    val maidBedroom: Int,
    val maidBathroom: Int,
    val powerSupply: String,
    val waterType: String,
    val phoneLine: Int,
    val isFurniture: Boolean,

    val virtualTour: String? = null,
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