package com.mindcoin.dservicevp.fragment

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.firebase.messaging.FirebaseMessaging
import com.mindcoin.dservicevp.Model.DeviceTokenRequest
import com.mindcoin.dservicevp.Model.DeviceTokenViewModelFactory
import com.mindcoin.dservicevp.Model.VehicleViewModelFactory
import com.mindcoin.dservicevp.R
import com.mindcoin.dservicevp.activity.CheckInActivity
import com.mindcoin.dservicevp.activity.CheckOutActivity
import com.mindcoin.dservicevp.adapter.VehicleAdapter
import com.mindcoin.dservicevp.apis.ApiService
import com.mindcoin.dservicevp.apis.RetrofitClient
import com.mindcoin.dservicevp.repository.VehicleRepository
import com.mindcoin.dservicevp.storage.SharedPreferencesHelper
import com.mindcoin.dservicevp.viewModel.VehicleViewModel
import com.mindcoin.dservicevp.viewModel.VehicleViewModel.DeviceTokenViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.String
import kotlin.getValue

class Alerts : Fragment()  {
    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    private lateinit var recyclerView: RecyclerView
    private lateinit var linear_rv: LinearLayout
    private lateinit var vehicleAdapter: VehicleAdapter
    private lateinit var vehicleViewModel: VehicleViewModel.VehicleViewModelList
    private lateinit var userId: String
    private lateinit var authToken: String
    private lateinit var lnrNoData: LinearLayout
    private lateinit var shimmerLayout: ShimmerFrameLayout

    private lateinit var childFab1: Button
    private lateinit var childFab2: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for the fragment
        val view = inflater.inflate(R.layout.alerts, container, false)

        shimmerLayout = view.findViewById(R.id.shimmerLayout)
        recyclerView = view.findViewById(R.id.vehicleRecyclerView)
        linear_rv = view.findViewById(R.id.linear_rv)
        lnrNoData = view.findViewById(R.id.lnrNoData)
        recyclerView.layoutManager = LinearLayoutManager(context)
        sharedPreferencesHelper = SharedPreferencesHelper(requireContext())
        val loginResponse = sharedPreferencesHelper.getLoginResponse()
        // val fabAddVehicle: FloatingActionButton = view.findViewById(R.id.fabAddVehicle)
        childFab1 = view.findViewById(R.id.childFab1)
        childFab2 = view.findViewById(R.id.childFab2)
        //toggleChildFabs()
        loginResponse?.let {
            val loginData = it.content.firstOrNull()
            if (loginData != null) {
                userId = loginData.uuid ?: "N/A"
                authToken = loginData.token ?: "N/A"
            }
        } ?: run {
            Toast.makeText(context, "Please Logout and Login Once.", Toast.LENGTH_SHORT).show()
        }
        shimmerLayout.startShimmer()

        // Simulate data loading (e.g., API call)
        /* Handler(Looper.getMainLooper()).postDelayed({
             // Stop shimmer effect & show RecyclerView
             shimmerLayout.stopShimmer()
             shimmerLayout.visibility = View.GONE
             recyclerView.visibility = View.VISIBLE
         }, 3000) // 3 seconds delay*/

        childFab1.setOnClickListener {
            val intent = Intent(requireActivity(), CheckInActivity::class.java)
            startActivity(intent)
        }
        childFab2.setOnClickListener {
            val intent = Intent(requireActivity(), CheckOutActivity::class.java)
            startActivity(intent)
        }
        tokenApiCall()
        initialAPICall()

        return view
    }

    private fun initialAPICall() {
        // Initialize ViewModel
        val apiService = RetrofitClient.instance.create(ApiService::class.java)
        val repository = VehicleRepository(apiService)
        vehicleViewModel = ViewModelProvider(this, VehicleViewModelFactory(repository)).get(
            VehicleViewModel.VehicleViewModelList::class.java)

       /* vehicleViewModel.vehicleList.observe(viewLifecycleOwner, { vehicleList ->
            if(vehicleList.size>=1){
                lnrNoData.visibility= View.GONE
            }else{
                lnrNoData.visibility= View.VISIBLE
            }

            shimmerLayout.visibility = View.GONE
            //recyclerView.visibility = View.VISIBLE
            linear_rv.visibility = View.VISIBLE

            for (vehicleData in vehicleList){
                if(vehicleData.checkOutRequestedType==1){
                    vehicleList==vehicleData;
                }
            }
            vehicleAdapter = VehicleAdapter(requireContext(), vehicleList) { vehicle ->
                val intent = Intent(requireActivity(), CheckOutActivity::class.java)
                intent.putExtra("vehicleUuid", vehicle.uuid)
                startActivity(intent)
            }
            recyclerView.adapter = vehicleAdapter
        })*/
        vehicleViewModel.vehicleList.observe(viewLifecycleOwner) { vehicleList ->

            val filteredList = vehicleList.filter { it.checkOutRequestedType == 1 }

            lnrNoData.visibility = if (filteredList.isNotEmpty()) View.GONE else View.VISIBLE
            shimmerLayout.visibility = View.GONE
            linear_rv.visibility = View.VISIBLE

            if (::vehicleAdapter.isInitialized) {
                vehicleAdapter.updateData(filteredList) // Call update method if already initialized
            } else {
                vehicleAdapter = VehicleAdapter(requireContext(), filteredList) { vehicle ->
                    val intent = Intent(requireActivity(), CheckOutActivity::class.java)
                    intent.putExtra("vehicleUuid", vehicle.uuid)
                    startActivity(intent)
                }
                recyclerView.adapter = vehicleAdapter
            }
        }

        // Observe loading state
        vehicleViewModel.isLoading.observe(viewLifecycleOwner, { isLoading ->

        })

        // Observe error state
        vehicleViewModel.error.observe(viewLifecycleOwner, { errorMessage ->
            Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
        })

        // Fetch vehicle details
        vehicleViewModel.fetchVehicleDetails(userId, authToken)
    }

    override fun onResume() {
        super.onResume()
        initialAPICall()
    }

    private fun toggleChildFabs() {
        if (childFab1.visibility == View.GONE) {
            // Show child FABs with animations
            showChildFabs()
        } else {
            // Hide child FABs with animations
            hideChildFabs()
        }
    }

    // Show child FABs with animations
    private fun showChildFabs() {
        childFab1.visibility = View.VISIBLE
        childFab2.visibility = View.VISIBLE

        val animator1 = ObjectAnimator.ofFloat(childFab1, "translationY", 0f, -10f)
        val animator2 = ObjectAnimator.ofFloat(childFab2, "translationY", 0f, -200f)

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(animator1, animator2)
        animatorSet.duration = 600
        animatorSet.start()
    }

    // Hide child FABs with animations
    private fun hideChildFabs() {
        val animator1 = ObjectAnimator.ofFloat(childFab1, "translationY", -10f, 0f)
        val animator2 = ObjectAnimator.ofFloat(childFab2, "translationY", -200f, 0f)

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(animator1, animator2)
        animatorSet.duration = 300
        animatorSet.start()

        // Hide child FABs after the animation
        animatorSet.addListener(object : Animator.AnimatorListener {

            override fun onAnimationStart(p0: Animator) {
                TODO("Not yet implemented")
            }

            override fun onAnimationEnd(p0: Animator) {
                childFab1.visibility = View.GONE
                childFab2.visibility = View.GONE
            }

            override fun onAnimationCancel(p0: Animator) {
                TODO("Not yet implemented")
            }

            override fun onAnimationRepeat(p0: Animator) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun tokenApiCall(){
        val viewModel by viewModels<DeviceTokenViewModel> {
            DeviceTokenViewModelFactory(VehicleRepository(apiService = RetrofitClient.instance.create(ApiService::class.java)))
        }

        val request = DeviceTokenRequest(

            uuid = userId,
            userId = userId,
            regToken = authToken,
            mobileId = getMobileId(requireContext()),
            createdDate = getCurrentFormattedDate(),
            appVersion = getAppVersionInfo(requireContext()).second,
            deviceInfo = getDeviceInfo(),
            status = "1",
            createdBy = userId,
            osType = 0,
            deviceId = getDeviceId(requireContext())
        )

        viewModel.registerDeviceToken(authToken,request)

        viewModel.tokenResponse.observe(this) { result ->
            result.onSuccess {
                Log.d("TokenSuccess", "Registered: ${it.mssg}")
                initFirebase(it.content.get(0).regToken)
            }.onFailure {
                Log.e("TokenError", "Failed: ${it.message}")
            }
        }

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

    fun getDeviceId(context: Context): String {
        return Settings.Secure.getString(
            context.contentResolver,
            Settings.Secure.ANDROID_ID
        ) ?: "unknown_device_id"
    }

    fun getDeviceInfo(): String {
        return "Manufacturer: ${Build.MANUFACTURER}, " +
                "Model: ${Build.MODEL}, " +
                "Brand: ${Build.BRAND}, " +
                "Device: ${Build.DEVICE}, " +
                "Product: ${Build.PRODUCT}, " +
                "SDK: ${Build.VERSION.SDK_INT}, " +
                "Android Version: ${Build.VERSION.RELEASE}"
    }

    fun getCurrentFormattedDate(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return dateFormat.format(Date())
    }

    fun getMobileId(context: Context): String {
        return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
    }

    private fun initFirebase(regToken: String) {
        try {
            FirebaseMessaging.getInstance().token
                .addOnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        Log.e("FCM", "Fetching FCM token failed: ${task.exception?.message}")
                        return@addOnCompleteListener
                    }

                    val token = task.result
                    Log.d("FCM", "FCM Token: $token")
                }
                .addOnFailureListener { exception ->
                    Log.e("FCM", "Token fetch failed: ${exception.message}", exception)
                }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("FCM", "Exception: ${e.message}")
        }
    }

}