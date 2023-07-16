package com.cinurawa.propertioid.data

import android.util.Log
import com.cinurawa.propertioid.data.model.Agent
import com.cinurawa.propertioid.data.model.Developer
import com.cinurawa.propertioid.data.model.Project
import com.cinurawa.propertioid.data.model.Property
import com.cinurawa.propertioid.data.remote.api.ApiService
import com.cinurawa.propertioid.utils.Resource
import com.cinurawa.propertioid.utils.enum.PropertyType
import com.cinurawa.propertioid.utils.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MainRepository {

    override fun getAllProperty(): Flow<Resource<List<Property>>> =
        flow {
            emit(Resource.Loading())
            try {
                val response = apiService.getAllProperty()
                emit(Resource.Success(response.propertyData.map { it.toModel() }))
            } catch (e: HttpException) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH", "HttpException: ${e.message}")
            } catch (e: IOException) {
                if (e.message?.contains("Unable to resolve host") == true) {
                    emit(Resource.Error("Please check your internet connection."))
                } else {
                    emit(Resource.Error(e.message ?: "Error"))
                }
                Log.d("GALIH", "IOException: ${e.message}")
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH", "Exception: ${e.message}")
            }
        }

    override fun getAllProperty(
        keyword: String,
        propertyType: String,
        listingType: String,
    ): Flow<Resource<List<Property>>> =
        flow {
            emit(Resource.Loading())
            try {
                val response = apiService.getAllProperty(
                    title = keyword,
                    proTypeId = PropertyType.fromValue(propertyType)?.id ?: 0,
                    listingType = listingType
                )
                emit(Resource.Success(response.propertyData.map { it.toModel() }))
            } catch (e: HttpException) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH", "HttpException: ${e.message}")
            } catch (e: IOException) {
                if (e.message?.contains("Unable to resolve host") == true) {
                    emit(Resource.Error("Please check your internet connection."))
                } else {
                    emit(Resource.Error(e.message ?: "Error"))
                }
                Log.d("GALIH", "IOException: ${e.message}")
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH", "Exception: ${e.message}")
            }
        }

    override fun getAllProject(): Flow<Resource<List<Project>>> =
        flow {
            emit(Resource.Loading())
            try {
                val response = apiService.getAllProject()
                emit(Resource.Success(response.data.map { it.toModel() }))
            } catch (e: HttpException) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH", "HttpException: ${e.message}")
            } catch (e: IOException) {
                if (e.message?.contains("Unable to resolve host") == true) {
                    emit(Resource.Error("Please check your internet connection."))
                } else {
                    emit(Resource.Error(e.message ?: "Error"))
                }
                Log.d("GALIH", "IOException: ${e.message}")
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH", "Exception: ${e.message}")
            }
        }

    override fun getAllProject(
        keyword: String,
        propertyType: String
    ): Flow<Resource<List<Project>>> =
        flow {
            emit(Resource.Loading())
            try {
                val response = apiService.getAllProject(
                    title = keyword,
                    proTypeId = PropertyType.fromValue(propertyType)?.id ?: 0
                )
                emit(Resource.Success(response.data.map { it.toModel() }))
            } catch (e: HttpException) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH", "HttpException: ${e.message}")
            } catch (e: IOException) {
                if (e.message?.contains("Unable to resolve host") == true) {
                    emit(Resource.Error("Please check your internet connection."))
                } else {
                    emit(Resource.Error(e.message ?: "Error"))
                }
                Log.d("GALIH", "IOException: ${e.message}")
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH", "Exception: ${e.message}")
            }
        }

    override fun getAllAgent(): Flow<Resource<List<Agent>>> =
        flow {
            emit(Resource.Loading())
            try {
                val response = apiService.getAllAgent()
                emit(Resource.Success(response.data.map { it.toModel() }))
            } catch (e: HttpException) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH", "HttpException: ${e.message}")
            } catch (e: IOException) {
                if (e.message?.contains("Unable to resolve host") == true) {
                    emit(Resource.Error("Please check your internet connection."))
                } else {
                    emit(Resource.Error(e.message ?: "Error"))
                }
                Log.d("GALIH", "IOException: ${e.message}")
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH", "Exception: ${e.message}")
            }
        }

    override fun getAllDeveloper(): Flow<Resource<List<Developer>>> =
        flow {
            emit(Resource.Loading())
            try {
                val response = apiService.getAllDeveloper()
                emit(Resource.Success(response.data.map { it.toModel() }))
            } catch (e: HttpException) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH", "HttpException: ${e.message}")
            } catch (e: IOException) {
                if (e.message?.contains("Unable to resolve host") == true) {
                    emit(Resource.Error("Please check your internet connection."))
                } else {
                    emit(Resource.Error(e.message ?: "Error"))
                }
                Log.d("GALIH", "IOException: ${e.message}")
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH", "Exception: ${e.message}")
            }
        }

    override fun getDetailProperty(slug: String): Flow<Resource<Property>> =
        flow {
            emit(Resource.Loading())
            try {
                val response = apiService.getDetailProperty(slug)
                emit(Resource.Success(response.data.toModel()))
            } catch (e: HttpException) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH", "HttpException: ${e.message}")
            } catch (e: IOException) {
                if (e.message?.contains("Unable to resolve host") == true) {
                    emit(Resource.Error("Please check your internet connection."))
                } else {
                    emit(Resource.Error(e.message ?: "Error"))
                }
                Log.d("GALIH", "IOException: ${e.message}")
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH", "Exception: ${e.message}")
            }
        }

    override fun getDetailProject(slug: String): Flow<Resource<Project>> =
        flow {
            emit(Resource.Loading())
            try {
                val response = apiService.getDetailProject(slug)
                emit(Resource.Success(response.data.toModel()))
            } catch (e: HttpException) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH", "HttpException: ${e.message}")
            } catch (e: IOException) {
                if (e.message?.contains("Unable to resolve host") == true) {
                    emit(Resource.Error("Please check your internet connection."))
                } else {
                    emit(Resource.Error(e.message ?: "Error"))
                }
                Log.d("GALIH", "IOException: ${e.message}")
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH", "Exception: ${e.message}")
            }
        }

    override fun getDetailAgent(agentId: Int): Flow<Resource<Agent>> =
        flow {
            emit(Resource.Loading())
            try {
                val response = apiService.getDetailAgent(agentId)
                emit(Resource.Success(response.data.toModel()))
            } catch (e: HttpException) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH", "HttpException: ${e.message}")
            } catch (e: IOException) {
                if (e.message?.contains("Unable to resolve host") == true) {
                    emit(Resource.Error("Please check your internet connection."))
                } else {
                    emit(Resource.Error(e.message ?: "Error"))
                }
                Log.d("GALIH", "IOException: ${e.message}")
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH", "Exception: ${e.message}")
            }
        }

    override fun getDetailDeveloper(developerId: Int): Flow<Resource<Developer>> =
        flow {
            emit(Resource.Loading())
            try {
                val response = apiService.getDetailDeveloper(developerId)
                emit(Resource.Success(response.data.toModel()))
            } catch (e: HttpException) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH HttpException", "HttpException: ${e.message}")
            } catch (e: IOException) {
                if (e.message?.contains("Unable to resolve host") == true) {
                    emit(Resource.Error("Please check your internet connection."))
                } else {
                    emit(Resource.Error(e.message ?: "Error"))
                }
                Log.d("GALIH", "IOException: ${e.message}")
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Error"))
                Log.d("GALIH Exception", "Exception: ${e.message}")
            }
        }
}