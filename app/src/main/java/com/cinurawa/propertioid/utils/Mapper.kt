package com.cinurawa.propertioid.utils

import com.cinurawa.propertioid.data.model.Infrastructure
import com.cinurawa.propertioid.data.model.Property
import com.cinurawa.propertioid.data.remote.dto.GetAllPropertyDto

fun GetAllPropertyDto.PropertyData.toModel(): Property =
    Property(
        id = this.id,
        name = this.title,
        desc = this.description,
        address = "${this.address}, ${this.district}, ${this.city} ${this.province} ${this.postalCode}",
        price = this.price,
        propertyCode = this.propertyCode,

        photosUrl = this.propertyPhoto.map { formatPropertyPhotoUrl(it.file) },

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