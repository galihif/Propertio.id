package com.cinurawa.propertioid.utils

import com.cinurawa.propertioid.data.model.Agent
import com.cinurawa.propertioid.data.model.Developer
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


        return projectList
    }

    fun listAgents(): List<Agent> {
        val agentList = mutableListOf<Agent>()

        // Dummy agent 1
        val agent1 = Agent(
            id = 1,
            name = "John Doe",
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam vitae lectus eget eros ultrices sodales.",
            address = "123 Main St, Anytown, USA",
            photoUrl = "https://i.pravatar.cc/150?img=1",
            propertyCount = 10,
            propertySold = 5,
            propertyRented = 2,
            phone = "+1 555-555-5555"
        )
        agentList.add(agent1)

        // Dummy agent 2
        val agent2 = Agent(
            id = 2,
            name = "Jane Smith",
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam vitae lectus eget eros ultrices sodales.",
            address = "456 Oak St, Anytown, USA",
            photoUrl = "https://i.pravatar.cc/150?img=2",
            propertyCount = 15,
            propertySold = 8,
            propertyRented = 3,
            phone = "+1 555-555-5555"
        )
        agentList.add(agent2)

        return agentList
    }

    fun listDevelopers(): List<Developer> {
        val developerList = mutableListOf<Developer>()

        // Dummy developer 1
        val developer1 = Developer(
            id = 1,
            name = "Acme Developers",
            address = "789 Elm St, Anytown, USA",
            imageUrl = "https://example.com/developer1/logo.png",
            projectCount = 5
        )
        developerList.add(developer1)

        // Dummy developer 2
        val developer2 = Developer(
            id = 2,
            name = "Global Real Estate",
            address = "1010 Maple St, Anytown, USA",
            imageUrl = "https://example.com/developer2/logo.png",
            projectCount = 8
        )
        developerList.add(developer2)

        return developerList
    }

}