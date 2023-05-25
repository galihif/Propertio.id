package com.cinurawa.propertioid.ui.utils

import android.net.Uri

fun formatHarga(value: Long): String {
    return String.format("%,d", value).replace(",", ".")
}

fun encodeUrl(url: String): String =
    Uri.encode(url)

fun decodeUrl(url: String): String =
    Uri.decode(url)

fun formatGmapsUri(label: String, lat: Double, long: Double, zoom: Int = 15): Uri =
    Uri.parse("geo:$lat,$long?q=$lat,$long($label)&z=$zoom")

fun formatShareMessage(
    name: String,
    price: String,
    slug: String
):String =
    "Yuk cek properti ini di Propertio.id \n" +
            "$name \n" +
            "Harga Rp $price \n" +
            "Lihat di https://dev.propertio.id/iklan-properti/detail/$slug"

fun formatShareMessage(
    name: String,
    startPrice: String,
    finalPrice: String,
    slug: String
):String =
    "Yuk cek proyek ini di Propertio.id \n" +
            "$name \n" +
            "Harga mulai dari Rp $startPrice - $finalPrice \n" +
            "Lihat di https://dev.propertio.id/iklan-project/detail/$slug"

