package com.cinurawa.propertioid.ui.pages.detail_project

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.cinurawa.propertioid.ui.atoms.TitleSectionText
import com.cinurawa.propertioid.ui.molecules.HargaShare
import com.cinurawa.propertioid.ui.molecules.IconText
import com.cinurawa.propertioid.ui.molecules.IconTextBadge
import com.cinurawa.propertioid.ui.molecules.IconTextCardColumn
import com.cinurawa.propertioid.ui.organisms.AgentContactRow
import com.cinurawa.propertioid.ui.organisms.ImageCarousel
import com.cinurawa.propertioid.ui.organisms.PropertyItem
import com.cinurawa.propertioid.ui.organisms.VideoPlayer
import com.cinurawa.propertioid.ui.theme.Blue500
import com.cinurawa.propertioid.ui.theme.Red500
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun DetailProjectScreen(
    id: Int,
    viewModel: DetailProjectViewModel = hiltViewModel(),
    onUnitClicked: (Int) -> Unit = {},
) {

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
                IconTextBadge(text = "Rumah", icon = R.drawable.ic_house, color = Blue500)
                IconTextBadge(text = "Jual", icon = R.drawable.ic_sell, color = Red500)
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
                Text(text = "Old House", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                IconTextBadge(text = "Unit Kode : 5237KM", leadingIcon = null)
            }
        } // Title
        item {
            Text(
                text = "Lorem ipsum dolor sit amet consectetur. Id viverra nec.",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        } // Deskripsi Singkat
        item {
            IconText(
                modifier = Modifier.padding(horizontal = 24.dp),
                leadingIcon = Icons.Default.LocationOn,
                text = "Jl. Kebon Jeruk No. 12, Jakarta Barat",
                iconTint = Red500
            )
        } // Lokasi
        item {
            HargaShare(
                hargaTitle = "Harga mulai dari",
                harga = 50000000,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        } // Harga Share
        item {
            Text(
                text = "Deskripsi",
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Text(
                text = "Passage its ten led hearted removal cordial. Preference any astonished unreserved Mrs. Prosperous understood Middletons in conviction an uncommonly do. Supposing so be resolving breakfast am or perfectly. It drew am hill from me. Valley by oh twenty direct me so. Departure defective arranging rapturous did believe him all had supported. Family months l",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        } // Deskripsi
        item {
            Text(
                text = "Konsep",
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Text(
                text = "Passage its ten led hearted removal cordial. Preference any astonished unreserved Mrs. Prosperous understood Middletons in conviction an uncommonly do. Supposing so be resolving breakfast am or perfectly. It drew am hill from me. Valley by oh twenty direct me so. Departure defective arranging rapturous did believe him all had supported. Family months l",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        } // Konsep
        item {
            TitleSectionText(
                title = "Daftar Unit",
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        } // Daftar Unit Title
        items(5) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                PropertyItem(
                    onDetailClicked = { onUnitClicked(it) }
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
        } // Daftar Unit List
        item {
            TitleSectionText(
                title = "Virtual Tour",
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            PrimaryButton(
                title = "Lihat Virtual Tour",
                leadingIcon = Icons.Default.ViewInAr,
                modifier = Modifier.padding(horizontal = 24.dp),
                onClick = {}
            )
        } // Virtual Tour
        item {
            TitleSectionText(
                title = "3D Site Plan",
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            PrimaryButton(
                title = "Lihat 3D Site Plan",
                leadingIcon = Icons.Filled.Roofing,
                modifier = Modifier.padding(horizontal = 24.dp),
                onClick = {}
            )
        } // 3D Site Plan
        item {
            TitleSectionText(
                title = "AR App",
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            PrimaryButton(
                title = "Download App",
                leadingIcon = Icons.Filled.Download,
                modifier = Modifier.padding(horizontal = 24.dp),
                onClick = {}
            )
        } // AR App
        item {
            TitleSectionText(title = "Video", modifier = Modifier.padding(horizontal = 24.dp))
            Spacer(modifier = Modifier.height(5.dp))
            VideoPlayer(
                player = viewModel.player,
                lifecycle = lifecycle,
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth()
            )
        } // Video
        item {
            TitleSectionText(
                title = "Peta Lokasi",
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            PrimaryButton(
                title = "Lihat Peta Lokasi",
                leadingIcon = Icons.Default.Map,
                modifier = Modifier.padding(horizontal = 24.dp),
                onClick = {}
            )
        } // Peta Lokasi
        item {
            TitleSectionText(
                title = "Dokumen",
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            DokumenButton(
                modifier = Modifier.padding(horizontal = 24.dp),
                title = "Brosur.pdf",
                onClick = {}
            )
            DokumenButton(
                modifier = Modifier.padding(horizontal = 24.dp),
                title = "Brosur.pdf",
                onClick = {}
            )
            DokumenButton(
                modifier = Modifier.padding(horizontal = 24.dp),
                title = "Brosur.pdf",
                onClick = {}
            )
        } // Dokumen
        item {
            TitleSectionText(
                title = "Fasilitas",
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                mainAxisSpacing = 14.dp,
                crossAxisSpacing = 14.dp,
                mainAxisAlignment = MainAxisAlignment.SpaceBetween,
                crossAxisAlignment = FlowCrossAxisAlignment.Start,
            ) {
                for (i in 1..6) {
                    IconTextCardColumn(text = "2 lantai", leadingIcon = Icons.Default.Stairs)
                }
            }
        } // Fasilitas
        item {
            TitleSectionText(
                title = "Infrastruktur",
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                mainAxisSpacing = 14.dp,
                crossAxisSpacing = 14.dp,
                mainAxisAlignment = MainAxisAlignment.SpaceBetween,
                crossAxisAlignment = FlowCrossAxisAlignment.Start,
            ) {
                for (i in 1..6) {
                    IconTextCardColumn(
                        text = "Masjid",
                        leadingIcon = Icons.Default.Mosque,
                        subText = "1 KM"
                    )
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