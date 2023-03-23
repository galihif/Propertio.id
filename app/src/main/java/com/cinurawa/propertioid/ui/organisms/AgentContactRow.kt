package com.cinurawa.propertioid.ui.organisms

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.ui.atoms.RoundedImage
import com.cinurawa.propertioid.ui.molecules.ContactCard

@Composable
fun AgentContactRow(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    name: String,
    phone: String,
    whatsapp: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(horizontal = 24.dp),
    ) {
        RoundedImage(
            image = image,
            modifier = Modifier
                .height(140.dp)
                .weight(1f)
        )
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1.5f)
                .padding(start = 14.dp),
            verticalArrangement = Arrangement.SpaceBetween,

            ) {
            Text(
                text = name,
                style = MaterialTheme.typography.h6,
            )
            Text(
                text = "Agen Properti",
                style = MaterialTheme.typography.body1,
            )
            ContactCard(
                text = phone,
                leadingIcon = R.drawable.ic_phone,
                onClick = {}
            )
            ContactCard(
                text = "Chat via Whatsapp",
                leadingIcon = R.drawable.ic_wa,
                bgColor = Color(0xFFF6F6F6),
                onClick = {}
            )
        }
    }
}