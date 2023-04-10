package com.cinurawa.propertioid.ui.pages.detail_project

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.data.model.Project
import com.cinurawa.propertioid.ui.atoms.DokumenButton
import com.cinurawa.propertioid.ui.atoms.PrimaryButton
import com.cinurawa.propertioid.ui.atoms.TitleSectionText
import com.cinurawa.propertioid.ui.molecules.HargaShare
import com.cinurawa.propertioid.ui.molecules.IconText
import com.cinurawa.propertioid.ui.molecules.IconTextBadge
import com.cinurawa.propertioid.ui.molecules.IconTextCardColumn
import com.cinurawa.propertioid.ui.organisms.AgentContactRow
import com.cinurawa.propertioid.ui.organisms.ImageCarousel
import com.cinurawa.propertioid.ui.organisms.ProjectUnitItem
import com.cinurawa.propertioid.ui.organisms.VideoPlayer
import com.cinurawa.propertioid.ui.theme.Blue500
import com.cinurawa.propertioid.ui.theme.Purple700
import com.cinurawa.propertioid.ui.theme.Red500
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun DetailProjectScreen(
    data: Project?,
    viewModel: DetailProjectViewModel = hiltViewModel(),
    onUnitClicked: (Int) -> Unit = {},
    onVirtualTourClicked: (String) -> Unit = {},
    onDokumenClicked: (String) -> Unit = {},
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

    viewModel.addVideoUri("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")

    if (data != null) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            item {
                ImageCarousel(
                    modifier = Modifier
                        .fillMaxWidth(),
                    imagesUrl = data.photosUrl
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
                    IconTextBadge(text = data.type, icon = R.drawable.ic_house, color = Blue500)
                    IconTextBadge(
                        text = data.certificate,
                        icon = R.drawable.ic_shm,
                        color = Purple700
                    )
                }
            } // Label
            item {
                Column(
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = data.name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    IconTextBadge(text = "Unit Kode : ${data.code}", leadingIcon = null)
                }
            } // Title
            item {
                IconText(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    leadingIcon = Icons.Default.LocationOn,
                    text = data.address,
                    iconTint = Red500
                )
            } // Lokasi
            item {
                HargaShare(
                    hargaTitle = "Harga mulai dari",
                    hargaTerendah = data.startPrice,
                    hargaTertinggi = data.finalPrice,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
            } // Harga Share
            item {
                Text(
                    text = "Deskripsi",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
                Text(
                    text = data.desc,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
            } // Deskripsi
            item {
                Text(
                    text = "Konsep",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
                Text(
                    text = data.concept,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
            } // Konsep
            item {
                TitleSectionText(
                    title = "Daftar Unit",
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth(),
                )
            } // Daftar Unit Title
            items(data.listUnit ?: emptyList()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                ) {
                    ProjectUnitItem(
                        onDetailClicked = { onUnitClicked(it.id) },
                        data = it
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
            } // Daftar Unit List
            item {
                if (!data.virtualTour.isNullOrEmpty()) {
                    Text(
                        text = "Virtual Tour",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    PrimaryButton(
                        title = "Lihat Virtual Tour",
                        leadingIcon = Icons.Default.ViewInAr,
                        modifier = Modifier.padding(horizontal = 24.dp),
                        onClick = { onVirtualTourClicked(data.virtualTour) }
                    )
                }
            } // Virtual Tour
            item {
                if (!data.site3DPlan.isNullOrEmpty()) {
                    Text(
                        text = "3D Site Plan",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    PrimaryButton(
                        title = "Lihat 3D Site Plan",
                        leadingIcon = Icons.Filled.Roofing,
                        modifier = Modifier.padding(horizontal = 24.dp),
                        onClick = {}
                    )
                }
            } // 3D Site Plan
            item {
                if (!data.arApps.isNullOrEmpty()) {
                    Text(
                        text = "AR App",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    PrimaryButton(
                        title = "Download App",
                        leadingIcon = Icons.Filled.Download,
                        modifier = Modifier.padding(horizontal = 24.dp),
                        onClick = {}
                    )
                }
            } // AR App
            item {
                if (!data.video.isNullOrEmpty()) {
                    Text(
                        text = "Video",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(horizontal = 24.dp)
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
                if ((data.latitude != 0.0) && (data.longitude != 0.0)) {
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
                if ((data.dokumen?.size ?: 0) > 0) {
                    Text(
                        text = "Dokumen",
                        modifier = Modifier.padding(horizontal = 24.dp),
                        style = MaterialTheme.typography.h6
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    data.dokumen?.forEach { docName ->
                        DokumenButton(
                            modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                            title = docName,
                            onClick = {
                                onDokumenClicked(docName)
                            }
                        )
                    }
                }
            } // Dokumen
            item {
                if((data.fasilitas?.size ?: 0) > 0){

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
                        mainAxisAlignment = if ((data.fasilitas?.size
                                ?: 0) > 3
                        ) MainAxisAlignment.SpaceBetween else MainAxisAlignment.Start,
                        crossAxisAlignment = FlowCrossAxisAlignment.Start,
                    ) {
                        data.fasilitas?.forEach { fac ->
                            IconTextCardColumn(text = fac, leadingIcon = Icons.Default.House)
                        }
                    }
                }
            } // Fasilitas

            item {
                if((data.infrastruktur?.size ?: 0) > 0){
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
                        mainAxisAlignment = if ((data.infrastruktur?.size
                                ?: 0) > 3
                        ) MainAxisAlignment.SpaceBetween else MainAxisAlignment.Start,
                        crossAxisAlignment = FlowCrossAxisAlignment.Start,
                    ) {
                        data.infrastruktur?.forEach { inf ->
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
                AgentContactRow(
                    image = R.drawable.jisoo,
                    name = "Jisoo",
                    phone = "+62852102322",
                    whatsapp = "+62852102322",
                )
                Spacer(modifier = Modifier.height(24.dp))

            } // Agent

        }
    }
}
