package com.muhammadali.luminateinterview.screens.bottomsheet.keypad

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhammadali.luminateinterview.R
import com.muhammadali.luminateinterview.screens.bottomsheet.keypad.components.Keypad
import com.muhammadali.luminateinterview.ui.theme.Figtree


@Composable
fun KeypadScreen(modifier: Modifier = Modifier) {
    KeypadScreenContent()
}

@Composable
fun KeypadScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var number by remember { mutableStateOf("18349 549") }
        Spacer(modifier = Modifier.height(48.dp))

        // Add Contact Icon
        IconButton(
            modifier = Modifier.align(Alignment.Start),
            onClick = {}
        ) {
            Icon(
                modifier = Modifier.size(28.dp),
                painter = painterResource(R.drawable.ic_add_contact),
                contentDescription = null
            )
        }

        Spacer(modifier = Modifier.height(68.dp))

        Text(
            text = number,
            fontSize = 34.sp,
            fontStyle = TextStyle(
                fontFamily = Figtree.toFontFamily()).fontStyle,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "Naainz",
            fontSize = 20.sp,
            color = Color(0xFF555555)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Keypad(
            onNumberClick = {number += it},
            onCallClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun KeypadScreenPreview() {
    KeypadScreenContent()
}