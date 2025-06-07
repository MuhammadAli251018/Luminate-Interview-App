package com.muhammadali.luminateinterview.screens.recent

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.muhammadali.luminateinterview.R
import com.muhammadali.luminateinterview.screens.common.ListScreenScaffold
import com.muhammadali.luminateinterview.screens.common.TagState
import com.muhammadali.luminateinterview.screens.recent.components.Call
import com.muhammadali.luminateinterview.screens.recent.components.CallItem

@Composable
fun RecentCallsScreen(modifier: Modifier = Modifier) {
    RecentCallsScreenContent(calls)
}


private val tags = listOf(
    TagState("Incoming", true),
    TagState("Missed", false),
    TagState("Outgoing", false),
    TagState("Blocked", false)
)

private val calls = listOf(
    Call(
        name = "Alex",
        status = "Answered",
        time = "14:45",
        imageRes = R.drawable.ic_launcher_background
    ),
    Call(
        name = "Alex",
        status = "Missed",
        time = "14:44",
        imageRes = R.drawable.ic_launcher_background
    ),
    Call(
        name = "John",
        status = "Missed",
        time = "13:32",
        imageRes = R.drawable.ic_launcher_background
    ),
    Call(
        name = "Dad",
        status = "Missed",
        time = "11:58",
        imageRes = R.drawable.ic_launcher_background
    ),
    Call(
        name = "+1 (776) 853-6598",
        status = "Answered",
        time = "Yesterday",
        imageRes = R.drawable.ic_launcher_background
    ),
    Call(
        name = "Mom",
        status = "Missed",
        time = "Yesterday",
        imageRes = R.drawable.ic_launcher_background
    )
)

@Composable
fun RecentCallsScreenContent(
    calls: List<Call>
) {
    ListScreenScaffold(
        modifier = Modifier,
        title = "Recent",
        tags = tags,
        onTagClick = {  }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(calls) { call ->
                CallItem(call)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecentCallsScreenPreview() {
    RecentCallsScreen()
}