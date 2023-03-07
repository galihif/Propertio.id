package com.cinurawa.propertioid.ui.utils

import android.content.Context
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class NavDrawerState(
    val scaffoldState: ScaffoldState,
    private val scope: CoroutineScope,
    private val context: Context
) {
    fun onMenuClick() {
        scope.launch {
            scaffoldState.drawerState.open()
        }
    }
    fun onItemSelected() {
        scope.launch {
            scaffoldState.drawerState.close()
        }
    }
    fun onBackPress() {
        if (scaffoldState.drawerState.isOpen) {
            scope.launch {
                scaffoldState.drawerState.close()
            }
        }
    }

}

@Composable
fun rememberNavDrawerState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    coroutinesScope: CoroutineScope = rememberCoroutineScope(),
    context: Context = LocalContext.current
): NavDrawerState =
    remember(scaffoldState, coroutinesScope, context) {
        NavDrawerState(scaffoldState, coroutinesScope, context)
    }
