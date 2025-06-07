package com.muhammadali.luminateinterview.screens.recent.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhammadali.luminateinterview.R

data class Call(
    val name: String,
    val status: String,
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
                .size(50.dp)
        ){
            Image(
                painter = painterResource(id = call.imageRes),
                contentDescription = "Contact Image",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground), // Star icon
                contentDescription = "Favorite",
                modifier = Modifier
                    .size(25.dp)
                    .align(Alignment.TopEnd),
                tint = Color(0xFFFFD700)
            )

        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = call.name,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                if (call.name == "Alex" || call.name == "Dad") {

                }
            }
            Text(
                text = "${call.status} • ${call.time}",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }


        Text(
            text = call.time,
            fontSize = 12.sp,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CallList() {
    val calls = listOf(
        Call(
            "Alex", "Answered • 4 min", "14:45", imageRes = R.drawable.ic_launcher_background),
        Call(
            "Alex", "Missed", "14:44", imageRes = R.drawable.ic_launcher_background),
        Call("John", "Answered • 15 min", "13:32", imageRes = R.drawable.ic_launcher_background),
        Call("Dad", "Answered • 25 min", "13:10", imageRes = R.drawable.ic_launcher_background)
    )

    Column {
        calls.forEach { contact ->
            CallItem(call = contact)
        }
    }
}