package com.unik.ecomartx.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.unik.ecomartx.R
import com.unik.ecomartx.model.Food

class FoodItemsAdapter(private val foodList: List<Food>, private val onItemClick: (Food) -> Unit) :
    RecyclerView.Adapter<FoodItemsAdapter.FoodViewHolder>() {

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodName: TextView = itemView.findViewById(R.id.foodName)
        val foodDesc: TextView = itemView.findViewById(R.id.foodDesc)
        val foodImage: CardView = itemView.findViewById(R.id.foodImage) // ImageView for food image
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemsview_items, parent, false) // Inflate item_food layout
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val foodItem = foodList[position] // Get the food item at this position

        // Bind food name and description
        holder.foodName.text = foodItem.name
        // holder.foodImage.text = foodItem.image

        /*// Load image using Glide
        Glide.with(holder.itemView.context)
            .load(foodItem.image)
            .into(holder.foodImage)*/
        holder.foodImage.setBackgroundResource(foodItem.image)

        holder.itemView.setOnClickListener {
            onItemClick(foodItem)
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }


}
