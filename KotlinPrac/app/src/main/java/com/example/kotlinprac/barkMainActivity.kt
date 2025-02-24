package com.example.kotlinprac

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinprac.ui.theme.KotlinPracTheme
import com.example.kotlinprac.data.model.Puppy

//@AndroidEntryPoint
class barkMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinPracTheme {
                MyApp {
                    startActivity(ProfileActivity.newIntent(this, it))
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyApp(navigateToProfile: (Puppy) -> Unit) {
    Scaffold(
        content = {
            BarkHomeContent(navigateToProfile = navigateToProfile)
        }
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    KotlinPracTheme {
        MyApp { }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    KotlinPracTheme(darkTheme = true) {
        MyApp { }
    }
}