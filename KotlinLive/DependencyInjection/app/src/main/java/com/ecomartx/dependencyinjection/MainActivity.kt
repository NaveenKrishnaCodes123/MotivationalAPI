package com.ecomartx.dependencyinjection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ecomartx.dependencyinjection.ui.theme.MovieAppTheme
import com.ecomartx.dependencyinjection.presentation.bookmarked_movies.BookmarkedMoviesScreen
import com.ecomartx.dependencyinjection.presentation.movie_detail.MovieDetailScreen
import com.ecomartx.dependencyinjection.presentation.movie_list.MovieListScreen
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.Modifier

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MovieAppNavigation()
                }
            }
        }
    }
}

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object MovieList : Screen("movie_list_screen", "Movies", Icons.Filled.Home)
    object MovieDetail : Screen("movie_detail_screen/{movieId}", "Detail", Icons.Filled.Home) // Detail screen doesn't need a bottom nav icon
    object BookmarkedMovies : Screen("bookmarked_movies_screen", "Bookmarks", Icons.Filled.Bookmark)
}

@Composable
fun MovieAppNavigation() {
    val navController = rememberNavController()
    val navItems = listOf(Screen.MovieList, Screen.BookmarkedMovies) // Only show MovieList and BookmarkedMovies in bottom nav

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                navItems.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(screen.label) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting previously selected item
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.MovieList.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.MovieList.route) {
                MovieListScreen(navController = navController)
            }
            composable(
                Screen.MovieDetail.route,
                arguments = listOf(navArgument("movieId") { type = NavType.StringType })
            ) { backStackEntry ->
                MovieDetailScreen(
                    navController = navController,
                    movieId = backStackEntry.arguments?.getString("movieId")
                )
            }
            composable(Screen.BookmarkedMovies.route) {
                BookmarkedMoviesScreen(navController = navController)
            }
        }
    }
}
