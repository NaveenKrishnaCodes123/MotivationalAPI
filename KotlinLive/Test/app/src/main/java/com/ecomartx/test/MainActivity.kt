package com.ecomartx.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyLazyList()
        }
    }
}
@Preview
@Composable
fun MyLazyList() {
    val items = remember { mutableStateListOf<String>() }

    // Add items gradually with delay
    LaunchedEffect(Unit) {
        for (i in 1..10) {
            delay(2000) // wait 0.5 seconds before adding each item
            items.add("Item $i")
        }
    }

    LazyColumn {
        // Heading
        item {
            Text(
                text = "HEADING",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(14.dp),
                textAlign = TextAlign.Center
            )
        }

        // Show list items as they are added
        items(items.size) { index ->
            ShowDataInListView(items[index])
        }
    }
}

@Composable
private fun ShowDataInListView(value: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Text(
                text = "Content for $value",
                color = Color.Black,
                modifier = Modifier
                    .padding(14.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

