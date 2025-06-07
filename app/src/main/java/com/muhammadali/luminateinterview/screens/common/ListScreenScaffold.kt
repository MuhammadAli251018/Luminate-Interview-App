package com.muhammadali.luminateinterview.screens.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhammadali.luminateinterview.R
import com.muhammadali.luminateinterview.ui.theme.LuminateInterviewTheme

private val tags = listOf(
    TagState("All", true),
    TagState("Favourite", false),
    TagState("Blocked", false),
)

@Composable
fun SearchBar() {
    var searchQuery by remember { mutableStateOf("") }

    TextField(
        shape = RoundedCornerShape(20.dp),
        value = searchQuery,
        onValueChange = { searchQuery = it },
        placeholder = { Text("Search for contacts") },
        leadingIcon = {
            Icon(
                modifier = Modifier.size(40.dp),
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Search Icon"
            )
        },
        colors = TextFieldDefaults.colors(

            unfocusedContainerColor = Color.LightGray.copy(alpha = 0.3f),
            focusedContainerColor = Color.LightGray.copy(alpha = 0.3f),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

@Composable
fun ListScreenScaffold(
    modifier: Modifier = Modifier,
    title: String,
    tags: List<TagState>,
    onTagClick: (Int) -> Unit,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(Modifier.height(20.dp))

        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.align(Alignment.CenterStart),
                text = title,
                fontSize = 30.sp
            )

            IconButton (
                modifier = Modifier.align(Alignment.CenterEnd),
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )
            }
        }

        SearchBar()

        LazyRow {
            itemsIndexed(tags) { index, tag ->
                Tag(
                    modifier = Modifier.padding(horizontal = 5.dp),
                    tag = tag,
                    onTagClick = { onTagClick(index) }
                )
            }
        }

        content()
    }
}

@Preview(showBackground = true)
@Composable
fun ListScreenScaffoldPreview() {
    LuminateInterviewTheme {
        ListScreenScaffold(
            title = "Test Screen",
            tags = tags,
            onTagClick = {},
            content = {
                Text("Screen Content")
            }
        )
    }
}
