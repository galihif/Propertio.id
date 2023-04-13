package com.cinurawa.propertioid.data.remote.dto


import com.google.gson.annotations.SerializedName

data class GetAllPropertyDto(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val propertyData: List<PropertyData>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
) {
    data class PropertyData(
        @SerializedName("address")
        val address: String,
        @SerializedName("agent_id")
        val agentId: Int,
        @SerializedName("bathroom")
        val bathroom: Int,
        @SerializedName("bedroom")
        val bedroom: Int,
        @SerializedName("building_area")
        val buildingArea: Int,
        @SerializedName("cartport")
        val cartport: Int,
        @SerializedName("certificate")
        val certificate: String,
        @SerializedName("city")
        val city: String,
        @SerializedName("condition")
        val condition: String,
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("district")
        val district: String,
        @SerializedName("floor")
        val floor: Int,
        @SerializedName("garage")
        val garage: Int,
        @SerializedName("id")
        val id: Int,
        @SerializedName("listing_package_type")
        val listingPackageType: Any?,
        @SerializedName("listing_type")
        val listingType: String,
        @SerializedName("postal_code")
        val postalCode: String,
        @SerializedName("price")
        val price: Int,
        @SerializedName("property_advantage")
        val propertyAdvantage: List<Any>,
        @SerializedName("property_code")
        val propertyCode: String,
        @SerializedName("property_photo")
        val propertyPhoto: List<PropertyPhoto>,
        @SerializedName("property_type")
        val propertyType: PropertyType,
        @SerializedName("property_type_id")
        val propertyTypeId: Int,
        @SerializedName("province")
        val province: String,
        @SerializedName("slug")
        val slug: String,
        @SerializedName("status")
        val status: String,
        @SerializedName("surface_area")
        val surfaceArea: Int,
        @SerializedName("title")
        val title: String,
        @SerializedName("water_type")
        val waterType: String,
        @SerializedName("year_built")
        val yearBuilt: Int
    ) {
        data class PropertyPhoto(
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("file")
            val `file`: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("property_id")
            val propertyId: Int,
            @SerializedName("updated_at")
            val updatedAt: String
        )

        data class PropertyType(
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("deleted_at")
            val deletedAt: Any?,
            @SerializedName("id")
            val id: Int,
            @SerializedName("image_icon")
            val imageIcon: String?,
            @SerializedName("name")
            val name: String,
            @SerializedName("updated_at")
            val updatedAt: String
        )
    }
}