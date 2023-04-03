package com.cinurawa.propertioid.data

import Property
import android.util.Log
import com.cinurawa.propertioid.data.remote.api.ApiService
import com.cinurawa.propertioid.utils.Resource
import com.cinurawa.propertioid.utils.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService
) {

    fun getAllProperty(): Flow<Resource<List<Property>>> =
        flow{
            emit(Resource.Loading())
            try {
                val response = apiService.getAllProperty()
                emit(Resource.Success(response.propertyData.map { it.toModel() }))
            } catch (e: HttpException) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH", "HttpException: ${e.message}")
            }catch (e: IOException) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH", "IOException: ${e.message}")
            }catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH", "Exception: ${e.message}")
            }
        }
}