package com.ecomartx.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { TimerScreen2() }
    }
}

@Composable
fun TimerScreen2() {
    var time by remember { mutableStateOf(0) }
    var isRunning by remember { mutableStateOf(false) }

    // Auto-start after 1 minute
    LaunchedEffect(Unit) {
        delay(60_000L)
        isRunning = true
    }

    // Timer logic: runs while isRunning = true
    LaunchedEffect(isRunning) {
        if (isRunning) {
            while (isRunning) {
                delay(1000L)
                time++
            }
        }
    }

    TimerContent2(
        time = time,
        isRunning = isRunning,
        onStart = { isRunning = true },
        onStop = { isRunning = false },
        onReset = {
            isRunning = false
            time = 0
        }
    )
}

@Composable
fun TimerContent2(
    time: Int,
    isRunning: Boolean,
    onStart: () -> Unit,
    onStop: () -> Unit,
    onReset: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            formatTime2(time),
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(24.dp))
        Button(onClick = onStart, enabled = !isRunning) { Text("Start") }
        Spacer(Modifier.height(8.dp))
        Button(onClick = onStop, enabled = isRunning) { Text("Stop") }
        Spacer(Modifier.height(8.dp))
        Button(onClick = onReset) { Text("Reset") }
    }
}

fun formatTime2(sec: Int): String {
    val h = sec / 3600
    val m = (sec % 3600) / 60
    val s = sec % 60
    return String.format("%02d:%02d:%02d", h, m, s)
}

@Preview(showBackground = true)
@Composable
fun PreviewTimer2() {
    TimerContent2(45, false, {}, {}, {})
}
