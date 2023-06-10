package com.cinurawa.propertioid.ui.utils

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bathtub
import androidx.compose.material.icons.filled.Blind
import androidx.compose.material.icons.filled.Deck
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.EscalatorWarning
import androidx.compose.material.icons.filled.Fence
import androidx.compose.material.icons.filled.Fireplace
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.GolfCourse
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.HeadsetMic
import androidx.compose.material.icons.filled.HeatPump
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Living
import androidx.compose.material.icons.filled.LocalParking
import androidx.compose.material.icons.filled.MicExternalOn
import androidx.compose.material.icons.filled.OutdoorGrill
import androidx.compose.material.icons.filled.Pool
import androidx.compose.material.icons.filled.Roofing
import androidx.compose.material.icons.filled.SettingsAccessibility
import androidx.compose.material.icons.filled.SolarPower
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.icons.filled.SportsBaseball
import androidx.compose.material.icons.filled.SportsBasketball
import androidx.compose.material.icons.filled.SportsGolf
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material.icons.filled.SportsTennis
import androidx.compose.material.icons.filled.Store
import androidx.compose.material.icons.rounded.AccountBalance
import androidx.compose.material.icons.rounded.AirplanemodeActive
import androidx.compose.material.icons.rounded.BeachAccess
import androidx.compose.material.icons.rounded.BusinessCenter
import androidx.compose.material.icons.rounded.Church
import androidx.compose.material.icons.rounded.DirectionsBus
import androidx.compose.material.icons.rounded.DirectionsRailway
import androidx.compose.material.icons.rounded.Dock
import androidx.compose.material.icons.rounded.FitnessCenter
import androidx.compose.material.icons.rounded.GolfCourse
import androidx.compose.material.icons.rounded.LocalAtm
import androidx.compose.material.icons.rounded.LocalGasStation
import androidx.compose.material.icons.rounded.LocalHospital
import androidx.compose.material.icons.rounded.LocalLibrary
import androidx.compose.material.icons.rounded.LocationCity
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Museum
import androidx.compose.material.icons.rounded.Nightlife
import androidx.compose.material.icons.rounded.Park
import androidx.compose.material.icons.rounded.Policy
import androidx.compose.material.icons.rounded.Restaurant
import androidx.compose.material.icons.rounded.School
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.SportsBasketball
import androidx.compose.material.icons.rounded.SportsSoccer
import androidx.compose.material.icons.rounded.Toll
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.vector.ImageVector
import java.util.Locale

fun Modifier.shimmerBackground(shape: Shape = RectangleShape): Modifier = composed {
    val transition = rememberInfiniteTransition()
    val translateAnimation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 400f,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 1500, easing = LinearOutSlowInEasing),
            RepeatMode.Restart
        ),
    )
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.9f),
        Color.LightGray.copy(alpha = 0.4f),
    )
    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(translateAnimation, translateAnimation),
        end = Offset(translateAnimation + 100f, translateAnimation + 100f),
        tileMode = TileMode.Mirror,
    )
    return@composed this.then(background(brush, shape))
}

fun String.getFacilityIcon():ImageVector{
    return when (this) {
        "AC" -> Icons.Default.HeatPump
        "Pemanas Air" -> Icons.Default.HeatPump
        "Solar Panel" -> Icons.Default.SolarPower
        "Jacuzzi" -> Icons.Default.Bathtub
        "Kolam Renang" -> Icons.Default.Pool
        "Interkom" -> Icons.Default.HeadsetMic
        "Kompor Gas" -> Icons.Default.Fireplace
        "Gazebo" -> Icons.Default.Deck
        "Lapangan Basket" -> Icons.Default.SportsBasketball
        "Lapangan Sepak Bola" -> Icons.Default.SportsSoccer
        "Tempat Bowling" -> Icons.Default.SportsSoccer
        "Tempat Latihan Golf" -> Icons.Default.SportsGolf
        "Ruang Acara", "Ruang Rapat", "Ruang Serbaguna" -> Icons.Default.Groups
        "Spa" -> Icons.Default.Spa
        "Lapangan Batminton" -> Icons.Default.SportsTennis
        "Tempat BBQ" -> Icons.Default.OutdoorGrill
        "Pusat Kebugaran" -> Icons.Default.FitnessCenter
        "Area Bermain" -> Icons.Default.EscalatorWarning
        "Trek Lari" -> Icons.Default.DirectionsRun
        "Mini Golf" -> Icons.Default.GolfCourse
        "Tempat Parkir Terbuka","Parkir Basement" -> Icons.Default.LocalParking
        "Jalur Refleksiologi" -> Icons.Default.SettingsAccessibility
        "Fasilitas Disabilitas" -> Icons.Default.Blind
        "Lapangan Tennis" -> Icons.Default.SportsTennis
        "Lapangan Squash" -> Icons.Default.FitnessCenter
        "Paviliun" -> Icons.Default.Home
        "Kolam Aerobik" -> Icons.Default.Pool
        "Bilyar" -> Icons.Default.SportsBaseball
        "Kolam Bermain" -> Icons.Default.Pool
        "Karoke" -> Icons.Default.MicExternalOn
        "Minimarket" -> Icons.Default.Store
        "Sauna" -> Icons.Default.Spa
        "Ruang Santai Di Atap" -> Icons.Default.Roofing
        "One Gate" -> Icons.Default.Fence
        "Rooftop" -> Icons.Default.Roofing
        "Smart Home" -> Icons.Default.Living
        else -> Icons.Default.Home
    }
}

fun String.getInfraIcon():ImageVector{
    return when (this.lowercase(Locale.ROOT)) {
        "mall" -> Icons.Rounded.ShoppingCart
        "tempat hiburan" -> Icons.Rounded.Nightlife
        "pom bensin" -> Icons.Rounded.LocalGasStation
        "taman" -> Icons.Rounded.Park
        "rumah sakit" -> Icons.Rounded.LocalHospital
        "sekolah" -> Icons.Rounded.School
        "bandara" -> Icons.Rounded.AirplanemodeActive
        "stasiun" -> Icons.Rounded.DirectionsRailway
        "pelabuhan" -> Icons.Rounded.Dock
        "terminal" -> Icons.Rounded.DirectionsBus
        "atm" -> Icons.Rounded.LocalAtm
        "bank" -> Icons.Rounded.AccountBalance
        "masjid" -> Icons.Rounded.Museum
        "gereja" -> Icons.Rounded.Church
        "vihara" -> Icons.Rounded.Policy
        "klenteng" -> Icons.Rounded.Policy
        "pura" -> Icons.Rounded.Policy
        "pusat kebugaran" -> Icons.Rounded.FitnessCenter
        "perpustakaan" -> Icons.Rounded.LocalLibrary
        "perkantoran" -> Icons.Rounded.BusinessCenter
        "alun-alun" -> Icons.Rounded.LocationCity
        "pantai" -> Icons.Rounded.BeachAccess
        "pusat olahraga" -> Icons.Rounded.SportsBasketball
        "gor" -> Icons.Rounded.SportsBasketball
        "stadion" -> Icons.Rounded.SportsSoccer
        "pusat kesenian" -> Icons.Rounded.Museum
        "lapangan golf" -> Icons.Rounded.GolfCourse
        "gerbang tol" -> Icons.Rounded.Toll
        "restoran" -> Icons.Rounded.Restaurant
        else -> Icons.Rounded.LocationOn
    }
}