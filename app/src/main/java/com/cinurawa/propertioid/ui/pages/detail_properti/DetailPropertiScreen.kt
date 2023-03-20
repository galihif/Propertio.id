package com.cinurawa.propertioid.ui.pages.detail_properti

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Stairs
import androidx.compose.material.icons.filled.ViewInAr
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.ui.PlayerView
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.ui.atoms.PrimaryButton
import com.cinurawa.propertioid.ui.atoms.PropertyAttributeText
import com.cinurawa.propertioid.ui.atoms.TitleSectionText
import com.cinurawa.propertioid.ui.molecules.HargaShare
import com.cinurawa.propertioid.ui.molecules.IconText
import com.cinurawa.propertioid.ui.molecules.IconTextBadge
import com.cinurawa.propertioid.ui.molecules.IconTextCardColumn
import com.cinurawa.propertioid.ui.organisms.ImageCarousel
import com.cinurawa.propertioid.ui.theme.Blue500
import com.cinurawa.propertioid.ui.theme.PropertioidTheme
import com.cinurawa.propertioid.ui.theme.Purple500
import com.cinurawa.propertioid.ui.theme.Red500
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun DetailPropertiScreen(
    id: Int,
    viewModel: DetailPropertiViewModel = hiltViewModel()
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
        }
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
                IconTextBadge(text = "SHM", icon = R.drawable.ic_shm, color = Purple500)
            }
        }
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Old House", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                IconTextBadge(text = "Properti Kode : 5237KM", leadingIcon = null)
            }
        }
        item {
            Text(
                text = "Lorem ipsum dolor sit amet consectetur. Id viverra nec.",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }
        item {
            IconText(
                modifier = Modifier.padding(horizontal = 24.dp),
                leadingIcon = Icons.Default.LocationOn,
                text = "Jl. Kebon Jeruk No. 12, Jakarta Barat",
                iconTint = Red500
            )
        }
        item {
            HargaShare(harga = 50000000, modifier = Modifier.padding(horizontal = 24.dp))
        }
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
        }
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
                    PropertyAttributeText(attribute = "Kondisi", value = "Butuh Renovasi")
                    PropertyAttributeText(attribute = "Hadap", value = "Utara")
                    PropertyAttributeText(attribute = "Berdiri", value = "2007")
                }
            }
        }
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
                for (i in 1..9) {
                    IconTextCardColumn(text = "2 lantai", leadingIcon = Icons.Default.Stairs)
                }
            }
            IconTextCardColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 14.dp, horizontal = 24.dp),
                text = "2 lantai",
                leadingIcon = Icons.Default.Stairs
            )
        }
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
        }
        item {
            TitleSectionText(title = "Video", modifier = Modifier.padding(horizontal = 24.dp))
            Spacer(modifier = Modifier.height(5.dp))
            AndroidView(
                factory = { context ->
                    PlayerView(context).also {
                        it.player = viewModel.player
                    }
                },
                update = {
                    when (lifecycle) {
                        Lifecycle.Event.ON_PAUSE -> {
                            it.onPause()
                            it.player?.pause()
                        }
                        Lifecycle.Event.ON_RESUME -> {
                            it.onResume()
                        }
                        else -> Unit
                    }
                },
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 14.dp)
                    .fillMaxWidth()
                    .aspectRatio(16 / 9f)
                    .clip(RoundedCornerShape(12.dp))
            )
        }
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
        }
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun DetailPropertiScreenPreview() {
    PropertioidTheme {
        DetailPropertiScreen(1)
    }
}