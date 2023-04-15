package com.cinurawa.propertioid.data.remote.api

import com.cinurawa.propertioid.data.remote.dto.*
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("mobile/get_all_property_active")
    suspend fun getAllProperty(): GetAllPropertyDto

    @GET("mobile/get_all_project_active")
    suspend fun getAllProject(): GetAllProjectDto

    @GET("mobile/get_all_agent")
    suspend fun getAllAgent(): GetAllAgentDto

    @GET("mobile/get_detail_property/{slug}")
    suspend fun getDetailProperty(
        @Path("slug") slug: String
    ): GetDetailPropertyDto

    @GET("mobile/get_detail_project/{slug}")
    suspend fun getDetailProject(
        @Path("slug") slug: String
    ): GetDetailProjectDto

    @GET("mobile/get_detail_agent/{agentId}")
    suspend fun getDetailAgent(
        @Path("agentId") agentId: Int
    ): GetDetailAgentDto


}