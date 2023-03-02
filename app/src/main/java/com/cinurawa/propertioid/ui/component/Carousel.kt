package com.cinurawa.propertioid.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.ui.model.CarouselContent
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun HomeCarousel(
    modifier: Modifier = Modifier
) {

    val listCarouselItem = listOf<CarouselContent>(
        CarouselContent(
            title = "Jual Beli Properti",
            description = "Temukan properti terbaik di sini. Kami menawarkan berbagai pilihan rumah, apartemen, dan tanah yang sesuai dengan kebutuhanmu.",
            image = R.drawable.carousel_jualbeli
        ),
        CarouselContent(
            title = "Sewa Properti",
            description = "Temukan solusi jual beli properti terbaik di sini. Kami siap membantumu menemukan rumah impianmu.",
            image = R.drawable.carousel_sewa
        ),
        CarouselContent(
            title = "Direktori Properti",
            description = "Nikmati keuntungan berinvestasi di properti bersama kami. Kami menyediakan direktori properti terlengkap untukmu.",
            image = R.drawable.carousel_direktori
        ),
        CarouselContent(
            title = "Berita Properti Terbaru",
            description = "Temukan berita terkini dan terpercaya mengenai properti di sini. Jangan lewatkan informasi penting lainnya.",
            image = R.drawable.carousel_berita
        ),

        )
    val pagerState = rememberPagerState()

    Column(
        modifier = modifier
    ) {
        HorizontalPager(count = listCarouselItem.size, state = pagerState) { index ->
            HomeCarouselItem(
                listCarouselItem[index]
            )
        }
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            activeColor = MaterialTheme.colors.primary,
            inactiveColor = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        )
    }
}


@Composable
fun HomeCarouselItem(content: CarouselContent) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Image(painter = painterResource(id = content.image), contentDescription = "")
        Text(text = content.title, style = MaterialTheme.typography.h6)
        Text(
            text = content.description,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center
        )
    }
}