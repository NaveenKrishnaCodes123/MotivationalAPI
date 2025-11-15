package com.mindcoin.dservicevp.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mindcoin.dservicevp.R

class ImageAdapter(private val context: Context, private var imageUris: MutableList<Uri>) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val latestImageUri = imageUris.last()
        Glide.with(context)
            .load(latestImageUri)
            .placeholder(R.drawable.ic_default_image)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return if (imageUris.isNotEmpty()) 1 else 0
    }

    fun updateImages(newImageUris: List<Uri>) {
        imageUris.clear()
        imageUris.addAll(newImageUris)
        notifyDataSetChanged()
    }
}