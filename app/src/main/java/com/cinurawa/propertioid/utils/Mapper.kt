package com.cinurawa.propertioid.utils

import com.cinurawa.propertioid.data.model.*
import com.cinurawa.propertioid.data.remote.dto.*

fun GetAllPropertyDto.PropertyData.toModel(): Property =
    Property(
        id = this.id,
        slug = this.slug,
        name = this.title,
        desc = this.description,
        address = "${this.address}, ${this.district}, ${this.city} ${this.province} ${this.postalCode}",
        price = this.price,

        photosUrl = this.propertyPhoto.map { it.file },

        type = this.propertyType.name,
        listingType = this.listingType,
        certificate = this.certificate,

        floor = this.floor,
        surfaceArea = this.surfaceArea,
        buildingArea = this.buildingArea,
        bedroom = this.bedroom,
        bathroom = this.bathroom,
        garage = this.garage,
        carport = this.cartport,
    )

fun GetDetailPropertyDto.Data.toModel(): Property =
    Property(
        id = this.id,
        slug = this.slug,
        name = this.title,
        desc = this.description,
        address = "${this.address}, ${this.district}, ${this.city} ${this.province} ${this.postalCode}",
        price = this.price,

        photosUrl = this.propertyPhoto.map { it.file },

        type = this.propertyType.name,
        listingType = this.listingType,
        certificate = this.certificate,

        floor = this.floor,
        surfaceArea = this.surfaceArea,
        buildingArea = this.buildingArea,
        bedroom = this.bedroom,
        bathroom = this.bathroom,
        garage = this.garage,
        carport = this.cartport,
    ).apply {
        this.propertyCode = this@toModel.propertyCode

        this.facing = this@toModel.facing
        this.condition = this@toModel.condition
        this.yearBuilt = this@toModel.yearBuilt

        this.maidBathroom = this@toModel.maidBathroom
        this.maidBedroom = this@toModel.maidBedroom
        this.powerSupply = this@toModel.powerSupply
        this.waterType = this@toModel.waterType
        this.phoneLine = this@toModel.phoneLine
        this.isFurniture = this@toModel.isFurniture == 1

        this.virtualTour =
            if (this@toModel.propertyVirtualTour.isNotEmpty()) this@toModel.propertyVirtualTour[0].file else ""
        this.video =
            if (this@toModel.propertyVideo.isNotEmpty()) this@toModel.propertyVideo[0].link else ""

        this.latitude = this@toModel.latitude
        this.longitude = this@toModel.longitude

        this.dokumen = this@toModel.propertyDocument.map { it.file }
        this.fasilitas = this@toModel.propertyDocument.map { it.name }
        this.infrastruktur =
            this@toModel.propertyInfrastructure.map { Infrastructure(it.name, it.distance) }

        this.agentImage = this@toModel.agent.user.userDatas.pictureProfile
        this.agentName = this@toModel.agent.user.userDatas.fullname
        this.agentPhone = this@toModel.agent.user.userDatas.phone
    }

fun GetDetailProjectDto.Data.toModel(): Project =
    Project(
        id = this.id,
        slug = this.slug,
        name = this.title,
        desc = this.description,
        concept = this.design,
        address = "${this.address}, ${this.district}, ${this.city} ${this.province} ${this.postalCode}",
        startPrice = this.priceStart,
        finalPrice = this.priceFinal,
        code = this.projectCode,

        photosUrl = this.projectPhoto.map { it.file },

        type = this.listingPackageType.toString(),
        certificate = this.certificate,

        ).apply {
        this.virtualTour = if(this@toModel.projectVirtualTour.isNotEmpty()) this@toModel.projectVirtualTour[0].file else ""
        this.site3DPlan = this@toModel.siteplanLink
        this.arApps = this@toModel.appsLink.toString()
        this.video = if(this@toModel.projectVideo.isNotEmpty()) this@toModel.projectVideo[0].link else ""

        this.latitude = this@toModel.latitude
        this.longitude = this@toModel.longitude

        this.listUnit = this@toModel.unit.map {
            ProjectUnit(
                id = it.id,
                name = it.title,
                desc = it.description,
                code = it.unitCode,
                price = it.price,
                photosUrl = it.unitPhoto.map { photo -> photo.file },
                type = it.type,
                floor = it.floor,
                surfaceArea = it.surfaceArea,
                buildingArea = it.buildingArea,
                bedroom = it.bedroom,
                bathroom = it.bathroom,
                garage = it.garage,
                powerSupply = it.powerSupply,
                waterType = it.waterType,
                spec = "",
            )
        }

        this.dokumen = this@toModel.projectDocument.map { it.file }
        this.fasilitas = this@toModel.projectFacility.map { it.facilityType.name }
        this.infrastruktur = this@toModel.projectInfrastructure.map { Infrastructure(it.name, it.distance) }

        this.agentName = if (this@toModel.contactProject.isNotEmpty()) this@toModel.contactProject[0].name else ""
        this.agentPhone = if (this@toModel.contactProject.isNotEmpty()) this@toModel.contactProject[0].phone else ""

    }

fun GetDetailAgentDto.Data.AgentProperty.toModel(): Property =
    Property(
        id = this.id,
        slug = this.slug,
        name = this.title,
        desc = this.description,
        address = "${this.address}, ${this.district}, ${this.city} ${this.province} ${this.postalCode}",
        price = this.price,

        photosUrl = this.propertyPhoto.map { it.file },

        type = "",
        listingType = this.listingType,
        certificate = this.certificate,

        floor = this.floor,
        surfaceArea = this.surfaceArea,
        buildingArea = this.buildingArea,
        bedroom = this.bedroom,
        bathroom = this.bathroom,
        garage = this.garage,
        carport = this.cartport ?: 0,
    )


fun GetAllProjectDto.Data.toModel(): Project =
    Project(
        id = this.id,
        slug = this.slug,
        name = this.title,
        desc = this.description.orEmpty(),
        concept = this.design.orEmpty(),
        address = "${this.address}, ${this.district}, ${this.city} ${this.province} ${this.postalCode}",
        startPrice = this.priceStart,
        finalPrice = this.priceFinal,
        code = this.projectCode,

        photosUrl = this.projectPhoto.map { it.file },

        type = this.propertyType.name,
        certificate = this.certificate,
    )

fun GetAllAgentDto.Data.toModel(): Agent =
    Agent(
        id = this.id,
        name = this.userDatas.fullname,
        desc = "",
        address = "${this.userDatas.address}, ${this.userDatas.city}, ${this.userDatas.province}",
        photoUrl = formatAgentPhotoUrl(this.userDatas.pictureProfile.orEmpty()),

        propertyCount = this.agentProperties.size,
        propertySold = 0,
        propertyRented = 0,

        phone = this.userDatas.phone,
    )

fun GetDetailAgentDto.Data.toModel(): Agent {
    val agent = Agent(
        id = this.id,
        name = this.userDatas.fullname,
        desc = "",
        address = "${this.userDatas.address}, ${this.userDatas.city}, ${this.userDatas.province}",
        photoUrl = formatAgentPhotoUrl(this.userDatas.pictureProfile),

        propertyCount = this.agentProperties.size,
        propertySold = 0,
        propertyRented = 0,

        phone = this.userDatas.phone,
    )
    agent.propertyList = this.agentProperties.map { it.toModel() }
    return agent
}

fun GetAllDeveloperDto.Data.toModel() =
    Developer(
        id = this.id,
        name = this.userDatas.fullname,
        address = "${this.userDatas.address}, ${this.userDatas.city} ${this.userDatas.province} ",
        imageUrl = this.userDatas.pictureProfile.toString(),
        projectCount = this.developerProjects.size,
    )

