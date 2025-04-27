package com.unik.ecomartx


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unik.ecomartx.adapter.BannerAdapter
import com.unik.ecomartx.adapter.FoodAdapter
import com.unik.ecomartx.model.Banner
import com.unik.ecomartx.model.Food

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var rvMindItems: RecyclerView
    private lateinit var rvbanner: RecyclerView
    private lateinit var adapter: FoodAdapter

    private lateinit var bannerAdapter: BannerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val foodItems = listOf(
            Food("Home Made Foods", R.drawable.homemealfood),
            Food("Snacks", R.drawable.snacks),
            Food("meals & Foods", R.drawable.homemealfood),
            Food("Pickels", R.drawable.pickels),
            Food("Beverages", R.drawable.beverages),
            Food("Deserts", R.drawable.deserts),
            Food("Pre Booking Food", R.drawable.prebooking)
        )

        val foodItems2 = listOf(
            Food("Lunch", R.drawable.splashimg),
            Food("Dinner", R.drawable.snacks),
            Food("Special Combo", R.drawable.homemealfood),
            Food("Tiffin", R.drawable.splashimg)
        )
         val bannerList = listOf(
            Banner("Claim your discount 30% daily now!","R.drawable.splashimg"),
            Banner("Claim your discount 60% daily now!","R.drawable.splashimg"),
            Banner("Claim your discount 1000% daily now!","R.drawable.splashimg"),
            Banner("Claim your discount 80% daily now!","R.drawable.splashimg")
        )
        recyclerView = findViewById(R.id.rvCategories)
        recyclerView.layoutManager = GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false)
        adapter = FoodAdapter(foodItems)
        { food ->
            val intent = Intent(this, ItemViewActivity::class.java)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        rvMindItems = findViewById(R.id.rvMindItems)
        rvMindItems.layoutManager = GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false)
        adapter = FoodAdapter(foodItems2)
        { food ->
            val intent = Intent(this, ItemViewActivity::class.java)
            startActivity(intent)
        }
        rvMindItems.adapter = adapter




        rvbanner = findViewById(R.id.rvbanner)
        rvbanner.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        bannerAdapter = BannerAdapter(bannerList)
        rvbanner.adapter = bannerAdapter

        val handler = Handler(Looper.getMainLooper())
        val runnable = object : Runnable {
            var currentPosition = 0
            override fun run() {
                if (currentPosition == bannerList.size) {
                    currentPosition = 0
                }
                recyclerView.smoothScrollToPosition(currentPosition++)
                handler.postDelayed(this, 3000)
            }
        }
        handler.post(runnable)
    }
}