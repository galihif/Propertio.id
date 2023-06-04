package com.cinurawa.propertioid.data.remote.dto


import com.google.gson.annotations.SerializedName

data class GetDetailAgentDto(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
) {
    data class Data(
        @SerializedName("agent_properties")
        val agentProperties: List<AgentProperty>,
        @SerializedName("agent_type_id")
        val agentTypeId: Any?,
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("deleted_at")
        val deletedAt: Any?,
        @SerializedName("description")
        val description: String?,
        @SerializedName("expired_at")
        val expiredAt: Any?,
        @SerializedName("id")
        val id: Int,
        @SerializedName("updated_at")
        val updatedAt: String,
        @SerializedName("user")
        val user: User,
        @SerializedName("user_datas")
        val userDatas: UserDatas,
        @SerializedName("user_id")
        val userId: Int,
        @SerializedName("website")
        val website: Any?
    ) {
        data class AgentProperty(
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
            val cartport: Int?,
            @SerializedName("certificate")
            val certificate: String,
            @SerializedName("city")
            val city: String,
            @SerializedName("condition")
            val condition: String,
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("description")
            val description: String?,
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
            val maidBathroom: Int?,
            @SerializedName("maid_bedroom")
            val maidBedroom: Int?,
            @SerializedName("phone_line")
            val phoneLine: Int?,
            @SerializedName("postal_code")
            val postalCode: String,
            @SerializedName("power_supply")
            val powerSupply: String,
            @SerializedName("price")
            val price: Int,
            @SerializedName("property_code")
            val propertyCode: String,
            @SerializedName("property_photo")
            val propertyPhoto: List<PropertyPhoto>,
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
            @SerializedName("updated_at")
            val updatedAt: String,
            @SerializedName("view_count")
            val viewCount: Int,
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
        }

        data class User(
            @SerializedName("account_id")
            val accountId: String,
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("deleted_at")
            val deletedAt: Any?,
            @SerializedName("email")
            val email: String,
            @SerializedName("email_verified_at")
            val emailVerifiedAt: Any?,
            @SerializedName("id")
            val id: Int,
            @SerializedName("role")
            val role: String,
            @SerializedName("status")
            val status: String,
            @SerializedName("updated_at")
            val updatedAt: String
        )

        data class UserDatas(
            @SerializedName("address")
            val address: String,
            @SerializedName("city")
            val city: String,
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("deleted_at")
            val deletedAt: Any?,
            @SerializedName("fullname")
            val fullname: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("image_cover")
            val imageCover: String,
            @SerializedName("laravel_through_key")
            val laravelThroughKey: Int,
            @SerializedName("phone")
            val phone: String,
            @SerializedName("picture_profile")
            val pictureProfile: String,
            @SerializedName("province")
            val province: String,
            @SerializedName("updated_at")
            val updatedAt: String,
            @SerializedName("user_id")
            val userId: Int
        )
    }
}