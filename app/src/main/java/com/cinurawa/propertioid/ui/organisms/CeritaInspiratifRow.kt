package com.cinurawa.propertioid.ui.organisms

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cinurawa.propertioid.ui.theme.Blue700
import com.cinurawa.propertioid.ui.theme.DarkBlue500

@Composable
fun CeritaInspiratifRow(

) {
    Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            elevation = 0.dp,
            backgroundColor = DarkBlue500,
            shape = RoundedCornerShape(14.dp)
        ) {
            Column(
                Modifier.padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    "Baca cerita inspiratif para pencari hunian",
                    color = MaterialTheme.colors.onPrimary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.surface,
                        contentColor = DarkBlue500
                    ),
                    contentPadding = PaddingValues(10.dp),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {
                    Text("Cerita Rumah")
                }
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            elevation = 0.dp,
            backgroundColor = Blue700,
            shape = RoundedCornerShape(14.dp)
        ) {
            Column(
                Modifier.padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    "Simak sentimen pencari hunian di Indonesia",
                    color = MaterialTheme.colors.onPrimary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.surface,
                        contentColor = Blue700
                    ),
                    contentPadding = PaddingValues(10.dp),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {
                    Text("CSS H2 2022")
                }
            }
        }

    }
}