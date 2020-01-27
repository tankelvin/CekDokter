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
        Intent intent = new Intent(Janji.this,Article.class);
        startActivity(intent);
        finish();
    }

    public void chat(View view){
        Intent intent = new Intent(Janji.this,Chat.class);
        startActivity(intent);
        finish();
    }
}
