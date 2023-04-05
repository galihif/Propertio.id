package com.cinurawa.propertioid.ui.pages.detail_properti

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.data.model.Property
import com.cinurawa.propertioid.ui.atoms.DokumenButton
import com.cinurawa.propertioid.ui.atoms.PrimaryButton
import com.cinurawa.propertioid.ui.atoms.PropertyAttributeText
import com.cinurawa.propertioid.ui.molecules.HargaShare
import com.cinurawa.propertioid.ui.molecules.IconText
import com.cinurawa.propertioid.ui.molecules.IconTextBadge
import com.cinurawa.propertioid.ui.molecules.IconTextCardColumn
import com.cinurawa.propertioid.ui.organisms.AgentContactRow
import com.cinurawa.propertioid.ui.organisms.ImageCarousel
import com.cinurawa.propertioid.ui.organisms.VideoPlayer
import com.cinurawa.propertioid.ui.theme.Blue500
import com.cinurawa.propertioid.ui.theme.Purple500
import com.cinurawa.propertioid.ui.theme.Red500
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun DetailPropertiScreen(
    data: Property? = null,
    onVirtualTourClick: (Int) -> Unit = {},
    viewModel: DetailPropertiViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    var lifecycle by remember {
        mutableStateOf(Lifecycle.Event.ON_CREATE)
    }
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event -> lifecycle = event }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    viewModel.addVideoUri("https://www.youtube.com/watch?v=YfkL3Qmxu6k", context)
    viewModel.addLatLong(data?.latitude?:0.0, data?.longitude?:0.0)

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            ImageCarousel(
                modifier = Modifier
                    .fillMaxWidth()
            )
        } // Image Carousel
        item {
            Row(
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                IconTextBadge(text = data?.type ?: "Rumah", icon = R.drawable.ic_house, color = Blue500)
                IconTextBadge(text = data?.listingType ?: "Jual", icon = R.drawable.ic_sell, color = Red500)
                IconTextBadge(text = data?.certificate ?: "SHM", icon = R.drawable.ic_shm, color = Purple500)
            }
        } // Label
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = data?.name ?: "Old House", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                IconTextBadge(text = "Properti Kode : ${data?.propertyCode}", leadingIcon = null)
            }
        } // Judul
        item {
            Text(
                text = data?.desc ?: "Description",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        } // Deskripsi Singkat
        item {
            IconText(
                modifier = Modifier.padding(horizontal = 24.dp),
                leadingIcon = Icons.Default.LocationOn,
                text = data?.address ?: "Address",
                iconTint = Red500
            )
        } // Lokasi
        item {
            HargaShare(harga = 50000000, modifier = Modifier.padding(horizontal = 24.dp))
        } // Harga Share
        item {
            Text(
                text = "Deskripsi",
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Text(
                text = data?.desc ?: "Description",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        } // Deskripsi
        item {
            Card(
                modifier = Modifier
                    .padding(24.dp),
                shape = RoundedCornerShape(10.dp),
                elevation = 0.dp,
                backgroundColor = Color.Gray.copy(alpha = 0.1f),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.Start,
                ) {
                    PropertyAttributeText(attribute = "Kondisi", value = data?.condition ?: "Condition")
                    PropertyAttributeText(attribute = "Hadap", value = data?.facing ?: "Facing")
                    PropertyAttributeText(attribute = "Berdiri", value = data?.yearBuilt.toString())
                }
            }
        } // Property Attribute
        item {
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                mainAxisSpacing = 14.dp,
                crossAxisSpacing = 14.dp,
                mainAxisAlignment = MainAxisAlignment.SpaceBetween,
                crossAxisAlignment = FlowCrossAxisAlignment.Start,
            ) {
                IconTextCardColumn(text = "${data?.floor} lantai", leadingIcon = Icons.Default.Stairs)
                IconTextCardColumn(text = "${data?.surfaceArea} m2", leadingIcon = Icons.Default.AspectRatio)
                IconTextCardColumn(text = "${data?.buildingArea} m2", leadingIcon = Icons.Default.OtherHouses)
                IconTextCardColumn(text = "${data?.bedroom} K. Tidur", leadingIcon = Icons.Default.Bed)
                IconTextCardColumn(text = "${data?.bathroom} K. Mandi", leadingIcon = Icons.Default.Bathtub)
                IconTextCardColumn(text = "${data?.carport} Carport", leadingIcon = Icons.Default.Garage)
                IconTextCardColumn(text = data?.powerSupply ?: "Listrik", leadingIcon = Icons.Default.Bolt)
                IconTextCardColumn(text = data?.waterType ?: "Air", leadingIcon = Icons.Default.WaterDrop)
                IconTextCardColumn(text = "${data?.phoneLine} Saluran", leadingIcon = Icons.Default.Phone)
            }
            IconTextCardColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 14.dp, horizontal = 24.dp),
                text = if (data?.isFurniture == true) "Dengan Furnitur" else "Tanpa Furnitur",
                leadingIcon = Icons.Default.Chair
            )
        } // Fasilitas
        item {
            if(!data?.virtualTour.isNullOrEmpty()){
                Text(
                    text = "Virtual Tour",
                    modifier = Modifier.padding(horizontal = 24.dp),
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.height(5.dp))
                PrimaryButton(
                    title = "Lihat Virtual Tour",
                    leadingIcon = Icons.Default.ViewInAr,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    onClick = {
                        onVirtualTourClick(1)
                    }
                )
            }
        } // Virtual Tour
        item {
            if(!data?.video.isNullOrEmpty()){
                Text(
                    text = "Video",
                    modifier = Modifier.padding(horizontal = 24.dp),
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.height(5.dp))
                VideoPlayer(
                    player = viewModel.player,
                    lifecycle = lifecycle,
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth()
                )
            }
        } // Video
        item {
            Text(
                text = "Peta Lokasi",
                modifier = Modifier.padding(horizontal = 24.dp),
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(5.dp))
            PrimaryButton(
                title = "Lihat Peta Lokasi",
                leadingIcon = Icons.Default.Map,
                modifier = Modifier.padding(horizontal = 24.dp),
                onClick = {
                    viewModel.openMap(context)
                }
            )
        } // Peta Lokasi
        item {
            if ((data?.dokumen?.size ?: 0) > 0) {
                Text(
                    text = "Dokumen",
                    modifier = Modifier.padding(horizontal = 24.dp),
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.height(5.dp))
                data?.dokumen?.forEach {docName ->
                    DokumenButton(
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        title = docName,
                        onClick = {}
                    )
                }
            }
        } // Dokumen
        item {
            Text(
                text = "Fasilitas",
                modifier = Modifier.padding(horizontal = 24.dp),
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(5.dp))
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                mainAxisSpacing = 14.dp,
                crossAxisSpacing = 14.dp,
                mainAxisAlignment = if((data?.fasilitas?.size ?: 0) > 3) MainAxisAlignment.SpaceBetween else MainAxisAlignment.Start,
                crossAxisAlignment = FlowCrossAxisAlignment.Start,
            ) {
                data?.fasilitas?.forEach {fac ->
                    IconTextCardColumn(text = fac, leadingIcon = Icons.Default.House)
                }
            }
        } // Fasilitas
        item {
            Text(
                text = "Infrastruktur",
                modifier = Modifier.padding(horizontal = 24.dp),
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(5.dp))
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                mainAxisSpacing = 14.dp,
                crossAxisSpacing = 14.dp,
                mainAxisAlignment = if ((data?.infrastruktur?.size ?: 0) > 3) MainAxisAlignment.SpaceBetween else MainAxisAlignment.Start,
                crossAxisAlignment = FlowCrossAxisAlignment.Start,
            ) {
                data?.infrastruktur?.forEach {inf ->
                    IconTextCardColumn(text = inf.name, leadingIcon = Icons.Default.House, subText = "${inf.distance} KM")
                }
            }
        } // Infrastruktur
        item {
            AgentContactRow(
                image = R.drawable.jisoo,
                name = data?.agentName ?: "Agent Name",
                phone = data?.agentPhone ?: "Agent Phone",
                whatsapp = data?.agentPhone ?: "Agent Whatsapp",
            )
            Spacer(modifier = Modifier.height(24.dp))

        } // Agent

    }
}
