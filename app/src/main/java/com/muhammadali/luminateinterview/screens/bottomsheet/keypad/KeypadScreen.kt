package com.muhammadali.luminateinterview.screens.bottomsheet.keypad

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhammadali.luminateinterview.R
import com.muhammadali.luminateinterview.screens.bottomsheet.keypad.components.Keypad

@Composable
fun KeypadScreen(modifier: Modifier = Modifier) {
    KeypadScreenContent()
}

@Composable
fun KeypadScreenContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Spacer(modifier = Modifier.height(1.dp))

        // Add Contact Icon
        IconButton(
            modifier = Modifier.align(Alignment.Start),
            onClick = {}
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "18349 549 123",
            fontSize = 40.sp
        )

        Text(
            "Naainz",
            fontSize = 22.sp,
            color = Color(0xFF555555)
        )

        // Keypad buttons
        Keypad(
            onNumberClick = {},
            onCallClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun KeypadScreenPreview() {
    KeypadScreenContent()
}