package com.muhammadali.luminateinterview.screens.keypad.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.muhammadali.luminateinterview.R

data class KeypadButtons(
    val dialPadButtons: List<List<DialPadButtonData>>
)

private val dialPadButtons = listOf(
    listOf(
        DialPadButtonData("1", ""),
        DialPadButtonData("2", "ABC"),
        DialPadButtonData("3", "DEF")
    ),
    listOf(
        DialPadButtonData("4", "GHI"),
        DialPadButtonData("5", "JKL"),
        DialPadButtonData("6", "MNO")
    ),
    listOf(
        DialPadButtonData("7", "PQRS"),
        DialPadButtonData("8", "TUV"),
        DialPadButtonData("9", "WXYZ")
    ),
    listOf(
        DialPadButtonData("*", ""),
        DialPadButtonData("0", "+"),
        DialPadButtonData("#", "")
    )
)

@Composable
fun CallButton(
    modifier: Modifier = Modifier,
    icon: Painter,
    onClick: () -> Unit
) {

    val bgGradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFF5EA569),
            Color(0xFF0D3619)
        ),
        start = Offset(0f, 0f),
        end = Offset(1000f, 1000f)
    )

    val borderGradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFFFAFAFA),
            Color(0xFF666666)
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
            .border(width = 1.dp, brush = borderGradient, shape = CircleShape)
            .shadow(
                elevation = 95.dp,
                shape = CircleShape,
                true
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Composable
fun Keypad(
    onNumberClick: (String) -> Unit,
    onCallClick: () -> Unit
) {
    KeypadComponent(
        buttons = KeypadButtons(dialPadButtons),
        onNumberClick = onNumberClick,
        onCallClick = onCallClick
    )
}

@Composable
fun KeypadComponent(
    buttons: KeypadButtons,
    onNumberClick: (String) -> Unit,
    onCallClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        buttons.dialPadButtons.forEach { row ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                row.forEach { button ->
                    DialPadButton(
                        data = button,
                        onClick = { onNumberClick(button.number) }
                    )
                }
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CallButton(
                modifier = Modifier,
                icon = painterResource(R.drawable.ic_launcher_foreground),
                onClick = onCallClick
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun KeypadPreview() {
    Box (
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    { Keypad({}) { } }
}