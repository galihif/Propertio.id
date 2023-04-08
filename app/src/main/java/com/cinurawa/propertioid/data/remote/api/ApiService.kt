package com.cinurawa.propertioid.data.remote.api

import com.cinurawa.propertioid.data.remote.dto.GetAllProjectDto
import com.cinurawa.propertioid.data.remote.dto.GetAllPropertyDto
import retrofit2.http.GET

interface ApiService {
    @GET("mobile/get_all_property_active")
    suspend fun getAllProperty():GetAllPropertyDto

    @GET("mobile/get_all_project_active")
    suspend fun getAllProject(): GetAllProjectDto


}