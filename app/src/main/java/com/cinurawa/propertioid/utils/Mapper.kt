package com.cinurawa.propertioid.utils

import com.cinurawa.propertioid.data.model.Infrastructure
import com.cinurawa.propertioid.data.model.Project
import com.cinurawa.propertioid.data.model.Property
import com.cinurawa.propertioid.data.model.ProjectUnit
import com.cinurawa.propertioid.data.remote.dto.GetAllProjectDto
import com.cinurawa.propertioid.data.remote.dto.GetAllPropertyDto

fun GetAllPropertyDto.PropertyData.toModel(): Property =
    Property(
        id = this.id,
        name = this.title,
        desc = this.description,
        address = "${this.address}, ${this.district}, ${this.city} ${this.province} ${this.postalCode}",
        price = this.price,
        propertyCode = this.propertyCode,

        photosUrl = this.propertyPhoto.map { it.file },

        type = this.propertyType.name,
        listingType = this.listingType,
        certificate = this.certificate,

        condition = this.condition,
        facing = this.facing,
        yearBuilt = this.yearBuilt,

        floor = this.floor,
        surfaceArea = this.surfaceArea,
        buildingArea = this.buildingArea,
        bedroom = this.bedroom,
        bathroom = this.bathroom,
        garage = this.garage,
        carport = this.cartport,
        maidBedroom = this.maidBedroom,
        maidBathroom = this.maidBathroom,
        powerSupply = this.powerSupply,
        waterType = this.waterType,
        phoneLine = this.phoneLine,
        isFurniture = this.isFurniture == 1,

        virtualTour = if (this.propertyVirtualTour.isNotEmpty()) this.propertyVirtualTour[0].file else "",
        video = if (this.propertyVideo.isNotEmpty()) this.propertyVideo[0].link else "",

        latitude = this.latitude,
        longitude = this.longitude,

        dokumen = this.propertyDocument.map { it.file },
        fasilitas = this.propertyFacility.map { it.facilityType.name },
        infrastruktur = this.propertyInfrastructure.map { Infrastructure(it.name,it.distance) },

        agentImage = "",
        agentName = if (this.contactProperty.isNotEmpty()) this.contactProperty[0].name else "",
        agentPhone = if (this.contactProperty.isNotEmpty()) this.contactProperty[0].phone else "",
    )

fun GetAllProjectDto.Data.toModel() : Project =
    Project(
        id = this.id,
        name = this.title,
        desc = this.description.orEmpty(),
        concept = this.design.orEmpty(),
        address = "${this.address}, ${this.district}, ${this.city} ${this.province} ${this.postalCode}",
        startPrice = this.priceStart,
        finalPrice = this.priceFinal,
        code = this.projectCode,

        photosUrl = this.projectPhoto.map { it.file  },

        type = this.propertyType.name,
        certificate = this.certificate,

        virtualTour = if (this.projectVirtualTour.isNotEmpty()) this.projectVirtualTour[0].file else "",
        video = if (this.projectVideo.isNotEmpty()) this.projectVideo[0].link else "",

        latitude = this.latitude,
        longitude = this.longitude,

        listUnit = this.unit.map{ unit->
            ProjectUnit(
                id = unit.id,
                name = unit.title,
                desc = unit.description.orEmpty(),
                spec = unit.specification.orEmpty(),
                price = unit.price,
                code = unit.unitCode,
                photosUrl = unit.unitPhoto.map { it.file  },
                type = unit.type,
                floor = unit.floor,
                surfaceArea = unit.surfaceArea,
                buildingArea = unit.buildingArea,
                bedroom = unit.bedroom,
                bathroom = unit.bathroom,
                garage = unit.garage,
                powerSupply = unit.powerSupply,
                waterType = unit.waterType,
                virtualTour = if (unit.unitVirtualTour.isNotEmpty()) unit.unitVirtualTour[0].file else "",
                video = if (unit.unitVideo.isNotEmpty()) unit.unitVideo[0].link else "",

            )
        },

        dokumen = this.projectDocument.map { it.file },
        fasilitas = this.projectFacility.map { it.facilityType.name },
        infrastruktur = this.projectInfrastructure.map { Infrastructure(it.name,it.distance) },

        agentImage = "",
        agentName = if (this.contactProject.isNotEmpty()) this.contactProject[0].name else "",
        agentPhone = if (this.contactProject.isNotEmpty()) this.contactProject[0].phone else "",
    )

