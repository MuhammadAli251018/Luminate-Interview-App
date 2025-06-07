package com.muhammadali.luminateinterview.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.muhammadali.luminateinterview.R

@Composable
fun MainScreenBottomBar(
    modifier: Modifier = Modifier,
    screens: List<BottomBarNavScreen>,
    onClick: (BottomBarNavScreen) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        screens.forEachIndexed { index, screen ->
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val (name, icon) = screen.getScreenNameAndIcon()
                IconButton(
                    modifier = Modifier.size(30.dp),
                    onClick = { onClick(screens[index]) }
                ) {
                    Icon(
                        modifier = Modifier.size(28.dp),
                        painter = painterResource(icon),
                        contentDescription = null
                    )
                }

                Text(name)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenBottomBarPreview() {
    MainScreenBottomBar(
        modifier = Modifier,
        screens = listOf(BottomBarNavScreen.RecentCalls, BottomBarNavScreen.Keypad, BottomBarNavScreen.Contacts)
    ) { }
}