package com.cinurawa.propertioid.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Agent(
    val id:Int,
    val name:String,
    val desc:String,
    val address:String,
    val photoUrl:String,

    val propertyCount:Int,
    val propertySold:Int,
    val propertyRented:Int,

    val phone:String,


): Parcelable{
    var propertyList:List<Property> = emptyList()
}
