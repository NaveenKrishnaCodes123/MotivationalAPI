
package com.test.nyc.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.test.nyc.ui.screens.SchoolsListScreen
import com.test.nyc.ui.screens.SchoolDetailScreen

sealed class Destinations(val route: String) {
    object LIST : Destinations("schools_list")
    object DETAIL : Destinations("school_detail")
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destinations.LIST.route
    ) {
        composable(Destinations.LIST.route) {
            SchoolsListScreen(
                onClickItem = { dbn ->
                    navController.navigate("${Destinations.DETAIL.route}/$dbn")
                }
            )
        }
        composable(route = "${Destinations.DETAIL.route}/{dbn}") { backStackEntry ->
            val dbn = backStackEntry.arguments?.getString("dbn") ?: ""
            SchoolDetailScreen(
                dbn = dbn,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
