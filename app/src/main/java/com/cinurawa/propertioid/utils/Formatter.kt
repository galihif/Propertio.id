package com.cinurawa.propertioid.utils


fun formatAgentPhotoUrl(id: String): String =
    "https://dev.propertio.id/data/image/users/$id"

fun getYoutubeId(url: String): String {
    return when {
        url.contains("youtu.be/") -> {
            url.substringAfterLast("/")
        }

        url.contains("watch?v=") -> {
            url.substringAfterLast("v=")
        }

        url.contains("/embed/") -> {
            url.substringAfterLast("/embed/")
        }

        url.length == 11 -> {
            url
        }

        else -> {
            throw IllegalArgumentException("Invalid YouTube URL")
        }
    }
}