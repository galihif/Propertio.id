package com.cinurawa.propertioid.utils.enum

enum class PropertyType( val id:Int,val value:String) {
    RUMAH(1, "Rumah"),
    APARTEMEN(2, "Apartemen"),
    KONDOMINIUM(3, "Kondominium"),
    TANAH(4, "Tanah"),
    VILLA(5, "Villa"),
    RUKO(6, "Ruko"),
    PERKANTORAN(7, "Perkantoran"),
    PABRIK(8, "Pabrik"),
    GUDANG(9, "Gudang"),
    RUANG_USAHA(10, "Ruang usaha"),
    KOSAN(11, "Kosan"),
    RUMAH_KUNO(13, "Rumah Kuno");
    companion object {
        fun fromValue(value: String): PropertyType? {
            return values().find { it.value == value }
        }
        fun fromId(id: Int): PropertyType? {
            return values().find { it.id == id }
        }
    }
}