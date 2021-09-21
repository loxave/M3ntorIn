package com.z4r17.mentorinApp.Activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.z4r17.mentorin.R

class DetailMentorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail_mentor)
        val actionBar = supportActionBar
        actionBar!!.title = "Detail Mentor"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val tvName: TextView = findViewById(R.id.tv_set_name)
        val tvDetails: TextView = findViewById(R.id.tv_item_detail)
        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvCollege: TextView = findViewById(R.id.tv_set_college)
        val tvSkills: TextView = findViewById(R.id.tv_set_skills)

        val txt_Name = intent.getStringExtra(EXTRA_NAME)
        val txt_Details = intent.getStringExtra(EXTRA_DETAIL)
        val img_Photo = intent.getStringExtra(EXTRA_PHOTO)
        val txt_College = intent.getStringExtra(EXTRA_COLLEGE)
        val txt_Skills = intent.getStringExtra(EXTRA_SKILLS)


        tvName.text = txt_Name
        Glide.with(this)
            .load(img_Photo)
            .apply(RequestOptions())
            .into(imgPhoto)
        tvDetails.text = txt_Details
        tvCollege.text = txt_College
        tvSkills.text = txt_Skills
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_HEADLINE = "extra_headline"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_COLLEGE = "extra_college"
        const val EXTRA_SKILLS = "extra_skills"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}