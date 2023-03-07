package com.cinurawa.propertioid.ui.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.R

@Composable
fun StarBadge(
    modifier: Modifier = Modifier
) {
    Card(
        shape = CircleShape,
        backgroundColor = MaterialTheme.colors.primary,
        modifier = modifier
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.star_white),
            contentDescription = "",
            modifier = Modifier.padding(10.dp)
        )
    }
}