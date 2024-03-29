package com.cinurawa.propertioid.ui.pages.detail_project.detail_unit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AspectRatio
import androidx.compose.material.icons.filled.Bathtub
import androidx.compose.material.icons.filled.Bed
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Garage
import androidx.compose.material.icons.filled.OtherHouses
import androidx.compose.material.icons.filled.Roofing
import androidx.compose.material.icons.filled.Stairs
import androidx.compose.material.icons.filled.ViewInAr
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.data.model.ProjectUnit
import com.cinurawa.propertioid.ui.atoms.PrimaryButton
import com.cinurawa.propertioid.ui.molecules.HargaShare
import com.cinurawa.propertioid.ui.molecules.IconTextBadge
import com.cinurawa.propertioid.ui.molecules.IconTextCardColumn
import com.cinurawa.propertioid.ui.organisms.ImageCarousel
import com.cinurawa.propertioid.ui.organisms.YoutubePlayer
import com.cinurawa.propertioid.ui.pages.detail_project.DetailProjectViewModel
import com.cinurawa.propertioid.ui.theme.Blue500
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun DetailUnitScreen(
    data: ProjectUnit?,
    onVirtualTourClicked: (String) -> Unit = {},
    viewModel: DetailProjectViewModel,
) {

    val context = LocalContext.current
    if (data != null) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.testTag("detail_unit_screen")
        ) {
            item {
                ImageCarousel(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("image_carousel"),
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
                    IconTextBadge(text = "Kode Unit : ${data.code}", leadingIcon = null)
                }
            } // Title
            item {
                HargaShare(
                    hargaTitle = "Harga mulai dari",
                    harga = data.price,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    onShareClick = {
                        viewModel.shareUnit(context, data.name, data.price, data.code)
                    }
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
                    text = "Spesifikasi",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
                Text(
                    text = data.spec,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
            } // Spesifikasi

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
                        text = "${data.floor} lantai",
                        leadingIcon = Icons.Default.Stairs
                    )
                    IconTextCardColumn(
                        text = "${data.surfaceArea} m2",
                        leadingIcon = Icons.Default.AspectRatio
                    )
                    IconTextCardColumn(
                        text = "${data.buildingArea} m2",
                        leadingIcon = Icons.Default.OtherHouses
                    )
                    IconTextCardColumn(
                        text = "${data.bedroom} K. Tidur",
                        leadingIcon = Icons.Default.Bed
                    )
                    IconTextCardColumn(
                        text = "${data.bathroom} K. Mandi",
                        leadingIcon = Icons.Default.Bathtub
                    )
                    IconTextCardColumn(
                        text = "${data.garage} Garasi",
                        leadingIcon = Icons.Default.Garage
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        IconTextCardColumn(
                            modifier = Modifier
                                .weight(1f)
                                .testTag("fasilitas"),
                            text = data.powerSupply,
                            leadingIcon = Icons.Default.Bolt
                        )
                        IconTextCardColumn(
                            modifier = Modifier.weight(1f),
                            text = data.waterType,
                            leadingIcon = Icons.Default.WaterDrop
                        )
                    }
                }
            } // Fasilitas
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
                        modifier = Modifier
                            .padding(horizontal = 24.dp)
                            .testTag("virtual_tour"),
                        onClick = { onVirtualTourClicked(data.virtualTour) }
                    )
                }
            } // Virtual Tour
            item {
                if (!data.model3D.isNullOrEmpty()) {
                    Text(
                        text = "3D Site Plan",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    PrimaryButton(
                        title = "Lihat 3D Site Plan",
                        leadingIcon = Icons.Filled.Roofing,
                        modifier = Modifier
                            .padding(horizontal = 24.dp)
                            .testTag("3d_site_plan"),
                        onClick = {}
                    )
                }
            } // 3D Site Plan
            item {
                if (!data.video.isNullOrEmpty()) {
                    Text(
                        text = "Video",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    YoutubePlayer(
                        videoId = data.video,
                        modifier = Modifier
                            .padding(horizontal = 24.dp)
                            .testTag("video_player")
                            .fillMaxWidth()
                    )
                }
            } // Video
        }
    }
}
