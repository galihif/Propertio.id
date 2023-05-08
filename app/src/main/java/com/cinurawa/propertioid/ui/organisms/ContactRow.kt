package com.cinurawa.propertioid.ui.organisms

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.ui.atoms.MyImage
import com.cinurawa.propertioid.ui.molecules.ContactCard

@Composable
fun ContactRow(
    modifier: Modifier = Modifier,
    desc:String,
    image: String,
    name: String,
    phone: String,
    onPhoneClick: () -> Unit = {},
    onWhatsappClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(horizontal = 24.dp),
    ) {
        MyImage(
            image = image,
            modifier = Modifier
                .height(140.dp)
                .weight(1f),
            cornerRadius = 14
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
                text = desc,
                style = MaterialTheme.typography.body1,
            )
            ContactCard(
                text = phone,
                leadingIcon = R.drawable.ic_phone,
                onClick = onPhoneClick
            )
            ContactCard(
                text = "Chat via Whatsapp",
                leadingIcon = R.drawable.ic_wa,
                bgColor = Color(0xFFF6F6F6),
                onClick = onWhatsappClick
            )
        }
    }
}

