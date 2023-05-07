package com.cinurawa.propertioid.data.model

data class Property(
    val id: Int,
    val slug:String,
    val name: String,
    val desc: String,
    val address: String,
    val price: Int,

    val photosUrl: List<String>,

    val type: String,
    val listingType: String,
    val certificate: String,

    val floor: Int,
    val surfaceArea: Int,
    val buildingArea: Int,
    val bedroom: Int,
    val bathroom: Int,
    val garage: Int,
    val carport: Int,
    ) {

    var propertyCode: String = ""

    var condition: String = ""
    var facing: String = ""
    var yearBuilt: Int = 0

    var maidBedroom: Int = 0
    var maidBathroom: Int = 0
    var powerSupply: String = ""
    var waterType: String = ""
    var phoneLine: Int = 0
    var isFurniture: Boolean = false

    var virtualTour: String = ""
    var video: String = ""

    var latitude: Double = 0.0
    var longitude: Double = 0.0

    var dokumen: List<Dokumen>? = null
    var fasilitas: List<String>? = null
    var infrastruktur: List<Infrastructure>? = null

    var agentImage: String = ""
    var agentName: String = ""
    var agentPhone: String = ""

}

fun emptyProperty(): Property {
    return Property(
        id = 0,
        slug = "",
        name = "",
        desc = "",
        address = "",
        price = 0,
        photosUrl = emptyList(),
        type = "",
        listingType = "",
        certificate = "",
        floor = 0,
        surfaceArea = 0,
        buildingArea = 0,
        bedroom = 0,
        bathroom = 0,
        garage = 0,
        carport = 0
    )
}