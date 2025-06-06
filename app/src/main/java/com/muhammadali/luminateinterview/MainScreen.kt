package com.muhammadali.luminateinterview

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.muhammadali.luminateinterview.navigation.BottomBarNavHost
import com.muhammadali.luminateinterview.navigation.BottomBarNavScreen
import com.muhammadali.luminateinterview.navigation.MainScreenBottomBar

@Composable
fun MainScreen() {
    val bottomBarNavController = rememberNavController()
    MainScreenContent(
        navController = bottomBarNavController,
        screens = BottomBarNavScreen.screens
    )
}

@Composable
fun MainScreenContent(
    navController: NavHostController,
    screens: List<BottomBarNavScreen>
) {
    Scaffold(
        bottomBar = {
            MainScreenBottomBar(screens = screens) { screen ->
                navController.navigate(screen)
            }
        }
    ) {
        BottomBarNavHost(
            modifier = Modifier.padding(it),
            navController = navController
        )
    }
}


@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}