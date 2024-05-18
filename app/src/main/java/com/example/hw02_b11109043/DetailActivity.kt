// DetailActivity.kt
package com.example.hw02_b11109043

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity

class DetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imageView: ImageView = findViewById(R.id.detail_image)
        val titleView: TextView = findViewById(R.id.detail_title)
        val backButton: Button = findViewById(R.id.back_button)
        val mapButton: Button = findViewById(R.id.map_button)

        val dataImage = intent.getIntExtra("dataImage", 0)
        val dataTitle = intent.getStringExtra("dataTitle")
        val latitude = intent.getDoubleExtra("latitude", 0.0)
        val longitude = intent.getDoubleExtra("longitude", 0.0)

        imageView.setImageResource(dataImage)
        titleView.text = dataTitle

        backButton.setOnClickListener {
            finish()  // 结束当前的 activity，返回到上一個 activity
        }

        mapButton.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:$latitude,$longitude?q=$latitude,$longitude($dataTitle)")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            if (mapIntent.resolveActivity(packageManager) != null) {
                startActivity(mapIntent)
            } else {
                Log.e("DetailActivity", "No map application available")
            }
        }


    }
}
