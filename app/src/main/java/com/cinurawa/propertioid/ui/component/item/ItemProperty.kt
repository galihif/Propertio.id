package com.cinurawa.propertioid.ui.component.item

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cinurawa.propertioid.R
import com.cinurawa.propertioid.ui.theme.Blue500
import com.cinurawa.propertioid.ui.theme.Purple500
import com.cinurawa.propertioid.ui.theme.Red500
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun ItemProperty(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        ImageProp(modifier = Modifier.fillMaxWidth())
        Row(
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            DetailPropCard(title = "Rumah", icon = R.drawable.ic_house, color = Blue500)
            DetailPropCard(title = "Jual", icon = R.drawable.ic_sell, color = Red500)
            DetailPropCard(title = "SHM", icon = R.drawable.ic_shm, color = Purple500)
        }
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                text = "Rumah Mewah di Jalan Kebon Sirih",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Lorem ipsum dolor sit amet consectetur. Id viverra nec.",
                style = MaterialTheme.typography.body2
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Default.LocationOn, contentDescription = "", tint = Red500)
            Text(text = "Jalan Kebon Sirih, Jakarta Pusat", style = MaterialTheme.typography.body2)
        }
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            mainAxisSpacing = 14.dp,
            crossAxisSpacing = 14.dp
        ) {
            FacilPropCard(title = "2 Lantai", icon = Icons.Default.Home)
            FacilPropCard(title = "200 m2", icon = Icons.Default.Home)
            FacilPropCard(title = "100 m2", icon = Icons.Default.Home)
            FacilPropCard(title = "2 K. Tidur", icon = Icons.Default.Home)
            FacilPropCard(title = "2 K. Mandi", icon = Icons.Default.Home)
            FacilPropCard(title = "1 Garasi", icon = Icons.Default.Home)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = "Harga",
                    style = MaterialTheme.typography.body2
                )
                Text(
                    text = "Rp.500.000.000",
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.primary
                )
            }
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                shape = RoundedCornerShape(6.dp),
            ) {
                Text(
                    text = "Lihat Detail",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun ImageProp(modifier: Modifier = Modifier) {
    Box(modifier = modifier.wrapContentSize()) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(shape = RoundedCornerShape(10.dp)),
            painter = painterResource(id = R.drawable.home_banner),
            contentDescription = "",
            contentScale = ContentScale.Crop,
        )
        Card(
            shape = CircleShape,
            backgroundColor = MaterialTheme.colors.primary,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.star_white),
                contentDescription = "",
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Composable
fun DetailPropCard(
    title: String,
    @DrawableRes icon: Int,
    color: Color = MaterialTheme.colors.primary,
) {
    Card(
        shape = RoundedCornerShape(6.dp),
        elevation = 0.dp,
        backgroundColor = color.copy(alpha = 0.1f)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(24.dp)
                .padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = "",
            )
            Text(
                text = title,
                style = MaterialTheme.typography.body1,
                color = color,
                fontSize = 12.sp
            )
        }
    }
}


@Composable
fun FacilPropCard(
    title: String,
    icon: ImageVector,
    color: Color = Color.Gray,
) {
    Card(
        shape = RoundedCornerShape(6.dp),
        elevation = 0.dp,
        backgroundColor = color.copy(alpha = 0.1f)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(24.dp)
                .padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Icon(
                imageVector = icon, contentDescription = "",
                tint = color
            )
            Text(
                text = title,
                style = MaterialTheme.typography.body1,
                color = color,
                fontSize = 12.sp
            )
        }
    }
}