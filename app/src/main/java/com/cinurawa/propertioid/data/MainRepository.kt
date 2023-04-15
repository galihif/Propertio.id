package com.cinurawa.propertioid.data

import android.util.Log
import com.cinurawa.propertioid.data.model.Agent
import com.cinurawa.propertioid.data.model.Project
import com.cinurawa.propertioid.data.model.Property
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

    fun getAllProject(): Flow<Resource<List<Project>>> =
        flow{
            emit(Resource.Loading())
            try {
                val response = apiService.getAllProject()
                emit(Resource.Success(response.data.map { it.toModel() }))
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

    fun getAllAgent(): Flow<Resource<List<Agent>>> =
        flow{
            emit(Resource.Loading())
            try {
                val response = apiService.getAllAgent()
                emit(Resource.Success(response.data.map { it.toModel() }))
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

    fun getDetailProperty(slug: String): Flow<Resource<Property>> =
        flow{
            emit(Resource.Loading())
            try {
                val response = apiService.getDetailProperty(slug)
                emit(Resource.Success(response.data.toModel()))
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

    fun getDetailProject(slug: String):Flow<Resource<Project>> =
        flow {
            emit(Resource.Loading())
            try {
                val response = apiService.getDetailProject(slug)
                emit(Resource.Success(response.data.toModel()))
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

    fun getDetailAgent(agentId: Int): Flow<Resource<Agent>> =
        flow{
            emit(Resource.Loading())
            try {
                val response = apiService.getDetailAgent(agentId)
                emit(Resource.Success(response.data.toModel()))
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