package com.cinurawa.propertioid.data

import com.cinurawa.propertioid.data.model.Agent
import com.cinurawa.propertioid.data.model.Developer
import com.cinurawa.propertioid.data.model.Project
import com.cinurawa.propertioid.data.model.Property
import com.cinurawa.propertioid.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getAllProperty(): Flow<Resource<List<Property>>>
    fun getAllProject(): Flow<Resource<List<Project>>>
    fun getAllAgent(): Flow<Resource<List<Agent>>>
    fun getAllDeveloper(): Flow<Resource<List<Developer>>>

    fun getDetailProperty(slug: String): Flow<Resource<Property>>
    fun getDetailProject(slug: String): Flow<Resource<Project>>
    fun getDetailAgent(agentId:Int): Flow<Resource<Agent>>
    fun getDetailDeveloper(developerId:Int): Flow<Resource<Developer>>
}