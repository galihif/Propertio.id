package com.cinurawa.propertioid.utils

import android.net.Uri

fun formatPropertyPhotoUrl(photo: String): String =
    "https://dev.propertio.id/data/image/property/property_photos/$photo"

fun formatGmapsUri(label:String,lat: Double, long: Double, zoom:Int = 15): Uri =
    Uri.parse("geo:$lat,$long?q=$lat,$long($label)&z=$zoom")