package com.ecomartx.practise1

import android.app.ComponentCaller
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.ecomartx.practise1.databinding.ActivityBaseBinding

open class BaseActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityBaseBinding
    protected val instanceId: String = this.hashCode().toString()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("LaunchModeDemo", "${this::class.java.simpleName} CREATED ${this.hashCode()}")
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_base)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onNewIntent(intent: Intent, caller: ComponentCaller) {
        intent?.let { super.onNewIntent(it) }
        Log.d("LaunchModeDemo", "${this::class.java.simpleName} onNewIntent ${this.hashCode()}")
    }
}