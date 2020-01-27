package com.mad.cekdokter;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Article extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article);
    }

    public void chat(View view){
        Intent intent = new Intent(Article.this,Chat.class);
        startActivity(intent);
        finish();

    }

    public void janji(View view){
        Intent intent = new Intent(Article.this,Janji.class);
        startActivity(intent);
        finish();
    }
}
