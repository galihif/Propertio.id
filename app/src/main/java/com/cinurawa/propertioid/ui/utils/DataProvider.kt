package com.cinurawa.propertioid.ui.utils

import com.cinurawa.propertioid.utils.enum.ListingType
import com.cinurawa.propertioid.utils.enum.PropertyType

object DataProvider {
    val listPropertyType = PropertyType.values().map { it.value }
    val listListingType = ListingType.values().map { it.value }
}