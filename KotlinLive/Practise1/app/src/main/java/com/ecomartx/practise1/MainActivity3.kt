package com.ecomartx.practise1

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.helper.widget.Flow
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.delay

class MainActivity3 : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           // ThirdScreen(instanceId)
            TestData()
        }
    }
}

/*@Composable
fun ThirdScreen(id: String) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("ThirdActivity", style = MaterialTheme.typography.headlineMedium)
        Text("Instance ID: $id", style = MaterialTheme.typography.bodyLarge)

        Spacer(Modifier.height(20.dp))

        Button(onClick = {
            context.startActivity(Intent(context, MainActivity::class.java))
        }) { Text("Go to MainActivity") }

        Spacer(Modifier.height(10.dp))

        Button(onClick = {
            context.startActivity(Intent(context, MainActivity2::class.java))
        }) { Text("Go to SecondActivity") }
    }
}*/

@Preview
@Composable
fun TestData(){

    var items= remember { mutableStateListOf<String>() }

    LaunchedEffect(Unit) {
        for(i in 1..10){
            delay(1000)
            items.add("Items In List : $i")
        }
    }

    LazyColumn (modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(24.dp)){

        item(){

            Text(text = "SHOW DATA",
                fontSize = 24.sp,
                modifier = Modifier.padding(8.dp),
                fontStyle = FontStyle.Italic
            )

            Button(onClick = {
                items.add("Item in List: ${items.size + 1}")
            }) {
                Text("Add Item")
            }


        }

        items(items.size){ it ->

            Text(text = "${items[it]}",
                fontSize = 14.sp,
                modifier = Modifier.padding(8.dp),
                fontStyle = FontStyle.Italic
            )


        }
    }

}
