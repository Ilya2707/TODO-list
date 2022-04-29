package com.example.mytodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    Button btnSaveText;
    EditText etText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnSaveText=(Button) findViewById(R.id.btnSaveText);
        etText=(EditText) findViewById(R.id.etText);
        btnSaveText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("note", etText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();

    }
}