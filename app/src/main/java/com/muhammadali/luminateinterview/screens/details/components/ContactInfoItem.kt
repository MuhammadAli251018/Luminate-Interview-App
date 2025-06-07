package com.muhammadali.luminateinterview.screens.details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhammadali.luminateinterview.screens.details.ContactInfo

enum class ContactInfoPosition {
    START,
    MIDDLE,
    END
}

infix fun Int.indexPosition(size: Int) = when {
    this == 0 -> ContactInfoPosition.START
    this == size -1 -> ContactInfoPosition.END
    else -> ContactInfoPosition.MIDDLE
}

fun ContactInfoPosition.getShape(round: Dp) = when(this) {
    ContactInfoPosition.START -> RoundedCornerShape(topStart = round, topEnd = round)
    ContactInfoPosition.MIDDLE -> RectangleShape
    ContactInfoPosition.END -> RoundedCornerShape(bottomEnd = round, bottomStart = round)
}

val ContactInfo.name
    get() = when (this) {
        is ContactInfo.Name -> "Name"
        is ContactInfo.Number -> "Mobile"
        is ContactInfo.Email -> "Email"
        is ContactInfo.Birthday -> "Birthday"
        is ContactInfo.Address -> "Address"
}

@Composable
fun ContactInfoItem(
    contactInfoPosition: ContactInfoPosition,
    contactInfo: ContactInfo
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        shape = contactInfoPosition.getShape(20.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .padding(vertical = 5.dp, horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(40.dp),
                painter = painterResource(contactInfo.resource),
                contentDescription = null
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = contactInfo.name,
                    color = Color.Black,
                    fontSize = 18.sp
                )

                Text(
                    text = contactInfo.data,
                    color = Color.Gray,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactInfoPreview() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 100.dp),
    ){
        ContactInfoItem(
            contactInfoPosition = ContactInfoPosition.START,
            contactInfo = ContactInfo.Number(
                data = "+1 (255) 052-7031"
            )
        )

        HorizontalDivider(
            Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.Gray
        )

        ContactInfoItem(
            contactInfoPosition = ContactInfoPosition.MIDDLE,
            contactInfo = ContactInfo.Email(
                data = "alex.johnson89@mail.com"
            )
        )

        HorizontalDivider(
            Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.Gray
        )

        ContactInfoItem(
            contactInfoPosition = ContactInfoPosition.END,
            contactInfo = ContactInfo.Birthday(
                data = "March 14, 1995"
            )
        )
    }
}