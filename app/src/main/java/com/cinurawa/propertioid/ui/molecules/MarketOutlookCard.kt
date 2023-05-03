package com.cinurawa.propertioid.ui.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cinurawa.propertioid.R

@Composable
fun MarketOutlookCard(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.primary,
        shape = RoundedCornerShape(14.dp)
    ) {
        Column(
            Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_market_outlook),
                contentDescription = ""
            )
            Text(
                "Propertio.com Indonesia Property Market Outlook 2023",
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.surface,
                    contentColor = MaterialTheme.colors.primary
                ),
                contentPadding = PaddingValues(10.dp),
                elevation = ButtonDefaults.elevation(0.dp)
            ) {
                Text("Selengkapnya")
            }
        }
    }
}