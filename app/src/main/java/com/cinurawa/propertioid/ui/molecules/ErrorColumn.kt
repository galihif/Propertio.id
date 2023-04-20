package com.cinurawa.propertioid.ui.molecules

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.ui.theme.Blue700
import com.cinurawa.propertioid.ui.theme.DarkBlue500

@Composable
fun ErrorColumn(
    modifier: Modifier = Modifier,
    error:String
) {
    Column(modifier = modifier.fillMaxSize().padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Icon(imageVector = Icons.Default.Error, contentDescription = "", modifier = Modifier.size(64.dp), tint = Blue700)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = error, textAlign = TextAlign.Center,style = MaterialTheme.typography.h6.copy(color = DarkBlue500, fontWeight = FontWeight.Bold))
    }
}