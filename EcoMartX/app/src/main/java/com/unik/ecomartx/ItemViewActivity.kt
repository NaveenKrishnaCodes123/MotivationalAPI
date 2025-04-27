package com.unik.ecomartx

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unik.ecomartx.adapter.FoodAdapter
import com.unik.ecomartx.adapter.FoodItemsAdapter
import com.unik.ecomartx.model.Food

class ItemViewActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_view)
        val foodItems = listOf(
            Food("Home Made Foods", R.drawable.homemealfood),
            Food("Snacks", R.drawable.snacks),
            Food("meals & Foods", R.drawable.homemealfood),
            Food("Pickels", R.drawable.pickels),
            Food("Beverages", R.drawable.beverages),
            Food("Deserts", R.drawable.deserts),
            Food("Pre Booking Food", R.drawable.prebooking)
        )

        recyclerView = findViewById(R.id.rvitems)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = FoodItemsAdapter(foodItems)
        { food ->
//            val intent = Intent(this, ItemViewActivity::class.java)
//            startActivity(intent)
            finish()
        }
        recyclerView.adapter = adapter
    }
}