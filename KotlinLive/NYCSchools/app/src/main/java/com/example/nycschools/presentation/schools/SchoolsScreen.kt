package com.example.nycschools.presentation.schools

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchoolsScreen(
    navController: NavController,
    viewModel: SchoolsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    LaunchedEffect(state.selectedSchool) {
        state.selectedSchool?.let { school ->
            navController.navigate("school_detail/${school.dbn}") {
                popUpTo("schools") { saveState = true }
                launchSingleTop = true
                restoreState = true
            }
            viewModel.clearSelectedSchool()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("NYC High Schools") }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when {
                state.isLoading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                state.error != null -> {
                    Text(
                        text = state.error,
                        modifier = Modifier.align(Alignment.Center),
                        color = MaterialTheme.colorScheme.error
                    )
                }
                else -> {
                    SchoolList(
                        schools = state.schools,
                        onSchoolClick = viewModel::onSchoolSelected
                    )
                }
            }
        }
    }
}

@Composable
fun SchoolList(
    schools: List<com.example.nycschools.data.model.School>,
    onSchoolClick: (com.example.nycschools.data.model.School) -> Unit
) {
    LazyColumn {
        items(schools) { school ->
            SchoolListItem(
                school = school,
                onClick = { onSchoolClick(school) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchoolListItem(
    school: com.example.nycschools.data.model.School,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.padding(8.dp)
    ) {
        androidx.compose.material3.ListItem(
            headlineText = {
                Text(
                    text = school.schoolName,
                    fontWeight = FontWeight.Bold
                )
            },
            supportingText = {
                school.location?.let { location ->
                    Text(text = location)
                }
            }
        )
    }
}