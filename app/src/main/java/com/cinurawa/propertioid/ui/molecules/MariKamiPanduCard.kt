package com.cinurawa.propertioid.ui.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cinurawa.propertioid.R

@Composable
fun MariKamiPanduCard(
    modifier: Modifier = Modifier
) {
    Card(
        modifier.wrapContentSize(),
        shape = RoundedCornerShape(10.dp),
        backgroundColor = MaterialTheme.colors.primary,
    ) {
        Column(
            Modifier.fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp)),
                painter = painterResource(id = R.drawable.home_banner),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier.padding(14.dp)
            ) {
                Text(
                    "Mari kami pandu ke rumah Impianmu",
                    color = MaterialTheme.colors.onPrimary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
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
}