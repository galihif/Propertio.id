package com.cinurawa.propertioid.utils

import com.cinurawa.propertioid.data.model.Agent
import com.cinurawa.propertioid.data.model.Developer
import com.cinurawa.propertioid.data.model.Dokumen
import com.cinurawa.propertioid.data.model.Infrastructure
import com.cinurawa.propertioid.data.model.Project
import com.cinurawa.propertioid.data.model.ProjectUnit
import com.cinurawa.propertioid.data.model.Property

object DummyData {
    fun listProperty(): List<Property> {
        val propertyList = mutableListOf<Property>()

        for (i in 1..3) {
            val property = Property(
                id = i,
                slug = "dummy-property-$i",
                name = "Dummy Property $i",
                desc = "This is a dummy property description.",
                address = "123 Dummy Street, Dummy City",
                price = 1000000 + i * 100000,
                photosUrl = listOf(
                    "https://images.unsplash.com/photo-1600585154340-be6161a56a0c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80",
                    "https://images.unsplash.com/photo-1600047509807-ba8f99d2cdde?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=692&q=80"
                ),
                type = "Rumah",
                listingType = "Sale",
                certificate = "SHM",
                floor = 2,
                surfaceArea = 200,
                buildingArea = 300,
                bedroom = 3,
                bathroom = 2,
                garage = 1,
                carport = 0
            )

            // Set properties that are not in the constructor
            property.propertyCode = "ABC$i"
            property.condition = "Good"
            property.facing = "North"
            property.yearBuilt = 2010
            property.maidBedroom = 1
            property.maidBathroom = 1
            property.powerSupply = "2200 Watt"
            property.waterType = "PAM"
            property.phoneLine = 1
            property.isFurniture = true
            property.virtualTour = "https://virtualtour0001.propertio.id/"
            property.video = "https://dummyproperty.com/video$i.mp4"
            property.latitude = -6.1754 + i * 0.01
            property.longitude = 106.8272 + i * 0.01
            property.dokumen = listOf(Dokumen("Document1", "https://dummyproperty.com/document1.pdf"), Dokumen("Document2", "https://dummyproperty.com/document2.pdf"))
            property.fasilitas = listOf("Swimming pool", "Gym", "Playground")
            property.infrastruktur = listOf(Infrastructure("School", 50, ""), Infrastructure("Hospital", 1000, ""))
            property.agentImage = "https://images.unsplash.com/photo-1560250097-0b93528c311a?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=387&q=80"
            property.agentName = "Dummy Agent"
            property.agentPhone = "123-456-7890"

            propertyList.add(property)
        }

        return propertyList
    }

    fun listProject(): List<Project> {
        val projectList = mutableListOf<Project>()

        for (i in 1..3) {
            val project = Project(
                id = i,
                slug = "dummy-project-$i",
                name = "Dummy Project $i",
                desc = "This is a dummy project description.",
                concept = "Dummy concept $i",
                address = "123 Dummy Street, Dummy City",
                startPrice = 1000000 + i * 100000,
                finalPrice = 2000000 + i * 100000,
                code = "ABC$i",
                photosUrl = listOf(
                    "https://images.unsplash.com/photo-1600585154340-be6161a56a0c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80",
                    "https://images.unsplash.com/photo-1600047509807-ba8f99d2cdde?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=692&q=80"
                ),
                type = "Apartment",
                certificate = "SHM"
            )

            // Set properties that are not in the constructor
            project.virtualTour = "https://dummyproject.com/virtual-tour$i.html"
            project.site3DPlan = "https://dummyproject.com/site-3d-plan$i.html"
            project.arApps = "https://dummyproject.com/ar-apps$i.html"
            project.video = "https://dummyproject.com/video$i.mp4"
            project.latitude = -6.1754 + i * 0.01
            project.longitude = 106.8272 + i * 0.01
            project.listUnit = listOf(
                ProjectUnit(
                    id = 1,
                    name = "Unit $i-1",
                    desc = "This is a dummy unit description.",
                    spec = "This is a dummy unit specification.",
                    price = 1000000 + i * 100000,
                    code = "ABC$i-1",
                    photosUrl = listOf(
                        "https://images.unsplash.com/photo-1600585154340-be6161a56a0c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80",
                        "https://images.unsplash.com/photo-1600047509807-ba8f99d2cdde?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=692&q=80"
                    ),
                    type = "Apartment",
                    floor = 2,
                    surfaceArea = 60,
                    buildingArea = 80,
                    bedroom = 2,
                    bathroom = 1,
                    garage = 0,
                    powerSupply = "2200 Watt",
                    waterType = "PAM",
                    virtualTour = "https://dummyunit.com/virtual-tour$i-1.html",
                    model3D = "https://dummyunit.com/model-3d$i-1.html",
                    video = "https://dummyunit.com/video$i-1.mp4"
                ),
            )
            project.dokumen = listOf(Dokumen("Document1", "https://dummyproject.com/document1.pdf"), Dokumen("Document2", "https://dummyproject.com/document2.pdf"))
            project.fasilitas = listOf("Swimming pool", "Gym", "Playground")
            project.infrastruktur = listOf(Infrastructure("School", 500), Infrastructure("Hospital", 1000))
            project.agentImage = "https://images.unsplash.com/photo-1560250097-0b93528c311a?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=387&q=80"
            project.agentName = "Dummy Agent"
            project.agentPhone = "123-456-7890"

            projectList.add(project)
        }

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
        agent1.propertyList = listProperty()
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
        agent2.propertyList = listProperty()
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
        developer1.projectList = listProject()
        developerList.add(developer1)

        // Dummy developer 2
        val developer2 = Developer(
            id = 2,
            name = "Global Real Estate",
            address = "1010 Maple St, Anytown, USA",
            imageUrl = "https://example.com/developer2/logo.png",
            projectCount = 8
        )
        developer2.projectList = listProject()
        developerList.add(developer2)

        return developerList
    }
}