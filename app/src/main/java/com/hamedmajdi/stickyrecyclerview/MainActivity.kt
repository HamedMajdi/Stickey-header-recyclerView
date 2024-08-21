package com.hamedmajdi.stickyrecyclerview

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Make sure this layout file contains the RecyclerView with the correct ID

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val items = listOf(
            HeaderData("Fruits", Color.RED),
            ItemRowData("Apple", "A red apple", 10),
            ItemRowData("Apple", "A red apple", 10),
            ItemRowData("Apple", "A red apple", 10),
            ItemRowData("Apple", "A red apple", 10),
            ItemRowData("Apple", "A red apple", 10),
            ItemRowData("Apple", "A red apple", 10),
            ItemRowData("Apple", "A red apple", 10),
            ItemRowData("Apple", "A red apple", 10),
            ItemRowData("Apple", "A red apple", 10),
            ItemRowData("Apple", "A red apple", 10),
            ItemRowData("Apple", "A red apple", 10),
            ItemRowData("Apple", "A red apple", 10),
            ItemRowData("Apple", "A red apple", 10),
            ItemRowData("Apple", "A red apple", 10),
            ItemRowData("Apple", "A red apple", 10),
            ItemRowData("Apple", "A red apple", 10),
            ItemRowData("Apple", "A red apple", 10),
            ItemRowData("Apple", "A red apple", 10),
            ItemRowData("Apple", "A red apple", 10),
            ItemRowData("Banana", "A yellow banana", 20),
            HeaderData("Vegetables", Color.GREEN),
            ItemRowData("Carrot", "A fresh carrot", 30),
            ItemRowData("Carrot", "A fresh carrot", 30),
            ItemRowData("Carrot", "A fresh carrot", 30),
            ItemRowData("Carrot", "A fresh carrot", 30),
            ItemRowData("Carrot", "A fresh carrot", 30),
            ItemRowData("Carrot", "A fresh carrot", 30),
            ItemRowData("Carrot", "A fresh carrot", 30),
            ItemRowData("Carrot", "A fresh carrot", 30),
            ItemRowData("Carrot", "A fresh carrot", 30),
            ItemRowData("Carrot", "A fresh carrot", 30),
            ItemRowData("Carrot", "A fresh carrot", 30),
            ItemRowData("Carrot", "A fresh carrot", 30),
            ItemRowData("Carrot", "A fresh carrot", 30),
            ItemRowData("Carrot", "A fresh carrot", 30),
            ItemRowData("Carrot", "A fresh carrot", 30),
            HeaderData("Broccoli 222", Color.YELLOW),

            ItemRowData("Broccoli", "A green broccoli", 40),
            ItemRowData("Broccoli", "A green broccoli", 40),
            ItemRowData("Broccoli", "A green broccoli", 40),
            ItemRowData("Broccoli", "A green broccoli", 40),
            ItemRowData("Broccoli", "A green broccoli", 40),
            ItemRowData("Broccoli", "A green broccoli", 40),
            ItemRowData("Broccoli", "A green broccoli", 40),
            ItemRowData("Broccoli", "A green broccoli", 40),
            ItemRowData("Broccoli", "A green broccoli", 40),
            ItemRowData("Broccoli", "A green broccoli", 40),
            ItemRowData("Broccoli", "A green broccoli", 40),
            ItemRowData("Broccoli", "A green broccoli", 40),
            ItemRowData("Broccoli", "A green broccoli", 40),
            ItemRowData("Broccoli", "A green broccoli", 40)
        )

        recyclerView.adapter = CustomAdapter(items)
        recyclerView.addItemDecoration(StickyHeaderItemDecoration(recyclerView.adapter as CustomAdapter))
    }


}