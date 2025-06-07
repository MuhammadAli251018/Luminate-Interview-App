package com.muhammadali.luminateinterview.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.muhammadali.luminateinterview.MainScreen
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
            MainScreen(
                appNavController = navController
            )
        }

        composable<AppNavScreen.ContactDetail> {
            DetailsScreen()
        }
    }
}