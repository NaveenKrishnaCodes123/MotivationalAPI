package com.example.kotlinexamples

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.kotlinexamples.model.Puppy
import com.example.kotlinexamples.ui.theme.KotlinExamplesTheme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinExamplesTheme {
                ProfileScreen(puppy)
            }
        }
    }

    private val puppy: Puppy by lazy {
        intent?.getSerializableExtra(PUPPY_ID) as Puppy
    }

    companion object {
        /*   private const val PUPPY_ID = "puppy_id"
           fun newIntent(context: Context, puppy: Puppy)= Intent(context,ProfileActivity::class.java) {
               putExtra(PUPPY_ID, puppy)
           }
       }*/
        private const val PUPPY_ID = "puppy_id"
        fun newIntent(context: Context, puppy: Puppy) =
            Intent(context, ProfileActivity::class.java).apply {
                putExtra(PUPPY_ID, puppy)
            }
    }
}