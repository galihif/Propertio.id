package com.cinurawa.propertioid.utils

import com.cinurawa.propertioid.data.model.Project
import com.cinurawa.propertioid.data.model.Property

object DummyData {
    fun listProperty(): List<Property> {
        val propertyList = mutableListOf<Property>()

        // Contoh property 1
        val property1 = Property(
            id = 1,
            slug = "contoh-property-1",
            name = "Contoh Property 1",
            desc = "Ini adalah contoh deskripsi property 1",
            address = "Jalan Contoh No. 1",
            price = 200000000,

            photosUrl = listOf(
                "https://example.com/property1/photo1.jpg",
                "https://example.com/property1/photo2.jpg",
                "https://example.com/property1/photo3.jpg",
            ),

            type = "Rumah",
            listingType = "Jual",
            certificate = "SHM",

            floor = 2,
            surfaceArea = 150,
            buildingArea = 200,
            bedroom = 4,
            bathroom = 3,
            garage = 1,
            carport = 1,
        )
        propertyList.add(property1)

        // Contoh property 2
        val property2 = Property(
            id = 2,
            slug = "contoh-property-2",
            name = "Contoh Property 2",
            desc = "Ini adalah contoh deskripsi property 2",
            address = "Jalan Contoh No. 2",
            price = 150000000,

            photosUrl = listOf(
                "https://example.com/property2/photo1.jpg",
                "https://example.com/property2/photo2.jpg",
            ),

            type = "Apartemen",
            listingType = "Sewa",
            certificate = "HGB",

            floor = 5,
            surfaceArea = 70,
            buildingArea = 100,
            bedroom = 2,
            bathroom = 1,
            garage = 0,
            carport = 0,
        )
        propertyList.add(property2)

        // Contoh property 3
        val property3 = Property(
            id = 3,
            slug = "contoh-property-3",
            name = "Contoh Property 3",
            desc = "Ini adalah contoh deskripsi property 3",
            address = "Jalan Contoh No. 3",
            price = 1000000000,

            photosUrl = listOf(
                "https://example.com/property3/photo1.jpg",
            ),

            type = "Villa",
            listingType = "Jual",
            certificate = "SHM",

            floor = 1,
            surfaceArea = 1000,
            buildingArea = 800,
            bedroom = 6,
            bathroom = 5,
            garage = 2,
            carport = 3,
        )
        propertyList.add(property3)

        return propertyList
    }

    fun listProject(): List<Project> {
        val projectList = mutableListOf<Project>()

        // Contoh proyek 1
        val project1 = Project(
            id = 1,
            slug = "contoh-proyek-1",
            name = "Contoh Proyek 1",
            desc = "Ini adalah contoh deskripsi proyek 1",
            concept = "Rumah minimalis modern",
            address = "Jalan Contoh No. 1",
            startPrice = 500000000,
            finalPrice = 450000000,
            code = "CP001",

            photosUrl = listOf(
                "https://example.com/project1/photo1.jpg",
                "https://example.com/project1/photo2.jpg",
                "https://example.com/project1/photo3.jpg",
            ),

            type = "Rumah",
            certificate = "SHM",
        )
        projectList.add(project1)

        // Contoh proyek 2
        val project2 = Project(
            id = 2,
            slug = "contoh-proyek-2",
            name = "Contoh Proyek 2",
            desc = "Ini adalah contoh deskripsi proyek 2",
            concept = "Apartemen mewah dengan fasilitas lengkap",
            address = "Jalan Contoh No. 2",
            startPrice = 1000000000,
            finalPrice = 800000000,
            code = "CP002",

            photosUrl = listOf(
                "https://example.com/project2/photo1.jpg",
                "https://example.com/project2/photo2.jpg",
                "https://example.com/project2/photo3.jpg",
            ),

            type = "Apartemen",
            certificate = "HGB",
        )
        projectList.add(project2)

        // Contoh proyek 3
        val project3 = Project(
            id = 3,
            slug = "contoh-proyek-3",
            name = "Contoh Proyek 3",
            desc = "Ini adalah contoh deskripsi proyek 3",
            concept = "Perumahan eksklusif dengan akses langsung ke pantai",
            address = "Jalan Contoh No. 3",
            startPrice = 2000000000,
            finalPrice = 1800000000,
            code = "CP003",

            photosUrl = listOf(
                "https://example.com/project3/photo1.jpg",
                "https://example.com/project3/photo2.jpg",
            ),

            type = "Rumah",
            certificate = "SHM",
        )
        projectList.add(project3)

        return projectList
    }

}