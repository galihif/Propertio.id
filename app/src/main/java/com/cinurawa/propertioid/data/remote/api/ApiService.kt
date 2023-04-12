package com.cinurawa.propertioid.data.remote.api

import com.cinurawa.propertioid.data.remote.dto.GetAllAgentDto
import com.cinurawa.propertioid.data.remote.dto.GetAllProjectDto
import com.cinurawa.propertioid.data.remote.dto.GetAllPropertyDto
import com.cinurawa.propertioid.data.remote.dto.GetDetailAgentDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("mobile/get_all_property_active")
    suspend fun getAllProperty(): GetAllPropertyDto

    @GET("mobile/get_all_project_active")
    suspend fun getAllProject(): GetAllProjectDto

    @GET("mobile/get_all_agent")
    suspend fun getAllAgent(): GetAllAgentDto

    @GET("mobile/get_detail_agent/{agentId}")
    suspend fun getDetailAgent(
        @Path("agentId") agentId: Int
    ): GetDetailAgentDto


}