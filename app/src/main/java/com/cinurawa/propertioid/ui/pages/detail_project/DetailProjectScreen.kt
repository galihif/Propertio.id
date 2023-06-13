package com.cinurawa.propertioid.ui.pages.detail_project

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Roofing
import androidx.compose.material.icons.filled.ViewInAr
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.data.model.ProjectUnit
import com.cinurawa.propertioid.ui.atoms.DokumenButton
import com.cinurawa.propertioid.ui.atoms.PrimaryButton
import com.cinurawa.propertioid.ui.atoms.TitleSectionText
import com.cinurawa.propertioid.ui.molecules.ErrorColumn
import com.cinurawa.propertioid.ui.molecules.HargaShare
import com.cinurawa.propertioid.ui.molecules.IconText
import com.cinurawa.propertioid.ui.molecules.IconTextBadge
import com.cinurawa.propertioid.ui.molecules.IconTextCardColumn
import com.cinurawa.propertioid.ui.organisms.ContactRow
import com.cinurawa.propertioid.ui.organisms.ImageCarousel
import com.cinurawa.propertioid.ui.organisms.ProjectUnitItem
import com.cinurawa.propertioid.ui.organisms.YoutubePlayer
import com.cinurawa.propertioid.ui.theme.Blue500
import com.cinurawa.propertioid.ui.theme.Purple700
import com.cinurawa.propertioid.ui.theme.Red500
import com.cinurawa.propertioid.ui.utils.getFacilityIcon
import com.cinurawa.propertioid.ui.utils.getInfraIcon
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun DetailProjectScreen(
    slug: String,
    viewModel: DetailProjectViewModel,
    onUnitClicked: (ProjectUnit) -> Unit = {},
    onVirtualOrSiteplanClicked: (String) -> Unit = {},
) {
    viewModel.setSlug(slug)
    val context = LocalContext.current
    val project by remember {
        viewModel.project
    }.collectAsState()

    val error by remember {
        viewModel.error
    }.collectAsState()
    viewModel.addLocation(
        project.name,
        project.latitude,
        project.longitude
    )
    if (error.isNotEmpty()) {
        ErrorColumn(error = error)
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.testTag("detail_project_screen")
        ) {
            item {
                ImageCarousel(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("image_carousel"),
                    imagesUrl = project.photosUrl
                )
            } // Image Carousel
            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .testTag("label")
                ) {
                    IconTextBadge(text = project.type, icon = R.drawable.ic_house, color = Blue500)
                    IconTextBadge(
                        text = project.certificate,
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
                    Text(text = project.name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    IconTextBadge(text = "Kode Proyek : ${project.code}", leadingIcon = null)
                }
            } // Title
            item {
                IconText(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    leadingIcon = Icons.Default.LocationOn,
                    text = project.address,
                    iconTint = Red500
                )
            } // Lokasi
            item {
                HargaShare(
                    hargaTitle = "Harga mulai dari",
                    hargaTerendah = project.startPrice,
                    hargaTertinggi = project.finalPrice,
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .testTag("harga"),
                    onShareClick = {
                        viewModel.shareProject(context)
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
                    text = project.desc,
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
                    text = project.concept,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
            } // Konsep
            item {
                if (project.listUnit.isNotEmpty()) {
                    TitleSectionText(
                        title = "Daftar Unit",
                        modifier = Modifier
                            .padding(horizontal = 24.dp)
                            .fillMaxWidth(),
                    )
                }
            } // Daftar Unit Title
            items(project.listUnit) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                ) {
                    ProjectUnitItem(
                        onDetailClicked = { onUnitClicked(it) },
                        data = it
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
            } // Daftar Unit List
            item {
                if (project.virtualTour.isNotEmpty()) {
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
                        onClick = { onVirtualOrSiteplanClicked(project.virtualTour) }
                    )
                }
            } // Virtual Tour
            item {
                if (project.site3DPlan.isNotEmpty()) {
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
                            .testTag("btn_3d_siteplan"),
                        onClick = { onVirtualOrSiteplanClicked(project.site3DPlan) }
                    )
                }
            } // 3D Site Plan
            item {
                if (project.arApps.isNotEmpty()) {
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
                        onClick = {
                            viewModel.downloadApps(context, project.arApps)
                        }
                    )
                }
            } // AR App
            item {
                if (project.video.isNotEmpty()) {
                    Text(
                        text = "Video",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    YoutubePlayer(
                        videoId = project.video,
                        context = context,
                        modifier = Modifier
                            .padding(horizontal = 24.dp)
                            .testTag("video_player")
                            .fillMaxWidth()
                    )
                }
            } // Video
            item {
                if ((project.latitude != 0.0) && (project.longitude != 0.0)) {
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
                if (project.dokumen.isNotEmpty()) {
                    Text(
                        text = "Dokumen",
                        modifier = Modifier.padding(horizontal = 24.dp),
                        style = MaterialTheme.typography.h6
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    project.dokumen.forEach { doc ->
                        DokumenButton(
                            modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                            title = doc.nama,
                            onClick = {
                                viewModel.openDokumen(context, doc.link)
                            }
                        )
                    }
                }
            } // Dokumen
            item {
                if (project.fasilitas.isNotEmpty()) {

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
                        mainAxisAlignment = if (project.fasilitas.size > 3
                        ) MainAxisAlignment.SpaceBetween else MainAxisAlignment.Start,
                        crossAxisAlignment = FlowCrossAxisAlignment.Start,
                    ) {
                        project.fasilitas.forEach { fac ->
                            IconTextCardColumn(text = fac, leadingIcon = fac.getFacilityIcon())
                        }
                    }
                }
            } // Fasilitas

            item {
                if (project.infrastruktur.isNotEmpty()) {
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
                        mainAxisAlignment = if (project.infrastruktur.size > 3
                        ) MainAxisAlignment.SpaceBetween else MainAxisAlignment.Start,
                        crossAxisAlignment = FlowCrossAxisAlignment.Start,
                    ) {
                        project.infrastruktur.forEach { inf ->
                            IconTextCardColumn(
                                text = inf.name,
                                leadingIcon = inf.type.getInfraIcon(),
                                subText = "${inf.distance} KM"
                            )
                        }
                    }
                }
            } // Infrastruktur
            item {
                ContactRow(
                    image = project.agentImage,
                    desc = "Developer",
                    name = project.agentName,
                    phone = project.agentPhone,
                    onPhoneClick = {
                        viewModel.callNumber(context, project.agentPhone)
                    },
                    onWhatsappClick = {
                        viewModel.openWhatsapp(context, project.agentPhone)
                    },
                )
                Spacer(modifier = Modifier.height(24.dp))

            } // Agent
        }
    }
}
