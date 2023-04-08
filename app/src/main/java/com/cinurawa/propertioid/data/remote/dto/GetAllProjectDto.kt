package com.cinurawa.propertioid.data.remote.dto


import com.google.gson.annotations.SerializedName

data class GetAllProjectDto(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
) {
    data class Data(
        @SerializedName("address")
        val address: String?,
        @SerializedName("apps_link")
        val appsLink: String?,
        @SerializedName("certificate")
        val certificate: String,
        @SerializedName("city")
        val city: String,
        @SerializedName("completed_at")
        val completedAt: String?,
        @SerializedName("contact_project")
        val contactProject: List<ContactProject>,
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("deleted_at")
        val deletedAt: Any?,
        @SerializedName("description")
        val description: String?,
        @SerializedName("design")
        val design: String?,
        @SerializedName("developer_id")
        val developerId: Int,
        @SerializedName("district")
        val district: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("latitude")
        val latitude: Double,
        @SerializedName("listing_package_type")
        val listingPackageType: Any?,
        @SerializedName("longitude")
        val longitude: Double,
        @SerializedName("postal_code")
        val postalCode: String?,
        @SerializedName("price_final")
        val priceFinal: Int,
        @SerializedName("price_start")
        val priceStart: Int,
        @SerializedName("project_advantage")
        val projectAdvantage: List<Any>,
        @SerializedName("project_code")
        val projectCode: String,
        @SerializedName("project_document")
        val projectDocument: List<ProjectDocument>,
        @SerializedName("project_facility")
        val projectFacility: List<ProjectFacility>,
        @SerializedName("project_infrastructure")
        val projectInfrastructure: List<ProjectInfrastructure>,
        @SerializedName("project_photo")
        val projectPhoto: List<ProjectPhoto>,
        @SerializedName("project_video")
        val projectVideo: List<ProjectVideo>,
        @SerializedName("project_virtual_tour")
        val projectVirtualTour: List<ProjectVirtualTour>,
        @SerializedName("property_type")
        val propertyType: PropertyType,
        @SerializedName("property_type_id")
        val propertyTypeId: Int,
        @SerializedName("province")
        val province: String,
        @SerializedName("siteplan_link")
        val siteplanLink: String?,
        @SerializedName("slug")
        val slug: String,
        @SerializedName("status")
        val status: String,
        @SerializedName("subtitle")
        val subtitle: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("unit")
        val unit: List<Unit>,
        @SerializedName("updated_at")
        val updatedAt: String,
        @SerializedName("view_count")
        val viewCount: Int
    ) {
        data class ContactProject(
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("developer_id")
            val developerId: Int,
            @SerializedName("email")
            val email: Any?,
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("phone")
            val phone: String,
            @SerializedName("project_id")
            val projectId: Int,
            @SerializedName("type")
            val type: String,
            @SerializedName("updated_at")
            val updatedAt: String,
            @SerializedName("user_id")
            val userId: Int
        )

        data class ProjectDocument(
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("file")
            val `file`: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("project_id")
            val projectId: Int,
            @SerializedName("updated_at")
            val updatedAt: String
        )

        data class ProjectFacility(
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("facility_type")
            val facilityType: FacilityType,
            @SerializedName("facility_type_id")
            val facilityTypeId: Int,
            @SerializedName("id")
            val id: Int,
            @SerializedName("project_id")
            val projectId: Int,
            @SerializedName("updated_at")
            val updatedAt: String
        ) {
            data class FacilityType(
                @SerializedName("category")
                val category: String?,
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

        data class ProjectInfrastructure(
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("distance")
            val distance: Int,
            @SerializedName("id")
            val id: Int,
            @SerializedName("infrastructure_type")
            val infrastructureType: InfrastructureType,
            @SerializedName("infrastructure_type_id")
            val infrastructureTypeId: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("project_id")
            val projectId: Int,
            @SerializedName("updated_at")
            val updatedAt: String
        ) {
            data class InfrastructureType(
                @SerializedName("created_at")
                val createdAt: String,
                @SerializedName("deleted_at")
                val deletedAt: Any?,
                @SerializedName("description")
                val description: String?,
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

        data class ProjectPhoto(
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("file")
            val `file`: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("project_id")
            val projectId: Int,
            @SerializedName("updated_at")
            val updatedAt: String
        )

        data class ProjectVideo(
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("link")
            val link: String,
            @SerializedName("name")
            val name: String,
            @SerializedName("project_id")
            val projectId: Int,
            @SerializedName("updated_at")
            val updatedAt: String
        )

        data class ProjectVirtualTour(
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("file")
            val `file`: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("project_id")
            val projectId: Int,
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

        data class Unit(
            @SerializedName("bathroom")
            val bathroom: Int,
            @SerializedName("bedroom")
            val bedroom: Int,
            @SerializedName("building_area")
            val buildingArea: Int,
            @SerializedName("cartport")
            val cartport: Int?,
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("deleted_at")
            val deletedAt: Any?,
            @SerializedName("description")
            val description: String?,
            @SerializedName("floor")
            val floor: Int,
            @SerializedName("garage")
            val garage: Int,
            @SerializedName("id")
            val id: Int,
            @SerializedName("model_link")
            val modelLink: String?,
            @SerializedName("power_supply")
            val powerSupply: String,
            @SerializedName("price")
            val price: Int,
            @SerializedName("project_id")
            val projectId: Int,
            @SerializedName("property_type_id")
            val propertyTypeId: Int,
            @SerializedName("specification")
            val specification: String?,
            @SerializedName("surface_area")
            val surfaceArea: Int,
            @SerializedName("title")
            val title: String,
            @SerializedName("type")
            val type: String,
            @SerializedName("unit_code")
            val unitCode: String,
            @SerializedName("unit_photo")
            val unitPhoto: List<UnitPhoto>,
            @SerializedName("unit_video")
            val unitVideo: List<UnitVideo>,
            @SerializedName("unit_virtual_tour")
            val unitVirtualTour: List<UnitVirtualTour>,
            @SerializedName("updated_at")
            val updatedAt: String,
            @SerializedName("water_type")
            val waterType: String
        ) {
            data class UnitPhoto(
                @SerializedName("created_at")
                val createdAt: String,
                @SerializedName("file")
                val `file`: String,
                @SerializedName("id")
                val id: Int,
                @SerializedName("name")
                val name: String,
                @SerializedName("unit_id")
                val unitId: Int,
                @SerializedName("updated_at")
                val updatedAt: String
            )

            data class UnitVideo(
                @SerializedName("created_at")
                val createdAt: String,
                @SerializedName("id")
                val id: Int,
                @SerializedName("link")
                val link: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("unit_id")
                val unitId: Int,
                @SerializedName("updated_at")
                val updatedAt: String
            )

            data class UnitVirtualTour(
                @SerializedName("created_at")
                val createdAt: String,
                @SerializedName("file")
                val `file`: String,
                @SerializedName("id")
                val id: Int,
                @SerializedName("name")
                val name: String,
                @SerializedName("unit_id")
                val unitId: Int,
                @SerializedName("updated_at")
                val updatedAt: String
            )
        }
    }
}