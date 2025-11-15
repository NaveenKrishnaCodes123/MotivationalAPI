package com.mindcoin.dservicevp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mindcoin.dservicevp.Model.parkingslots.Block
import com.mindcoin.dservicevp.Model.parkingslots.Floor
import com.mindcoin.dservicevp.Model.parkingslots.ParkingSlots
import com.mindcoin.dservicevp.R

class BlockTwoAdapter(
    private val context: Context,
    private var blockList: List<Block>, // Updated dynamically
    private val onSlotSelected: (ParkingSlots, Floor, Block) -> Unit,
    private var selectedBlockPosition: Int = -1
) : RecyclerView.Adapter<BlockTwoAdapter.BlockViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()

    inner class BlockViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val floorRecyclerView: RecyclerView = itemView.findViewById(R.id.floorRecycler)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlockViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_block_two, parent, false)
        return BlockViewHolder(view)
    }

    override fun onBindViewHolder(holder: BlockViewHolder, position: Int) {
        val block = blockList[position]

        val floorLayoutManager = LinearLayoutManager(holder.floorRecyclerView.context, LinearLayoutManager.VERTICAL, false)
        val floorAdapter = FloorAdapter(context, block.floors, block, onSlotSelected)

        holder.floorRecyclerView.apply {
            layoutManager = floorLayoutManager
            adapter = floorAdapter
            setRecycledViewPool(viewPool)
            setHasFixedSize(true) // Optimization for nested RecyclerView
            visibility = if (position == 0) View.VISIBLE else View.GONE
        }

        holder.itemView.setOnClickListener {
            updateSelectedBlockPosition(position)
        }
    }

    override fun getItemCount(): Int = blockList.size

    fun updateSelectedBlockPosition(position: Int) {
        if (position in blockList.indices) {
            val selectedBlock = blockList[position]
            val newList = blockList.toMutableList()
            newList.removeAt(position)
            newList.add(0, selectedBlock)
            blockList = newList
            notifyDataSetChanged()
        }
    }

    fun updateBlockList(newBlockList: List<Block>) {
        blockList = newBlockList
        notifyItemRangeChanged(0, blockList.size) // Replaces heavy notifyDataSetChanged
    }
}
