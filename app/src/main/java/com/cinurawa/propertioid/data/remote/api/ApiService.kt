package com.cinurawa.propertioid.data.remote.api

import com.cinurawa.propertioid.data.remote.dto.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("mobile/get_all_property_active")
    suspend fun getAllProperty(): GetAllPropertyDto

    @GET("mobile/get_all_property_active")
    suspend fun getAllProperty(
        @Query("title") title: String,
        @Query("property_type_id") proTypeId: Int,
        @Query("listing_type") listingType: String,
    ): GetAllPropertyDto

    @GET("mobile/get_all_project_active")
    suspend fun getAllProject(): GetAllProjectDto

    @GET("mobile/get_all_project_active")
    suspend fun getAllProject(
        @Query("title") title: String,
        @Query("property_type_id") proTypeId: Int,
    ): GetAllProjectDto

    @GET("mobile/get_all_agent")
    suspend fun getAllAgent(): GetAllAgentDto

    @GET("mobile/get_all_developer")
    suspend fun getAllDeveloper(): GetAllDeveloperDto

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

    @GET("mobile/get_detail_developer/{id}")
    suspend fun getDetailDeveloper(
        @Path("id") id: Int
    ): GetDetailDeveloperDto

}