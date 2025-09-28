package com.ecomartx.practise1.mustLearn

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun statefull(){

//    var count by remember  {
//        mutableSetOf(0)
//    }
//
//    Button(onClick = {
//        count++
//    }) {
//        Text("I've been clicked $count times")
//    }
}

@Composable
fun StatefulMyButton() {
    // State is created and managed INSIDE this composable.
//    var count by remember { mutableStateOf(0) }
//
//    Button(
//        onClick = { count++ } // Logic is also inside
//    ) {
//        Text("I've been clicked $count times")
//    }
}