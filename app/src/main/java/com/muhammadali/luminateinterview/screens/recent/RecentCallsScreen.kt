package com.muhammadali.luminateinterview.screens.recent

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
import com.muhammadali.luminateinterview.screens.common.ListScreenScaffold
import com.muhammadali.luminateinterview.screens.common.Tag
import com.muhammadali.luminateinterview.screens.recent.components.Call
import com.muhammadali.luminateinterview.screens.recent.components.CallItem
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

@Composable
fun RecentCallsScreen(modifier: Modifier = Modifier) {
    RecentCallsScreenContent(calls)
}

sealed class CallStatus(override val tag: String) : Tag {
    data object Incoming : CallStatus(tag = "Incoming")
    data object Missed : CallStatus(tag = "Missed")
    data object Outgoing : CallStatus(tag = "Outgoing")
    data object Blocked : CallStatus(tag = "Blocked")
    data class Answered(val duration: Duration) : CallStatus(tag = "Answered")

    companion object {
        val entries by lazy { listOf(Incoming, Missed, Outgoing, Blocked, Answered(Duration.INFINITE)) }
    }
}

private val calls = listOf(
    Call(
        name = "Alex",
        status = CallStatus.Answered(duration = 2.minutes),
        time = "14:45",
        isFavourite = true,
        imageRes = R.drawable.ic_launcher_background
    ),
    Call(
        name = "Alex",
        status = CallStatus.Missed,
        time = "14:44",
        isFavourite = true,
        imageRes = R.drawable.ic_launcher_background
    ),
    Call(
        name = "John",
        status = CallStatus.Missed,
        time = "13:32",
        imageRes = R.drawable.ic_launcher_background
    ),
    Call(
        name = "Dad",
        status = CallStatus.Missed,
        time = "11:58",
        isFavourite = true,
        imageRes = R.drawable.ic_launcher_background
    ),
    Call(
        name = "+1 (776) 853-6598",
        status = CallStatus.Answered(duration = 5.minutes),
        time = "Yesterday",
        imageRes = R.drawable.ic_launcher_background
    ),
    Call(
        name = "Mom",
        status = CallStatus.Missed,
        time = "Yesterday",
        isFavourite = true,
        imageRes = R.drawable.ic_launcher_background
    )
)

@Composable
fun RecentCallsScreenContent(
    calls: List<Call>
) {
    var selectedTagIndex by remember { mutableIntStateOf(0) }

    ListScreenScaffold(
        modifier = Modifier,
        title = "Recent",
        tags = listOf(CallStatus.Incoming, CallStatus.Missed, CallStatus.Outgoing, CallStatus.Blocked),
        onTagClick = { selectedTagIndex = it },
        selectedTagIndex = selectedTagIndex
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