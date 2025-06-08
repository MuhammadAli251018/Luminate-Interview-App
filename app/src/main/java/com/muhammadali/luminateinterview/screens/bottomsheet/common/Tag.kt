package com.muhammadali.luminateinterview.screens.bottomsheet.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

interface Tag {
    val tag: String
}

@Composable
fun Tag(
    modifier: Modifier,
    tag: Tag,
    isSelected: Boolean,
    onTagClick: () -> Unit
) {
    Tag(
        modifier = modifier,
        tag = tag.tag,
        isSelected = isSelected,
        onTagClick = onTagClick
    )
}

@Composable
fun Tag(
    modifier: Modifier = Modifier,
    tag: String,
    isSelected: Boolean,
    onTagClick: () -> Unit
) {
    val borderGradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFFFAFAFA),
            Color(0xFF666666)
        ).run { if (isSelected) this else reversed() },
        start = Offset.Zero,
        end = Offset.Infinite
    )

    Box(
        modifier = modifier
            .height(40.dp)
            .background(
                color = Color(if (isSelected) 0xFF555555 else 0xFFF4F4F4),
                shape = RoundedCornerShape(25.dp)
            )
//            .border(width = 0.5f.dp, brush = borderGradient, shape = RoundedCornerShape(25.dp))
            .clip(RoundedCornerShape(25.dp))
            .clickable(onClick = onTagClick)
            .padding(horizontal = 8.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 10.dp),
            text = tag,
            color = if (isSelected) Color.White else Color.Black
        )
    }
}


@Preview
@Composable
fun TagPreview() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Tag(
            tag = "Sample Tag",
            onTagClick = {},
            isSelected = true
        )
    }

}