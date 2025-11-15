package com.example.nycschools.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.nycschools.data.model.School
import com.example.nycschools.presentation.schooldetail.SchoolDetailScreen
import com.example.nycschools.presentation.schools.SchoolsScreen

sealed class Screen(val route: String) {
    object Schools : Screen("schools")
    object SchoolDetail : Screen("school_detail/{school}")
}

fun NavGraphBuilder.appNavGraph(navController: NavController) {
    navigation(
        startDestination = Screen.Schools.route,
        route = "root"
    ) {
        composable(Screen.Schools.route) {
            SchoolsScreen(navController = navController)
        }
        composable(
            route = Screen.SchoolDetail.route,
            arguments = listOf(
                navArgument("school") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            SchoolDetailScreen(navController = navController)
        }
    }
}