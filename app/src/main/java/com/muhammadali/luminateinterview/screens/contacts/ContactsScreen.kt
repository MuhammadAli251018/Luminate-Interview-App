package com.muhammadali.luminateinterview.screens.contacts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.muhammadali.luminateinterview.screens.common.ListScreenScaffold
import com.muhammadali.luminateinterview.screens.common.TagState

@Composable
fun ContactsScreen(modifier: Modifier = Modifier) {
    ContactsScreenContent()
}

private val tags = listOf(
    TagState("Favorites", true),
    TagState("All", false),
    TagState("Blocked", false)
)

@Composable
fun ContactsScreenContent() {
    ListScreenScaffold(
        modifier = Modifier,
        title = "Contacts",
        tags = tags,
        onTagClick = {  }
    ) {

    }
}

@Composable
fun ContactsScreenPreview() {

}