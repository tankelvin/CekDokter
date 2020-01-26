package com.mad.cekdokter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Janji extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.janji);
    }

    public void article(View view){
        Intent intent = new Intent(getApplicationContext(),Article.class);
        startActivity(intent);
    }

    public void chat(View view){
        Intent intent = new Intent(getApplicationContext(),Chat.class);
        startActivity(intent);
    }
}
