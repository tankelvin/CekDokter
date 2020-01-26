package com.mad.cekdokter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DaftarAkun extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_akun);
    }

    public void daftarAkun(View view){
        Intent intent = new Intent(getApplicationContext(),Chat.class);
        startActivity(intent);
    }
}
