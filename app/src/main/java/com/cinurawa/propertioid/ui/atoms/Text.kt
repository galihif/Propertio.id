package com.cinurawa.propertioid.ui.atoms

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun TitleSectionText(
    modifier: Modifier = Modifier,
    title: String
) {
    Text(
        text = title,
        style = MaterialTheme.typography.h6,
        modifier = modifier,
        textAlign = TextAlign.Center,
        fontSize = 24.sp
    )
}

@Composable
fun PropertyAttributeText(
    attribute:String,
    value:String
) {
    Text(
        buildAnnotatedString {
            withStyle(
                style = MaterialTheme.typography.subtitle1.toSpanStyle()
                    .copy(color = Color.Gray)
            ) {
                append("$attribute : ")
            }
            withStyle(
                style = MaterialTheme.typography.subtitle1.toSpanStyle()
                    .copy(fontWeight = FontWeight.Bold)
            ) {
                append(value)
            }
        }
    )
}