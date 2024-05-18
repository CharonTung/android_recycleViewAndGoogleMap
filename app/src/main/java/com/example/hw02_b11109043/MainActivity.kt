// MainActivity.kt
package com.example.hw02_b11109043

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var imagList: Array<Int>
    lateinit var titleList: Array<String>
    lateinit var latitudeList: Array<Double>
    lateinit var longitudeList: Array<Double>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imagList = arrayOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5
        )

        titleList = arrayOf(
            "景點1",
            "景點2",
            "景點3",
            "景點4",
            "景點5"
        )

        latitudeList = arrayOf(
            25.0130, // 假设的纬度
            33.0340,
            26.0350,
            55.0360,
            35.0370
        )

        longitudeList = arrayOf(
            121.54085, // 假设的经度
            120.5664,
            123.5674,
            119.5684,
            100.5694
        )

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf()
        getDate()
    }

    private fun getDate() {
        for (i in imagList.indices) {
            val dataClass = DataClass(imagList[i], titleList[i], latitudeList[i], longitudeList[i])
            dataList.add(dataClass)
        }

        recyclerView.adapter = AdapterClass(dataList) { dataClass ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("dataImage", dataClass.dataImage)
                putExtra("dataTitle", dataClass.dataTitle)
                putExtra("latitude", dataClass.latitude)
                putExtra("longitude", dataClass.longitude)
            }
            startActivity(intent)
        }
    }
}
