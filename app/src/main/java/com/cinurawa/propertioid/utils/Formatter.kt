package com.cinurawa.propertioid.utils

import android.net.Uri

fun formatHarga(value: Long): String {
    return String.format("%,d", value).replace(",", ".")
}


fun formatAgentPhotoUrl(id: String): String =
    "https://dev.propertio.id/data/image/users//$id"

fun encodeUrl(url: String): String =
    Uri.encode(url)

fun decodeUrl(url: String): String =
    Uri.decode(url)

fun formatPropertyDocumentUrl(id: String): String =
    "https://drive.google.com/viewerng/viewer?embedded=true&url=https://dev.propertio.id/data/file/property/property_documents/$id"

fun formatGmapsUri(label:String,lat: Double, long: Double, zoom:Int = 15): Uri =
    Uri.parse("geo:$lat,$long?q=$lat,$long($label)&z=$zoom")