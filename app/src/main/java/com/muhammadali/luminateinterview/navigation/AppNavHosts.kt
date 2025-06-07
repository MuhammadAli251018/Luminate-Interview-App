package com.muhammadali.luminateinterview.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.muhammadali.luminateinterview.MainScreen
import com.muhammadali.luminateinterview.screens.bottomsheet.keypad.KeypadScreen
import com.muhammadali.luminateinterview.screens.bottomsheet.recent.RecentCallsScreen
import com.muhammadali.luminateinterview.screens.details.DetailsScreen
import kotlinx.serialization.Serializable


@Serializable
sealed class AppNavScreen {
    companion object {
        val screens = listOf(
            MainScreen,
            ContactDetail
        )
    }
    @Serializable
    data object MainScreen : AppNavScreen()

    @Serializable
    data object ContactDetail : AppNavScreen()

}


@Composable
fun AppNavHost(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = AppNavScreen.MainScreen) {
        composable<AppNavScreen.MainScreen> {
            MainScreen()
        }

        composable<AppNavScreen.ContactDetail> {
            DetailsScreen()
        }
    }
}