package com.example.mytodolist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val btnSaveText:Button=findViewById(R.id.btnSaveText)
        val etText:EditText=findViewById(R.id.etText)
        btnSaveText.setOnClickListener(){
            intent.putExtra("note",etText.getText().toString())
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}