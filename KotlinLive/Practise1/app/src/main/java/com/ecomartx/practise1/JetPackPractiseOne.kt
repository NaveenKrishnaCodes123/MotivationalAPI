package com.ecomartx.practise1

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class JetPackPractiseOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           // showingListViewData()
            ColoredNumberList()
        }
    }


   // @Preview
    @Composable
    private fun showingListViewData() {
     Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {

         Card (modifier = Modifier.fillMaxWidth().padding(10.dp)){

             Text(text = "Showing ListView Data"
                  , modifier = Modifier.padding(10.dp))

         }

//         Card(
//             modifier = Modifier.fillMaxWidth().padding(8.dp)) {
//             Text(
//                 text = number.toString(),
//                 modifier = Modifier
//                     .padding(16.dp)
//                     .fillMaxWidth(),
//                 textAlign = TextAlign.Center,
//                 fontSize = 24.sp,
//                 fontWeight = FontWeight.Bold
//             )
//         }
     }

    }

    @Preview
    @Composable
    fun ColoredNumberList() {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow, Color.Cyan)

        LazyColumn {
            itemsIndexed(numbers) { index, number ->
                val bgColor = colors[index % colors.size]
                NumberItemWithColor(number = number, backgroundColor = bgColor)
            }
        }
    }

    @Composable
    fun NumberItemWithColor(number: Int, backgroundColor: Color) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Text(
                text = "Item $number",
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }

}