package com.z4r17.mentorinApp.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.z4r17.mentorinApp.Mentor
import com.z4r17.mentorin.R
import com.z4r17.mentorinApp.Activity.DetailMentorActivity

class ListMentorAdapter(private val listMentor: ArrayList<Mentor>) :
    RecyclerView.Adapter<ListMentorAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvHeadline: TextView = itemView.findViewById(R.id.tv_item_headline)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_mentor, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, headline, detail, photo, college, skills) = listMentor[position]

        //val mentor = listMentor[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvHeadline.text = headline

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveToDetail = Intent(mContext, DetailMentorActivity::class.java)
            moveToDetail.putExtra(DetailMentorActivity.EXTRA_NAME, name)
            moveToDetail.putExtra(DetailMentorActivity.EXTRA_HEADLINE, headline)
            moveToDetail.putExtra(DetailMentorActivity.EXTRA_DETAIL, detail)
            moveToDetail.putExtra(DetailMentorActivity.EXTRA_PHOTO, photo)
            moveToDetail.putExtra(DetailMentorActivity.EXTRA_COLLEGE, college)
            moveToDetail.putExtra(DetailMentorActivity.EXTRA_SKILLS, skills)
            mContext.startActivity(moveToDetail)
        }
    }

    override fun getItemCount(): Int {
        return listMentor.size
    }

}