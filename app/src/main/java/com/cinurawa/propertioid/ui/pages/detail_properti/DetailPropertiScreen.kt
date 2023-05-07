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
import com.cinurawa.propertioid.ui.atoms.DokumenButton
import com.cinurawa.propertioid.ui.atoms.PrimaryButton
import com.cinurawa.propertioid.ui.atoms.PropertyAttributeText
import com.cinurawa.propertioid.ui.molecules.*
import com.cinurawa.propertioid.ui.organisms.ContactRow
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
    slug: String,
    onVirtualTourClick: (String) -> Unit = {},
    onDocumentClick: (String) -> Unit = {},
    viewModel: DetailPropertiViewModel = hiltViewModel()
) {
    viewModel.setSlug(slug)

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

    val property by remember {
        viewModel.property
    }.collectAsState()
    val error by remember {
        viewModel.error
    }.collectAsState()
    viewModel.addVideoUri(property.video, context)
    viewModel.addLocation(property.name, property.latitude, property.longitude)

    if (error.isNotEmpty()){
        ErrorColumn(error = error)
    }else{
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            item {
                ImageCarousel(
                    modifier = Modifier
                        .fillMaxWidth(),
                    imagesUrl = property.photosUrl
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
                    IconTextBadge(
                        text = property.type,
                        icon = R.drawable.ic_house,
                        color = Blue500
                    )
                    IconTextBadge(
                        text = property.listingType,
                        icon = R.drawable.ic_sell,
                        color = Red500
                    )
                    IconTextBadge(
                        text = property.certificate,
                        icon = R.drawable.ic_shm,
                        color = Purple500
                    )
                }
            } // Label
            item {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = property.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    IconTextBadge(text = "Properti Kode : ${property.propertyCode}", leadingIcon = null)
                }
            } // Judul
            item {
                IconText(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    leadingIcon = Icons.Default.LocationOn,
                    text = property.address,
                    iconTint = Red500
                )
            } // Lokasi
            item {
                HargaShare(harga = 50000000, modifier = Modifier.padding(horizontal = 24.dp))
            } // Harga Share
            item {
                Text(
                    text = "Deskripsi",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
                Text(
                    text = property.desc,
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
                        PropertyAttributeText(
                            attribute = "Kondisi",
                            value = property.condition
                        )
                        PropertyAttributeText(attribute = "Hadap", value = property.facing)
                        PropertyAttributeText(
                            attribute = "Berdiri",
                            value = property.yearBuilt.toString()
                        )
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
                    IconTextCardColumn(
                        text = "${property.floor} lantai",
                        leadingIcon = Icons.Default.Stairs
                    )
                    IconTextCardColumn(
                        text = "${property.surfaceArea} m2",
                        leadingIcon = Icons.Default.AspectRatio
                    )
                    IconTextCardColumn(
                        text = "${property.buildingArea} m2",
                        leadingIcon = Icons.Default.OtherHouses
                    )
                    IconTextCardColumn(
                        text = "${property.bedroom} K. Tidur",
                        leadingIcon = Icons.Default.Bed
                    )
                    IconTextCardColumn(
                        text = "${property.bathroom} K. Mandi",
                        leadingIcon = Icons.Default.Bathtub
                    )
                    IconTextCardColumn(
                        text = "${property.carport} Carport",
                        leadingIcon = Icons.Default.Garage
                    )
                    IconTextCardColumn(
                        text = property.powerSupply,
                        leadingIcon = Icons.Default.Bolt
                    )
                    IconTextCardColumn(
                        text = property.waterType,
                        leadingIcon = Icons.Default.WaterDrop
                    )
                    IconTextCardColumn(
                        text = "${property.phoneLine} Saluran",
                        leadingIcon = Icons.Default.Phone
                    )
                }
                IconTextCardColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 14.dp, horizontal = 24.dp),
                    text = if (property.isFurniture) "Dengan Furnitur" else "Tanpa Furnitur",
                    leadingIcon = Icons.Default.Chair
                )
            } // Fasilitas
            item {
                if (property.virtualTour.isNotEmpty()) {
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
                            onVirtualTourClick(property.virtualTour)
                        }
                    )
                }
            } // Virtual Tour
            item {
                if (property.video.isNotEmpty()) {
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
                if ((property.latitude != 0.0) && (property.longitude != 0.0)) {
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
                }
            } // Peta Lokasi
            item {
                if ((property.dokumen?.size ?: 0) > 0) {
                    Text(
                        text = "Dokumen",
                        modifier = Modifier.padding(horizontal = 24.dp),
                        style = MaterialTheme.typography.h6
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    property.dokumen?.forEach { doc ->
                        DokumenButton(
                            modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                            title = doc.nama,
                            onClick = {
                                onDocumentClick(doc.link)
                            }
                        )
                    }
                }
            } // Dokumen
            item {
                if ((property.fasilitas?.size ?: 0) > 0) {

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
                        mainAxisAlignment = if ((property.fasilitas?.size
                                ?: 0) > 3
                        ) MainAxisAlignment.SpaceBetween else MainAxisAlignment.Start,
                        crossAxisAlignment = FlowCrossAxisAlignment.Start,
                    ) {
                        property.fasilitas?.forEach { fac ->
                            IconTextCardColumn(text = fac, leadingIcon = Icons.Default.House)
                        }
                    }
                }
            } // Fasilitas
            item {
                if ((property.infrastruktur?.size ?: 0) > 0) {
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
                        mainAxisAlignment = if ((property.infrastruktur?.size
                                ?: 0) > 3
                        ) MainAxisAlignment.SpaceBetween else MainAxisAlignment.Start,
                        crossAxisAlignment = FlowCrossAxisAlignment.Start,
                    ) {
                        property.infrastruktur?.forEach { inf ->
                            IconTextCardColumn(
                                text = inf.name,
                                leadingIcon = Icons.Default.House,
                                subText = "${inf.distance} KM"
                            )
                        }
                    }
                }
            } // Infrastruktur
            item {
                ContactRow(
                    image = property.agentImage,
                    desc = "Agen",
                    name = property.agentName,
                    phone = property.agentPhone,
                    whatsapp = property.agentPhone,
                )
                Spacer(modifier = Modifier.height(24.dp))

            } // Agent

        }
    }
}
