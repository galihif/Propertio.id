package com.cinurawa.propertioid.data.remote.dto


import com.google.gson.annotations.SerializedName

data class GetAllPropertyDto(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: List<PropertyData>,
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
        @SerializedName("contact_property")
        val contactProperty: List<ContactProperty>,
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("district")
        val district: String,
        @SerializedName("facing")
        val facing: String,
        @SerializedName("floor")
        val floor: Int,
        @SerializedName("garage")
        val garage: Int,
        @SerializedName("id")
        val id: Int,
        @SerializedName("is_furniture")
        val isFurniture: Int,
        @SerializedName("latitude")
        val latitude: Double,
        @SerializedName("listing_package_type")
        val listingPackageType: Any?,
        @SerializedName("listing_type")
        val listingType: String,
        @SerializedName("longitude")
        val longitude: Double,
        @SerializedName("maid_bathroom")
        val maidBathroom: Int,
        @SerializedName("maid_bedroom")
        val maidBedroom: Int,
        @SerializedName("phone_line")
        val phoneLine: Int,
        @SerializedName("postal_code")
        val postalCode: String,
        @SerializedName("power_supply")
        val powerSupply: String,
        @SerializedName("price")
        val price: Int,
        @SerializedName("property_advantage")
        val propertyAdvantage: List<Any>,
        @SerializedName("property_code")
        val propertyCode: String,
        @SerializedName("property_document")
        val propertyDocument: List<Any>,
        @SerializedName("property_facility")
        val propertyFacility: List<PropertyFacility>,
        @SerializedName("property_infrastructure")
        val propertyInfrastructure: List<Any>,
        @SerializedName("property_photo")
        val propertyPhoto: List<PropertyPhoto>,
        @SerializedName("property_type")
        val propertyType: PropertyType,
        @SerializedName("property_type_id")
        val propertyTypeId: Int,
        @SerializedName("property_video")
        val propertyVideo: List<PropertyVideo>,
        @SerializedName("property_virtual_tour")
        val propertyVirtualTour: List<Any>,
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
        @SerializedName("updated_at")
        val updatedAt: String,
        @SerializedName("view_count")
        val viewCount: Int,
        @SerializedName("water_type")
        val waterType: String,
        @SerializedName("year_built")
        val yearBuilt: Int
    ) {
        data class ContactProperty(
            @SerializedName("agent_id")
            val agentId: Int,
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("email")
            val email: String?,
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("phone")
            val phone: String,
            @SerializedName("property_id")
            val propertyId: Int,
            @SerializedName("type")
            val type: String,
            @SerializedName("updated_at")
            val updatedAt: String,
            @SerializedName("user_id")
            val userId: Int
        )

        data class PropertyFacility(
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("facility_type")
            val facilityType: FacilityType,
            @SerializedName("facility_type_id")
            val facilityTypeId: Int,
            @SerializedName("id")
            val id: Int,
            @SerializedName("property_id")
            val propertyId: Int,
            @SerializedName("updated_at")
            val updatedAt: String
        ) {
            data class FacilityType(
                @SerializedName("category")
                val category: String,
                @SerializedName("created_at")
                val createdAt: String,
                @SerializedName("deleted_at")
                val deletedAt: Any?,
                @SerializedName("id")
                val id: Int,
                @SerializedName("image_icon")
                val imageIcon: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("updated_at")
                val updatedAt: String
            )
        }

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

        data class PropertyVideo(
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("link")
            val link: String,
            @SerializedName("name")
            val name: String,
            @SerializedName("property_id")
            val propertyId: Int,
            @SerializedName("updated_at")
            val updatedAt: String
        )
    }
}