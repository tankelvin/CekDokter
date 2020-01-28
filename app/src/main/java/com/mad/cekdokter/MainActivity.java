package com.mad.cekdokter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private EditText edtEmail;
    private EditText edtPass;
    private Button btnMasuk;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        edtEmail = (EditText) findViewById(R.id.emailLogin);
        edtPass = (EditText) findViewById(R.id.passwordLogin);
        btnMasuk = (Button) findViewById(R.id.btnLogin);

        //nambahin method onClick, biar tombolnya bisa diklik
        btnMasuk.setOnClickListener(this);
    }


    public void daftarAkun(View view){
        Intent intent = new Intent(getApplicationContext(),DaftarAkun.class);
        startActivity(intent);
    }
}
