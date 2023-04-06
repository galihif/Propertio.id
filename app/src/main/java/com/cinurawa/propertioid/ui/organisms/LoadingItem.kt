package com.cinurawa.propertioid.ui.organisms

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.ui.utils.shimmerBackground


@Composable
fun LoadingItem(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(200.dp)
                .shimmerBackground(RoundedCornerShape(8.dp))
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                Modifier
                    .width(64.dp)
                    .height(16.dp)
                    .shimmerBackground(RoundedCornerShape(8.dp))
            )
            Box(
                Modifier
                    .width(64.dp)
                    .height(16.dp)
                    .shimmerBackground(RoundedCornerShape(8.dp))
            )

        }

        Box(
            Modifier
                .width(120.dp)
                .height(24.dp)
                .shimmerBackground(RoundedCornerShape(8.dp))
        )
        Box(
            Modifier
                .width(160.dp)
                .height(24.dp)
                .shimmerBackground(RoundedCornerShape(8.dp))
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)){
                Box(
                    Modifier
                        .width(80.dp)
                        .height(16.dp)
                        .shimmerBackground(RoundedCornerShape(8.dp))
                )
                Box(
                    Modifier
                        .width(120.dp)
                        .height(24.dp)
                        .shimmerBackground(RoundedCornerShape(8.dp))
                )
            }
            Box(
                Modifier
                    .width(120.dp)
                    .height(48.dp)
                    .shimmerBackground(RoundedCornerShape(8.dp))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingItemPreview() {
    LoadingItem()
}