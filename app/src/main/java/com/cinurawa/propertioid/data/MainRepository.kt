package com.cinurawa.propertioid.data

import com.cinurawa.propertioid.data.remote.api.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService
) {
    val tes = "tes"
}