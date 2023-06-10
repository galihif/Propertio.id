package com.cinurawa.propertioid.ui.molecules

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ContactCard(
    modifier: Modifier = Modifier,
    text: String,
    @DrawableRes leadingIcon:Int,
    bgColor:Color = Color(0xFFF0F3FF),
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .clickable {
                onClick()
            },
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = bgColor,
    ){
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
        ){
            Image(painter = painterResource(id = leadingIcon), contentDescription = "")
            Text(
                text = text,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}