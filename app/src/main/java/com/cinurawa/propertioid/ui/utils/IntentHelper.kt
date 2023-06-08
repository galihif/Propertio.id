package com.cinurawa.propertioid.ui.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

object IntentHelper {

    fun openMaps(context: Context, mapUri:Uri){
        val mapIntent = Intent(Intent.ACTION_VIEW, mapUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        context.startActivity(mapIntent)
    }
    fun openDokumen(context: Context, url: String){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        context.startActivity(intent)
    }
    fun openWhatsapp(context: Context, number: String){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://wa.me/$number")
        context.startActivity(intent)
    }
    fun callNumber(context: Context, number: String){
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$number")
        context.startActivity(intent)
    }

    fun shareToApps(context: Context, message: String){
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, message)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        val chooser = Intent.createChooser(intent, "Share message with:")
        context.startActivity(chooser)
    }
}