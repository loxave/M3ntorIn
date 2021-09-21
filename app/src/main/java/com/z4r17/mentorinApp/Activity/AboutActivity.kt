package com.z4r17.mentorinApp.Activity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.z4r17.mentorin.R

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val actionBar = supportActionBar
        actionBar!!.title = "About"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val imageOfMe: ImageView = findViewById(R.id.img_item_photo)

        val image =
            "https://d17ivq9b7rppb3.cloudfront.net/small/avatar/20191110120255109f73f0c17bb8d2aee30aa183155ebd.jpg"

        Glide.with(this)
            .load(image)
            .apply(RequestOptions())
            .into(imageOfMe)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
