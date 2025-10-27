package com.ecomartx.dependencyinjection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ecomartx.dependencyinjection.Model.MotivationalPhrase
import com.ecomartx.dependencyinjection.ViewModel.MotivationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MotivationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MotivationScreen(viewModel)
        }
    }
}

@Composable
fun MotivationScreen(viewModel: MotivationViewModel) {
    val quotes by viewModel.quotes.collectAsStateWithLifecycle()

    LazyColumn {
        items(quotes) { quote ->
            QuoteCard(quote)
        }
    }
}

@Composable
fun QuoteCard(quote: MotivationalPhrase) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(
                text = quote.phrase,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "- ${quote.author}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
