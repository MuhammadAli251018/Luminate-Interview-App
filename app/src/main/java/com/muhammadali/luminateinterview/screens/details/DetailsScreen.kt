package com.muhammadali.luminateinterview.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhammadali.luminateinterview.R
import com.muhammadali.luminateinterview.screens.details.components.ContactDetailsTopBar
import com.muhammadali.luminateinterview.screens.details.components.ContactInfoItem
import com.muhammadali.luminateinterview.screens.details.components.indexPosition

enum class ContactActions {
    VOICE_CALL,
    VIDEO_CALL,
    CHAT,
    CHANGE_NOTIFICATION;

    val resource: Int
        get() = when (this) {
            VOICE_CALL -> R.drawable.ic_voice_call
            VIDEO_CALL -> R.drawable.ic_video_call
            CHAT -> R.drawable.ic_chat
            CHANGE_NOTIFICATION -> R.drawable.ic_mute_notification
        }
}

sealed class ContactInfo {
    abstract val data: String
    data class Name(override val data: String) : ContactInfo()
    data class Number(override val data: String) : ContactInfo()
    data class Email(override val data: String) : ContactInfo()
    data class Birthday(override val data: String) : ContactInfo()
    data class Address(override val data: String) : ContactInfo()

    val resource: Int
        get() = when (this) {
            is Name -> R.drawable.ic_launcher_foreground
            is Number -> R.drawable.ic_voice_call
            is Email -> R.drawable.ic_email
            is Birthday -> R.drawable.ic_birthday
            is Address -> R.drawable.ic_location
        }
}

data class ContactData(
    val name: String,
    val number: String,
    val email: String?,
    val birthday: String?,
    val address: String?
) {
    fun getAsList(): List<ContactInfo> {
        val list = mutableListOf<ContactInfo>()
        list.add(ContactInfo.Number(number))

        if (email != null)
            list.add(ContactInfo.Email(email))
        if (birthday != null)
            list.add(ContactInfo.Birthday(birthday))
        if (address != null)
            list.add(ContactInfo.Address(address))

        return list
    }
}

@Composable
fun DetailsScreen(
    name: String = "Alex",
    number: String = "+1 (255) 052-7031",
    email: String = "alex.johnson89@mail.com",
    birthday: String = "March 14, 1995",
    address: String = "13 Elm Street, Springfield, IL 62704, USA",
    imageRes: Int = R.drawable.img_alex
) {
    Scaffold(
        modifier = Modifier
            .systemBarsPadding(),
        topBar = { ContactDetailsTopBar(
            name = name
        ) }
    ) {
        DetailsScreenContent(
            modifier = Modifier.padding(it),
            contactData = ContactData(
                name = name,
                number = number,
                email = email,
                birthday = birthday,
                address = address
            ),
            imageRes = imageRes
        )
    }
}

@Composable
fun DetailsScreenContent(
    modifier: Modifier = Modifier,
    contactData: ContactData,
    imageRes: Int
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            modifier = Modifier
                .size(130.dp)
                .clip(CircleShape),
            painter = painterResource(imageRes),
            contentDescription = null
        )

        Text(
            text = contactData.name,
            color = Color.Black,
            fontSize = 26.sp
        )

        Text(
            text = contactData.number,
            color = Color(0xFF555555),
            fontSize = 20.sp,
        )

        Row(
            Modifier,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            ContactActions.entries.forEach {
                Box(
                    modifier = Modifier
                        .size(65.dp)
                        .background(Color(0xFFF4F4F4), CircleShape)
                        .clip(shape = CircleShape),
                ) {
                    Icon(
                        modifier = Modifier
                            .size(23.dp)
                            .align(Alignment.Center),
                        painter = painterResource(it.resource),
                        contentDescription = null
                    )
                }
            }
        }

        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            contactData.getAsList().apply {
                forEachIndexed { index, info ->
                    ContactInfoItem(
                        contactInfoPosition = index indexPosition size,
                        contactInfo = info
                    )

                    if (index != lastIndex)
                        HorizontalDivider(
                            Modifier.fillMaxWidth(),
                            thickness = 1.dp,
                            color = Color.Gray
                        )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    DetailsScreen()
}