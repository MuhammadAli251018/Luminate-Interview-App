package com.muhammadali.luminateinterview

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.muhammadali.luminateinterview.navigation.AppNavScreen
import com.muhammadali.luminateinterview.navigation.BottomBarNavHost
import com.muhammadali.luminateinterview.navigation.BottomBarNavScreen
import com.muhammadali.luminateinterview.navigation.MainScreenBottomBar

@Composable
fun MainScreen(
    appNavController: NavHostController,
) {
    val bottomBarNavController = rememberNavController()

    MainScreenContent(
        modifier = Modifier,
        navController = bottomBarNavController,
        screens = BottomBarNavScreen.screens,
        onNavigateToDetails = {
            appNavController.navigate(AppNavScreen.ContactDetail)
        }
    )
}

@Composable
fun MainScreenContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    screens: List<BottomBarNavScreen>,
    onNavigateToDetails: () -> Unit
) {
    Scaffold(
        modifier = modifier.systemBarsPadding(),
        bottomBar = {
            MainScreenBottomBar(screens = screens) { screen ->
                navController.navigate(screen)
            }
        }
    ) {
        BottomBarNavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            onNavigateToDetails = onNavigateToDetails
        )
    }
}


@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(rememberNavController())
}