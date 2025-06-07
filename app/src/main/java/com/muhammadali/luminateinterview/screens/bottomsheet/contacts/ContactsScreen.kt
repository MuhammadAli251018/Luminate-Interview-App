package com.muhammadali.luminateinterview.screens.bottomsheet.contacts

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.muhammadali.luminateinterview.R
import com.muhammadali.luminateinterview.screens.bottomsheet.common.ListScreenScaffold
import com.muhammadali.luminateinterview.screens.bottomsheet.common.Tag
import com.muhammadali.luminateinterview.screens.bottomsheet.contacts.components.Contact
import com.muhammadali.luminateinterview.screens.bottomsheet.contacts.components.ContactItem

@Composable
fun ContactsScreen(onNavigateToDetails: () -> Unit = {}) {
    ContactsScreenContent(
        onNavigateToDetails = onNavigateToDetails
    )
}

val contacts = listOf(
    Contact(
        name = "Daniel",
        isFavourite = true,
        status = ContactsTags.Favourite,
        number = "+1 (170) 305-9410",
        imageRes = R.drawable.ic_launcher_background
    ),
    Contact(
        name = "Mom",
        isFavourite = true,
        status = ContactsTags.Favourite,
        number = "+1 (522) 255-3813",
        imageRes = R.drawable.ic_launcher_background
    ),
    Contact(
        name = "Dad",
        isFavourite = true,
        status = ContactsTags.Favourite,
        number = "+1 (510) 852-4947",
        imageRes = R.drawable.ic_launcher_background
    ),
    Contact(
        name = "Alex",
        isFavourite = true,
        status = ContactsTags.Favourite,
        number = "+1 (767) 175-5999",
        imageRes = R.drawable.ic_launcher_background
    )
)

sealed class ContactsTags(override val tag: String) : Tag {
    data object All : ContactsTags(tag = "All")
    data object Favourite : ContactsTags(tag = "Favourite")
    data object Blocked : ContactsTags(tag = "Blocked")

    companion object {
        val entries: List<ContactsTags> by lazy { listOf(All, Favourite, Blocked) }
    }
}

@Composable
fun ContactsScreenContent(
    onNavigateToDetails: () -> Unit = {}
) {
    var selectedTagIndex by remember { mutableIntStateOf(0) }

    ListScreenScaffold(
        modifier = Modifier,
        title = "Contacts",
        tags = ContactsTags.entries,
        onTagClick = { selectedTagIndex = it },
        selectedTagIndex = selectedTagIndex
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(contacts) { contact ->
                ContactItem(contact) {
                    onNavigateToDetails()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactsScreenPreview() {
    ContactsScreen()
}