package com.ecomartx.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val timerViewModel: TimerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimerScreen(timerViewModel)
        }
    }
}

// ------------------- ViewModel -------------------
class TimerViewModel : ViewModel() {

    private var timerJob: Job? = null
    private var seconds = 0

    private val _time = mutableStateOf(0)
    val time: State<Int> = _time

    private val _isRunning = mutableStateOf(false)
    val isRunning: State<Boolean> = _isRunning

    init {
        // Auto-start after 1 minute (60 sec)
        viewModelScope.launch {
            delay(60_000L) // wait 1 min
            startTimer()
        }
    }

    fun startTimer() {
        if (_isRunning.value) return
        _isRunning.value = true
        timerJob = viewModelScope.launch {
            while (_isRunning.value) {
                delay(1000L)
                seconds++
                _time.value = seconds
            }
        }
    }

    fun stopTimer() {
        _isRunning.value = false
        timerJob?.cancel()
    }

    fun resetTimer() {
        stopTimer()
        seconds = 0
        _time.value = 0
    }
}

// ------------------- UI -------------------
@Composable
fun TimerScreen(viewModel: TimerViewModel) {
    val time by viewModel.time
    val isRunning by viewModel.isRunning

    TimerContent(
        time = time,
        isRunning = isRunning,
        onStart = { viewModel.startTimer() },
        onStop = { viewModel.stopTimer() },
        onReset = { viewModel.resetTimer() }
    )
}

@Composable
fun TimerContent(
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
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Timer Text
        Text(
            text = formatTime(time),
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = onStart, enabled = !isRunning) {
            Text("Start")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onStop, enabled = isRunning) {
            Text("Stop")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onReset) {
            Text("Reset")
        }
    }
}

// ------------------- Preview -------------------
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TimerPreview() {
    TimerContent(
        time = 125, // example value
        isRunning = false,
        onStart = {},
        onStop = {},
        onReset = {}
    )
}

// Helper
fun formatTime(seconds: Int): String {
    val hrs = seconds / 3600
    val mins = (seconds % 3600) / 60
    val secs = seconds % 60
    return String.format("%02d:%02d:%02d", hrs, mins, secs)
}
