
package com.test.nyc.ui.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SchoolDetailScreen(
    dbn: String,
    onBack: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(text = "School Details for: $dbn")
    }
}

@Preview(showBackground = true)
@Composable
fun SchoolDetailScreenPreview() {
    SchoolDetailScreen(dbn = "01", onBack = {})
}