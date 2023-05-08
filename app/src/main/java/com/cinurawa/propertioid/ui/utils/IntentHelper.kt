package com.cinurawa.propertioid.ui.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

object IntentHelper {
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
}