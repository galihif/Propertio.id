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
                DummyData.listProperty()
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
        TODO("Not yet implemented")
    }

    override fun getAllDeveloper(): Flow<Resource<List<Developer>>> {
        TODO("Not yet implemented")
    }

    override fun getDetailProperty(slug: String): Flow<Resource<Property>> {
        TODO("Not yet implemented")
    }

    override fun getDetailProject(slug: String): Flow<Resource<Project>> {
        TODO("Not yet implemented")
    }

    override fun getDetailAgent(agentId: Int): Flow<Resource<Agent>> {
        TODO("Not yet implemented")
    }

    override fun getDetailDeveloper(developerId: Int): Flow<Resource<Developer>> {
        TODO("Not yet implemented")
    }
}