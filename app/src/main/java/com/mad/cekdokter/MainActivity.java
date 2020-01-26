package com.mad.cekdokter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginAkun(View view){
        Intent intent = new Intent(getApplicationContext(),Chat.class);
        startActivity(intent);
    }

    public void daftarAkun(View view){
        Intent intent = new Intent(getApplicationContext(),DaftarAkun.class);
        startActivity(intent);
    }
}
