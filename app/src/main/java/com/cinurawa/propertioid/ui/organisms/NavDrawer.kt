package com.cinurawa.propertioid.ui.organisms

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import com.cinurawa.propertioid.ui.model.MenuItem
import com.cinurawa.propertioid.ui.navigation.Screen

val menuItems = listOf(
    MenuItem(
        title = Screen.Home.route,
        icon = Icons.Default.Home
    ),
    MenuItem(
        title = Screen.Properti.route,
        icon = Icons.Default.Favorite
    ),
    MenuItem(
        title = Screen.Project.route,
        icon = Icons.Default.AccountCircle
    ),
    MenuItem(
        title = Screen.Agent.route,
        icon = Icons.Default.AccountCircle
    ),
    MenuItem(
        title = Screen.Developer.route,
        icon = Icons.Default.AccountCircle
    ),
)

@Composable
fun NavDrawer(
    modifier: Modifier = Modifier,
    onItemSelected: (title: String) -> Unit,
    onBackPress: () -> Unit,
) {

    Column(modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .height(19.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colors.primary)
        )
        for (item in menuItems) {
            Column(
                modifier = Modifier
                    .clickable { onItemSelected(item.title) }
                    .padding(vertical = 12.dp, horizontal = 16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = item.title, style = MaterialTheme.typography.subtitle2)
                Divider()
            }
        }
        Divider()
    }
    BackPressHandler {
        onBackPress()
    }
}


@Composable
fun BackPressHandler(enabled: Boolean = true, onBackPressed: () -> Unit) {
    val currentOnBackPressed by rememberUpdatedState(onBackPressed)
    val backCallback = remember {
        object : OnBackPressedCallback(enabled) {
            override fun handleOnBackPressed() {
                currentOnBackPressed()
            }
        }
    }
    SideEffect {
        backCallback.isEnabled = enabled
    }
    val backDispatcher = checkNotNull(LocalOnBackPressedDispatcherOwner.current) {
        "No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner"
    }.onBackPressedDispatcher
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner, backDispatcher) {
        backDispatcher.addCallback(lifecycleOwner, backCallback)
        onDispose {
            backCallback.remove()
        }
    }
}