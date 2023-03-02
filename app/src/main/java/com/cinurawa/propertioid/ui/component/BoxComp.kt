package com.cinurawa.propertioid.ui.component

import SelectDropdown
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.R

@Composable
fun HomeBanner() {
    Box(
        modifier = Modifier.wrapContentSize(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.home_banner),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
        )
        Text(
            text = "Temukan Hunian Impian Anda Hanya Disini!",
            color = Color.White,
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .matchParentSize()
                .padding(16.dp)
        )
    }
}


@ExperimentalMaterialApi
@Composable
fun HomeSearchCard() {
    val context = LocalContext.current
    val options = listOf("Option 1", "Option 2", "Option 3")
    var selectedOption by remember { mutableStateOf("") }

    LaunchedEffect(key1 = selectedOption) {
        Toast.makeText(context, selectedOption, Toast.LENGTH_SHORT).show()
    }
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            SelectDropdown(
                options = options,
                selectedOption = selectedOption,
                onOptionSelected = { newOption ->
                    selectedOption = newOption
                }
            )
        }
    }
}