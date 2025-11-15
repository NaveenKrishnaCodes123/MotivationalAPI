package com.nycschools

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nycschools.data.local.AppDatabase
import com.nycschools.data.repository.SchoolRepositoryImpl
import com.nycschools.di.ServiceLocator
import com.nycschools.domain.usecase.GetSchoolsUseCase
import com.nycschools.presentation.screen.SchoolDetailScreen
import com.nycschools.presentation.screen.SchoolListScreen
import com.nycschools.presentation.viewmodel.SchoolDetailViewModel
import com.nycschools.presentation.viewmodel.SchoolListViewModel
import com.nycschools.ui.theme.NYCSchoolsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize database, repository, and viewmodels
        val db = AppDatabase.getInstance(applicationContext)
        val repo = SchoolRepositoryImpl(ServiceLocator.api, db.schoolDao())
        val listVm = SchoolListViewModel(GetSchoolsUseCase(repo))
        val detailVm = SchoolDetailViewModel(repo)

        setContent {
            NYCSchoolsTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "list") {

                        // List screen
                        composable("list") {
                            SchoolListScreen(
                                viewModel = listVm,
                                onSchoolClick = { dbn ->
                                    navController.navigate("detail/$dbn")
                                }
                            )
                        }

                        // Detail screen
                        composable(
                            route = "detail/{dbn}",
                            arguments = listOf(navArgument("dbn") { type = NavType.StringType })
                        ) { backStack ->
                            val dbn = backStack.arguments?.getString("dbn") ?: ""
                            SchoolDetailScreen(
                                viewModel = detailVm,
                                dbn = dbn,
                                onBackClick = { navController.popBackStack() } // Handle back
                            )
                        }
                    }
                }
            }
        }
    }
}
