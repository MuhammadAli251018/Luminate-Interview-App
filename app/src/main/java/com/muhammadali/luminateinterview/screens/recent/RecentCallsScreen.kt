package com.muhammadali.luminateinterview.screens.recent

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun RecentCallsScreen(modifier: Modifier = Modifier) {
    RecentCallsScreenContent()
}

@Composable
fun RecentCallsScreenContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Recent Screen"
        )
    }
}

@Composable
fun RecentCallsScreenPreview() {

}