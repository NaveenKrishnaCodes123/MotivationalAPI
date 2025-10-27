
package com.test.nyc.ui.screens

import com.test.nyc.ui.viewmodel.SchoolsViewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.test.nyc.domain.model.School

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun SchoolsListScreen(
    onClickItem: (String) -> Unit,
    viewModel: SchoolsViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Header
        Text(
            text = "Schools",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        // Search Section
        SearchSection(
            searchQuery = state.query,
            onSearchQueryChanged = viewModel::onQueryChanged
        )

        // Schools List
        if (state.isLoading) {
            LoadingIndicator()
        } else {
            SchoolsList(
                schools = state.items,
                onClickItem = onClickItem
            )
        }

        // Bottom Navigation
        BottomNavigationSection()
    }
}

@Composable
private fun SearchSection(
    searchQuery: String,
    onSearchQueryChanged: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        // Checkbox Row
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = false,
                onCheckedChange = null,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Black,
                    uncheckedColor = Color.Gray
                )
            )
            Text(
                text = "Search schools",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        // Search Text Field
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChanged,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            placeholder = { Text("Search...") },
            singleLine = true
        )

        // Divider
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            color = Color.LightGray,
            thickness = 1.dp
        )
    }
}

@Composable
private fun SchoolsList(
    schools: List<School>,
    onClickItem: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(schools, key = { it.dbn }) { school ->
            SchoolRow(
                school = school,
                onClick = { onClickItem(school.dbn) }
            )
            Divider(
                color = Color.LightGray,
                thickness = 0.5.dp
            )
        }
    }
}

@Composable
private fun SchoolRow(
    school: School,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        Text(
            text = school.schoolName,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Public · ${school.finalGrades ?: "9-12"}",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
private fun LoadingIndicator() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun BottomNavigationSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray.copy(alpha = 0.2f))
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "Schools",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "Map",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
        Text(
            text = "Favorites",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SchoolsListScreenPreview() {
    MaterialTheme {
        SchoolsListScreen(onClickItem = {})
    }
}
