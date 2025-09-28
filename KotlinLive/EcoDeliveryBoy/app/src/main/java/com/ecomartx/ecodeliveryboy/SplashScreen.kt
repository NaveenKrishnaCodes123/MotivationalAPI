package com.ecomartx.ecodeliveryboy

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.core.splashscreen.SplashScreen
import com.ecomartx.ecodeliveryboy.ui.theme.EcoDeliveryBoyTheme
import kotlinx.coroutines.delay

class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                SplashScreenPreview()
            }
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
        val context = LocalContext.current
        LaunchedEffect(Unit) {
            delay(2500)
            // splashTimeOut
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }

        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.White),contentAlignment = Alignment.Center) {
            Column(modifier = Modifier
                .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.deliveryboy),
                    contentDescription = stringResource(id = R.string.app_name),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Column(modifier = Modifier
                    .fillMaxWidth(), verticalArrangement = Arrangement.Bottom,Alignment.CenterHorizontally) {
                    Text(
                        text = "Delivery of any Order", color = Color.Black,
                        style = MaterialTheme.typography.labelLarge, fontSize = 24.sp
                    )
                }
            }
        }

}