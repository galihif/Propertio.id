package com.cinurawa.propertioid.utils


fun formatAgentPhotoUrl(id: String): String =
    "https://dev.propertio.id/data/image/users/$id"

fun getYoutubeWatchUrl(url: String): String {
    return when {
        url.contains("youtu.be/") -> {
            val videoId = url.substringAfterLast("/")
            "https://www.youtube.com/watch?v=$videoId"
        }

        url.contains("watch?v=") -> {
            val videoId = url.substringAfterLast("v=")
            "https://www.youtube.com/watch?v=$videoId"
        }

        url.contains("/embed/") -> {
            val videoId = url.substringAfterLast("/embed/")
            "https://www.youtube.com/watch?v=$videoId"
        }

        url.length == 11 -> {
            "https://www.youtube.com/watch?v=$url"
        }

        else -> {
            throw IllegalArgumentException("Invalid YouTube URL")
        }
    }
}