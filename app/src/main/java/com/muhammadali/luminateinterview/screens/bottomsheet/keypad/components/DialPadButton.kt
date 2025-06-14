package com.muhammadali.luminateinterview.screens.bottomsheet.keypad.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class DialPadButtonData(
    val number: String,
    val ituString: String,
)

@Composable
fun DialPadButton(
    modifier: Modifier = Modifier,
    data: DialPadButtonData,
    onClick: () -> Unit
) {
    DialPadButton(
        modifier = modifier,
        number = data.number,
        ituString = data.ituString,
        onClick = onClick
    )
}

@Composable
fun DialPadButton(
    modifier: Modifier = Modifier,
    number: String,
    ituString: String,
    onClick: () -> Unit
) {
    val bgGradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFFEFEFEF),
            Color(0xFFD9D9D9)
        ),
        start = Offset(0f, 0f),
        end = Offset(1000f, 1000f)
    )

    Column (
        modifier = modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(brush = bgGradient, shape = CircleShape)
            .clickable(onClick = onClick)
            .border(width = 1.dp, color = Color(0xFFF9FAFB), shape = CircleShape)
            .shadow(
                elevation = 24.dp,
                shape = CircleShape,
                ambientColor = Color.Black.copy(alpha = 0.25f),
                spotColor = Color.Black.copy(alpha = 0.25f)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(Modifier.height(if (ituString.isNotEmpty()) 15.dp else 25.dp))

        Text(
            text = number,
            color = Color.Black,
            fontSize = 22.sp,
        )

        if (ituString.isNotEmpty()) {
            Text(
                text = ituString,
                color = Color(0xFF555555),
                fontSize = 12.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun KeypadButtonPreview() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        DialPadButton(number = "2", ituString = "ABC", onClick = {}) }
}
