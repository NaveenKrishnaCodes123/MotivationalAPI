package com.ecomartx.practise1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecomartx.practise1.ui.theme.Practise1Theme
import kotlinx.coroutines.delay
import kotlin.jvm.java

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AutoList()
            }
        }
    }
}

/*@Composable
fun MainScreen(id: String) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("MainActivity", style = MaterialTheme.typography.headlineMedium)
        Text("Instance ID: $id", style = MaterialTheme.typography.bodyLarge)

        Spacer(Modifier.height(20.dp))

        Button(onClick = {
            context.startActivity(Intent(context, MainActivity2::class.java))
        }) { Text("Go to SecondActivity") }

        Spacer(Modifier.height(10.dp))

        Button(onClick = {
            context.startActivity(Intent(context, MainActivity3::class.java))
        }) { Text("Go to ThirdActivity") }
    }
}*/



@Preview(showBackground = true)
@Composable
fun AutoList() {
     var items= remember { mutableStateListOf<Int>()}
    LaunchedEffect(Unit) {

        for( i in 1..100){
            delay(500)
            items.add(i)
        }
    }

    LazyColumn(modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(24.dp)) {

        item{
          Text(text = "Showing Data",
              fontWeight = FontWeight.Bold,
              fontSize = 24.sp,
              modifier = Modifier.padding(8.dp))

        }
        items(items.size){ it->
          Text(text = "${items[it]}",
              fontWeight = FontWeight.Bold,
              fontSize = 24.sp,
              modifier = Modifier.padding(8.dp))

        }

    }
}



