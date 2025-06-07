package com.muhammadali.luminateinterview.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.muhammadali.luminateinterview.R
import com.muhammadali.luminateinterview.screens.bottomsheet.contacts.ContactsScreen
import com.muhammadali.luminateinterview.screens.bottomsheet.keypad.KeypadScreen
import com.muhammadali.luminateinterview.screens.bottomsheet.recent.RecentCallsScreen
import kotlinx.serialization.Serializable

@Serializable
sealed class BottomBarNavScreen {
    companion object {
        val screens = listOf(
            BottomBarNavScreen.RecentCalls,
            BottomBarNavScreen.Keypad,
            BottomBarNavScreen.Contacts
        )
    }
    @Serializable
    data object Keypad : BottomBarNavScreen()
    @Serializable
    data object RecentCalls : BottomBarNavScreen()
    @Serializable
    data object Contacts : BottomBarNavScreen()
}

fun BottomBarNavScreen.getScreenNameAndIcon() = when(this) {
    BottomBarNavScreen.Contacts -> Pair("Contacts", R.drawable.ic_launcher_foreground)
    BottomBarNavScreen.Keypad -> Pair("Keypad", R.drawable.ic_launcher_foreground)
    BottomBarNavScreen.RecentCalls -> Pair("Resents", R.drawable.ic_launcher_foreground)
}


@Composable
fun BottomBarNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onNavigateToDetails: () -> Unit
) {

    NavHost(navController = navController, startDestination = BottomBarNavScreen.Keypad) {
        composable<BottomBarNavScreen.Keypad> {
            KeypadScreen(modifier = modifier)
        }

        composable<BottomBarNavScreen.RecentCalls> {
            RecentCallsScreen()
        }

        composable<BottomBarNavScreen.Contacts> {
            ContactsScreen(onNavigateToDetails)
        }
    }
}