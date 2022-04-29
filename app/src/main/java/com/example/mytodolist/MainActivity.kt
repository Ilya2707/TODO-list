package com.example.mytodolist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var list = ArrayList<String>()
    val activityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val data=result.data
        var text:String?=data?.getStringExtra("note")
        if (text != null) {
            list.add(text)
            val listNotes:ListView=findViewById(R.id.listNotes)
            val adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list)
            listNotes.adapter=adapter}
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addButton: Button = findViewById(R.id.button2)
        addButton.setOnClickListener {
            val intent= Intent(this,MainActivity2::class.java)
            activityLauncher.launch(intent)}
    }

}
