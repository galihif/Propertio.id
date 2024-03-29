package com.cinurawa.propertioid.data

import com.cinurawa.propertioid.data.model.Agent
import com.cinurawa.propertioid.data.model.Developer
import com.cinurawa.propertioid.data.model.Project
import com.cinurawa.propertioid.data.model.Property
import com.cinurawa.propertioid.utils.DummyData
import com.cinurawa.propertioid.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class MockRepositoryImpl @Inject constructor() : MainRepository {
    override fun getAllProperty(): Flow<Resource<List<Property>>> {
        return flowOf(
            Resource.Success(
                DummyData.listProperty()
            )
        )
    }

    override fun getAllProperty(
        keyword: String,
        propertyType: String,
        listingType: String
    ): Flow<Resource<List<Property>>> {
        return flowOf(
            Resource.Success(
                DummyData.listProperty().filter { it.type == propertyType && it.name.contains(keyword) }
            )
        )
    }

    override fun getAllProject(): Flow<Resource<List<Project>>> {
        return flowOf(
            Resource.Success(
                DummyData.listProject()
            )
        )
    }

    override fun getAllProject(
        keyword: String,
        propertyType: String
    ): Flow<Resource<List<Project>>> {
        return flowOf(
            Resource.Success(
                DummyData.listProject()
            )
        )
    }

    override fun getAllAgent(): Flow<Resource<List<Agent>>> {
        return flowOf(
            Resource.Success(
                DummyData.listAgents()
            )
        )
    }

    override fun getAllDeveloper(): Flow<Resource<List<Developer>>> {
        return flowOf(
            Resource.Success(
                DummyData.listDevelopers()
            )
        )
    }

    override fun getDetailProperty(slug: String): Flow<Resource<Property>> {
        return flowOf(
            Resource.Success(
                DummyData.listProperty().find { it.slug == slug }?: DummyData.listProperty()[0]
            )
        )
    }

    override fun getDetailProject(slug: String): Flow<Resource<Project>> {
        return flowOf(
            Resource.Success(
                DummyData.listProject().find { it.slug == slug }?: DummyData.listProject()[0]
            )
        )
    }

    override fun getDetailAgent(agentId: Int): Flow<Resource<Agent>> {
        return flowOf(
            Resource.Success(
                DummyData.listAgents().find { it.id == agentId }?: DummyData.listAgents()[0]
            )
        )
    }

    override fun getDetailDeveloper(developerId: Int): Flow<Resource<Developer>> {
        return flowOf(
            Resource.Success(
                DummyData.listDevelopers().find { it.id == developerId }?: DummyData.listDevelopers()[0]
            )
        )
    }
}