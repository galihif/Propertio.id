package com.cinurawa.propertioid.data

import com.cinurawa.propertioid.data.remote.api.ApiService
import com.cinurawa.propertioid.data.remote.dto.GetAllPropertyDto
import com.cinurawa.propertioid.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService
) {

    fun getAllProperty() =
        flow<Resource<List<GetAllPropertyDto.PropertyData>>>{
            emit(Resource.Loading())
            try {
                val response = apiService.getAllProperty()
                emit(Resource.Success(response.data))
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Error"))
            }
        }
}