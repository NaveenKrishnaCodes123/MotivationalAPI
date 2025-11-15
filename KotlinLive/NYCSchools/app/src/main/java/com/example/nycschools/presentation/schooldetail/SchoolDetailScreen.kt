package com.example.nycschools.presentation.schooldetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchoolDetailScreen(
    navController: NavController,
    viewModel: SchoolDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(state.school.schoolName) },
                navigationIcon = {
                    androidx.compose.material3.IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        androidx.compose.material3.Icon(
                            imageVector = androidx.compose.material.icons.Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else {
                SchoolDetailContent(state = state)
            }
        }
    }
}

@Composable
fun SchoolDetailContent(state: SchoolDetailState) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // School Information
        Card(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "School Information",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                InfoRow("Location", state.school.location)
                InfoRow("Phone", state.school.phoneNumber)
                InfoRow("Email", state.school.email)
                InfoRow("Website", state.school.website)
                InfoRow("Total Students", state.school.totalStudents)
                InfoRow("Graduation Rate", state.school.graduationRate)
                InfoRow("Attendance Rate", state.school.attendanceRate)

                state.school.overview?.let { overview ->
                    Text(
                        text = "Overview:",
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = overview)
                }
            }
        }

        // SAT Scores
        state.satScores?.let { satScores ->
            Card {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "SAT Scores",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )

                    InfoRow("Test Takers", satScores.testTakers)
                    InfoRow("Math Score", satScores.mathScore)
                    InfoRow("Reading Score", satScores.readingScore)
                    InfoRow("Writing Score", satScores.writingScore)
                }
            }
        } ?: run {
            Card {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No SAT scores available for this school")
                }
            }
        }
    }
}

@Composable
fun InfoRow(label: String, value: String?) {
    if (value != null) {
        Column {
            Text(
                text = "$label:",
                fontWeight = FontWeight.Bold
            )
            Text(text = value)
        }
    }
}