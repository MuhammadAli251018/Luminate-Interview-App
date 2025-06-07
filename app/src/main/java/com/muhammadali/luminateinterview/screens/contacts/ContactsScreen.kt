package com.muhammadali.luminateinterview.screens.contacts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.muhammadali.luminateinterview.screens.common.ListScreenScaffold
import com.muhammadali.luminateinterview.screens.common.Tag

@Composable
fun ContactsScreen(modifier: Modifier = Modifier) {
    ContactsScreenContent()
}

enum class ContactsTags(override val tag: String) : Tag {
    ALL(tag = "All"),
    FAVOURITE(tag = "Favourite"),
    BLOCKED(tag = "Blocked")
}

@Composable
fun ContactsScreenContent() {
    var selectedTagIndex by remember { mutableIntStateOf(0) }

    ListScreenScaffold(
        modifier = Modifier,
        title = "Contacts",
        tags = ContactsTags.entries,
        onTagClick = { selectedTagIndex = it },
        selectedTagIndex = selectedTagIndex
    ) {

    }
}

@Composable
fun ContactsScreenPreview() {
    ContactsScreen()
}