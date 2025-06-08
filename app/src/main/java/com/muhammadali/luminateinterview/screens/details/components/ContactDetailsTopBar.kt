package com.muhammadali.luminateinterview.screens.details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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

@Composable
fun ContactDetailsTopBar(
    name: String
) {
    ContactDetailsTopBarContent(
        name = name,
        onBackClick = {  },
        onShareClick = {  },
        onMoreClick = {  }
    )
}

@Composable
fun ContactDetailsTopBarContent(
    name: String,
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .size(60.dp)
    ) {
        Row(
            modifier = Modifier.align(Alignment.CenterStart),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton( onBackClick ) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(R.drawable.ic_back),
                    contentDescription = null,
                    tint = Color(0xFF555555)
                )
            }

            Text(
                text = name,
                fontSize = 20.sp,
                color = Color.Black
            )
        }

        Row(
            modifier = Modifier.align(Alignment.CenterEnd),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton( onShareClick ) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(R.drawable.ic_share),
                    contentDescription = null,
                    tint = Color(0xFF555555)
                )
            }

            IconButton( onMoreClick ) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(R.drawable.ic_three_dots),
                    contentDescription = null,
                    tint = Color(0xFF555555)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactDetailsTopBarPreview() {
    ContactDetailsTopBar("Alex")
}