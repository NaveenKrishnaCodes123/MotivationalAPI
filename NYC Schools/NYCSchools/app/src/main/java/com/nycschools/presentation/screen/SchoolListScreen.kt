package com.nycschools.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nycschools.presentation.viewmodel.SchoolListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchoolListScreen(viewModel: SchoolListViewModel, onSchoolClick: (String) -> Unit) {
    val schoolsState = viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "NYC Schools") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(schoolsState.value) { school ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onSchoolClick(school.dbn) },
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = school.name,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Borough: ${school.borough ?: "-"}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Phone: ${school.phone ?: "-"}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        school.satNumOfTakers?.let {
                            Text(
                                text = "SAT Takers: $it",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Reading: ${school.satReading ?: "-"}",
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                text = "Math: ${school.satMath ?: "-"}",
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                text = "Writing: ${school.satWriting ?: "-"}",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
        }
    }
}
