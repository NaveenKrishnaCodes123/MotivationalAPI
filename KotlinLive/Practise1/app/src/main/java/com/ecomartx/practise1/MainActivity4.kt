package com.ecomartx.practise1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.delay

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       // setContentView(R.layout.activity_main2)

        val name =findViewById<TextView>(R.id.name)
        val designation =findViewById<TextView>(R.id.designation)
        val composeView = findViewById<ComposeView>(R.id.compose_view)


            composeView.setContent {

                 MyComposeContent()
             }

    }
}

@Preview
@Composable
fun MyComposeContent(){

    val items = remember {
        mutableStateListOf<String>()
    }

    // Auto add items
    LaunchedEffect(Unit) {
        for (i in 1..10) {
            delay(500)
            items.add("Food Item $i")
        }
    }

    LazyColumn(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        contentPadding = PaddingValues(16.dp)
    ) {
        // Header
        item {
            Text(
                text = "🍴 Today's Menu",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
        }

        // Items
        items(items.size) { index ->
            Text(
                text = "\uD83C\uDF5F ${items[index]}",
                fontSize = 18.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}