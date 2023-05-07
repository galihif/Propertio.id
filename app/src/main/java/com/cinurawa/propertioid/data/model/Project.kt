package com.cinurawa.propertioid.data.model

data class Project(
    val id: Int,
    val slug: String,
    val name: String,
    val desc: String,
    val concept:String,
    val address: String,
    val startPrice: Int,
    val finalPrice: Int,
    val code: String,

    val photosUrl: List<String>,

    val type: String,
    val certificate: String,

    ){
    var virtualTour: String = ""
    var site3DPlan: String = ""
    var arApps: String = ""
    var video: String = ""

    var latitude: Double = 0.0
    var longitude: Double = 0.0

    var listUnit: List<ProjectUnit> = emptyList()

    var dokumen: List<Dokumen> = emptyList()
    var fasilitas: List<String> = emptyList()
    var infrastruktur: List<Infrastructure> = emptyList()

    var agentImage: String = ""
    var agentName: String = ""
    var agentPhone: String = ""
}

fun getEmptyProject() =
    Project(
        id = 0,
        slug = "",
        name = "",
        desc = "",
        concept = "",
        address = "",
        startPrice = 0,
        finalPrice = 0,
        code = "",
        photosUrl = emptyList(),
        type = "",
        certificate = ""
    )