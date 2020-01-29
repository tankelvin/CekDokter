package com.mad.cekdokter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class Chat extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private EditText edtEmail;
    private EditText edtPass;
    private Button btnMasuk;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
    }

    public void janji(View view){
        Intent intent = new Intent(Chat.this,Janji.class);
        startActivity(intent);
        finish();
    }

    public void article(View view){
        Intent intent = new Intent(Chat.this,Article.class);
        startActivity(intent);
        finish();
    }
}
