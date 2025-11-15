package com.nycschools.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nycschools.presentation.viewmodel.SchoolDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchoolDetailScreen(
    viewModel: SchoolDetailViewModel,
    dbn: String,
    onBackClick: () -> Unit
) {
    // Trigger load on first launch
    LaunchedEffect(dbn) { viewModel.load(dbn) }

    val schoolState = viewModel.uiState.collectAsState()
    val school = schoolState.value

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("School Details") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onPrimary

                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            if (school == null) {
                // Loading indicator
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = MaterialTheme.colorScheme.primary
                )
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    item {
                        // School Name
                        Text(
                            text = school.name,
                            style = MaterialTheme.typography.headlineSmall.copy(fontSize = 24.sp),
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                    item {
                        // General Info Card
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(text = "Borough: ${school.borough ?: "-"}", style = MaterialTheme.typography.bodyMedium)
                                Text(text = "Phone: ${school.phone ?: "-"}", style = MaterialTheme.typography.bodyMedium)
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(text = "Overview:", style = MaterialTheme.typography.titleMedium)
                                Text(text = school.overview ?: "-", style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    item {
                        // SAT Scores Card
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    text = "SAT Scores",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(text = "Number of Takers: ${school.satNumOfTakers ?: "-"}")
                                Spacer(modifier = Modifier.height(4.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text = "Reading: ${school.satReading ?: "-"}")
                                    Text(text = "Math: ${school.satMath ?: "-"}")
                                    Text(text = "Writing: ${school.satWriting ?: "-"}")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
