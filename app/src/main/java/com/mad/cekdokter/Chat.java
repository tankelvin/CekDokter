package com.mad.cekdokter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Chat extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
    }

    public void janji(View view){
        Intent intent = new Intent(getApplicationContext(),Janji.class);
        startActivity(intent);
    }

    public void article(View view){
        Intent intent = new Intent(getApplicationContext(),Article.class);
        startActivity(intent);
    }
}
