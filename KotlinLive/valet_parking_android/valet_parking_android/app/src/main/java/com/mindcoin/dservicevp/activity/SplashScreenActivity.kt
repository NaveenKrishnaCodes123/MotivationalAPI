package com.mindcoin.dservicevp.activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.messaging.FirebaseMessaging
import com.mindcoin.dservicevp.Model.DeviceTokenRequest
import com.mindcoin.dservicevp.Model.DeviceTokenViewModelFactory
import com.mindcoin.dservicevp.R
import com.mindcoin.dservicevp.apis.ApiService
import com.mindcoin.dservicevp.apis.RetrofitClient
import com.mindcoin.dservicevp.repository.VehicleRepository
import com.mindcoin.dservicevp.selfUpdate.AppSelfUpdateInputReq
import com.mindcoin.dservicevp.selfUpdate.AppUpdateViewModel
import com.mindcoin.dservicevp.selfUpdate.SelfUpdaterActivity
import com.mindcoin.dservicevp.storage.SharedPreferencesHelper
import com.mindcoin.dservicevp.viewModel.VehicleViewModel.DeviceTokenViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    private lateinit var userId: String
    private lateinit var userName: String
    private lateinit var versionCode: String
    private lateinit var versionName: String
    private lateinit var applicationName: String
    private val NOTIFICATION_PERMISSION_CODE = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                == PackageManager.PERMISSION_GRANTED
            ) {
                setNotificationPermissionGranted(true)
                goToNextScreen()
            } else if (!isNotificationPermissionGranted()) {
                showNotificationPermissionDialog()
            } else {
                showPermissionSettingsDialog()
            }
        } else {
            goToNextScreen()
        }


    }
    private fun CoroutineScope.CallAPI() {
        sharedPreferencesHelper = SharedPreferencesHelper(this@SplashScreenActivity)
        val loginResponse = sharedPreferencesHelper.getLoginResponse()

        loginResponse?.let {
            val loginData = it.content.firstOrNull()
            if (loginData != null) {
                userName = loginData.name ?: "N/A"
                userId = loginData.uuid ?: "N/A"
            }
        } ?: run {
            Toast.makeText(this@SplashScreenActivity, "Please Logout and Login Once.", Toast.LENGTH_SHORT).show()
        }

        val viewModel = ViewModelProvider(this@SplashScreenActivity)[AppUpdateViewModel::class.java]
        val request = AppSelfUpdateInputReq(
            userId = userId,
            appName = "Valet_Parking_Test",
            userName = userName,
            verName = getAppVersionInfo(this@SplashScreenActivity).second,
            verCode = getAppVersionInfo(this@SplashScreenActivity).first,
            osType = 1,
            deviceInfo = "${Build.MANUFACTURER} ${Build.MODEL} Android ${Build.VERSION.RELEASE}",
            deviceId = Settings.Secure.getString(this@SplashScreenActivity.contentResolver, Settings.Secure.ANDROID_ID),
            packageName = applicationContext.packageName
        )

        viewModel.updateInfo.observe(this@SplashScreenActivity) { update ->
            update?.let {
                versionCode=it.content.get(0).verCode.toString()
                versionName=it.content.get(0).verName.toString()
                applicationName=it.content.get(0).appName.toString()

                if(getAppVersionInfo(this@SplashScreenActivity).second.equals(it.content.get(0).verName.toString())){
                    val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    val intent = Intent(this@SplashScreenActivity, SelfUpdaterActivity::class.java)
                    intent.putExtra("applicationName", it.content.get(0).appName.toString())
                    intent.putExtra("apkUrl", it.content.get(0).apkUrl.toString())
                    startActivity(intent)
                    finish()
                }
            }
        }

        viewModel.error.observe(this@SplashScreenActivity) { error ->
            error?.let {
                Toast.makeText(this@SplashScreenActivity, it, Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.sendUpdateRequest(request)
    }

    fun getAppVersionInfo(context: Context): Pair<Long, String> {
        val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
        return Pair(
            first = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                packageInfo.longVersionCode
            } else {
                packageInfo.versionCode.toLong()
            },
            second = packageInfo.versionName ?: "N/A"
        )
    }

    private fun goToNextScreen() {
        sharedPreferencesHelper = SharedPreferencesHelper(this)
        GlobalScope.launch {
            delay(2000)  //
            withContext(Dispatchers.Main) {
                if (!sharedPreferencesHelper.isLoggedIn()) {
                    val intent = Intent(this@SplashScreenActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    CallAPI()
                }


            }
        }
    }

    private fun isNotificationPermissionGranted(): Boolean {
        val prefs = getSharedPreferences("app_prefs", MODE_PRIVATE)
        return prefs.getBoolean("notification_permission_granted", false)
    }

    private fun setNotificationPermissionGranted(granted: Boolean) {
        val prefs = getSharedPreferences("app_prefs", MODE_PRIVATE)
        prefs.edit().putBoolean("notification_permission_granted", granted).apply()
    }
    private fun showNotificationPermissionDialog() {
        AlertDialog.Builder(this)
            .setTitle("Notification Permission Required")
            .setMessage("We need permission to send you important updates.")
            .setCancelable(false)
            .setPositiveButton("Allow") { _, _ ->
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    NOTIFICATION_PERMISSION_CODE
                )
            }
            .setNegativeButton("Exit App") { _, _ ->
                finishAffinity()
            }
            .show()
    }

    private fun showPermissionSettingsDialog() {
        AlertDialog.Builder(this)
            .setTitle("Permission Needed")
            .setMessage("You have permanently denied the notification permission. Please enable it in settings.")
            .setPositiveButton("Go to Settings") { _, _ ->
                val intent = Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                intent.data = Uri.parse("package:$packageName")
                startActivity(intent)
            }
            .setNegativeButton("Exit") { _, _ ->
                finishAffinity()
            }
            .show()
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == NOTIFICATION_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setNotificationPermissionGranted(true)
                goToNextScreen()
            } else {
                showNotificationPermissionDialog()
            }
        }
    }


}