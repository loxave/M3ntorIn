package com.z4r17.mentorinApp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.z4r17.mentorinApp.Mentor
import com.z4r17.mentorin.R
import java.util.*

class GridMentorAdapter internal constructor(private val listMentor: ArrayList<Mentor>) :
    RecyclerView.Adapter<GridMentorAdapter.GridViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

   fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    override fun onCreateViewHolder(parent: ViewGroup, i: Int): GridViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_grid_mentor, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listMentor[position].photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listMentor[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listMentor.size
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    interface OnItemClickCallback {
    fun onItemClicked(data: Mentor)
    }

}




