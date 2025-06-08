package com.muhammadali.luminateinterview.screens.bottomsheet.recent.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhammadali.luminateinterview.R
import com.muhammadali.luminateinterview.screens.bottomsheet.recent.CallStatus
import kotlin.time.Duration.Companion.minutes

data class Call(
    val name: String,
    val isFavourite: Boolean = false,
    val status: CallStatus,
    val time: String,
    val imageRes: Int
)

@Composable
fun CallItem(call: Call) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(55.dp)
        ){
            Image(
                painter = painterResource(id = call.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )

            if (call.isFavourite)
                Icon(
                    painter = painterResource(id = R.drawable.ic_favourite), // Star icon
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.TopEnd),
                    tint = Color(0xFFFFCC8F)
                )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = call.name,
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = call.status.tag + if(call.status is CallStatus.Answered) " • ${call.status.duration.inWholeMinutes} min" else "",
                fontSize = 18.sp,
                color = Color.Gray
            )
        }

        Text(
            text = call.time,
            fontSize = 18.sp,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CallList() {
    val calls = listOf(
        Call(
            name = "Alex",
            status = CallStatus.Answered(4.minutes),
            isFavourite = true,
            time = "14:45",
            imageRes = R.drawable.ic_launcher_background
        )
    )

    Column {
        calls.forEach { contact ->
            CallItem(call = contact)
        }
    }
}