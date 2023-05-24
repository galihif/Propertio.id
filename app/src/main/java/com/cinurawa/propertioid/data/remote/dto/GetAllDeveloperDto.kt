package com.cinurawa.propertioid.data.remote.dto


import com.google.gson.annotations.SerializedName

data class GetAllDeveloperDto(
    @SerializedName("data")
    val `data`: List<Data>,
) {
    data class Data(
        @SerializedName("description")
        val description: Any?,
        @SerializedName("developer_projects")
        val developerProjects: List<GetAllProjectDto.Data>,
        @SerializedName("id")
        val id: Int,
        @SerializedName("user")
        val user: User,
        @SerializedName("user_datas")
        val userDatas: UserDatas,
        @SerializedName("user_id")
        val userId: Int,
        @SerializedName("website")
        val website: Any?
    ) {
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
            val address: Any?,
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
            val imageCover: String?,
            @SerializedName("laravel_through_key")
            val laravelThroughKey: Int,
            @SerializedName("phone")
            val phone: String,
            @SerializedName("picture_profile")
            val pictureProfile: String?,
            @SerializedName("province")
            val province: String,
            @SerializedName("updated_at")
            val updatedAt: String,
            @SerializedName("user_id")
            val userId: Int
        )
    }
}