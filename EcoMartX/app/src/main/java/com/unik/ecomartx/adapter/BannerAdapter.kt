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
import com.unik.ecomartx.model.Banner

class BannerAdapter(private val bannerList: List<Banner>) : RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {
    private val colors = listOf(
        "#D32F2F", // dark red
        "#388E3C", // dark green
        "#1976D2", // dark blue
        "#FBC02D", // dark yellow
        "#512DA8", // deep purple
        "#00796B", // teal
        "#455A64", // blue-grey
        "#5D4037"  // brown
    )
    class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bannerImage: ImageView = itemView.findViewById(R.id.bannerImage)
        val text: TextView = itemView.findViewById(R.id.text)
        val cardview: CardView = itemView.findViewById(R.id.cardview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_banner, parent, false)
        return BannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val banner = bannerList[position]
        holder.text.setText(banner.name)
        Glide.with(holder.itemView.context)
            .load(banner.image)
            .into(holder.bannerImage)

        val colorHex = colors[position % colors.size]
        holder.cardview.setCardBackgroundColor(Color.parseColor(colorHex))
    }

    override fun getItemCount(): Int {
        return bannerList.size
    }
}