package com.mad.cekdokter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.mad.cekdokter.table.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class DaftarAkun extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "LoginActivity";

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private EditText edtEmail;
    private EditText edtPass;
    private EditText edtNama;
    private EditText edtNoHp;
    private Button btndaftar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_akun);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        edtNama = (EditText)findViewById(R.id.nama);
        edtEmail = (EditText)findViewById(R.id.email);
        edtPass = (EditText)findViewById(R.id.password);
        edtNoHp=(EditText) findViewById(R.id.nohp);
        btndaftar = (Button) findViewById(R.id.btnDaftar);

        btndaftar.setOnClickListener(this);
    }

    private void signUp(){
        Log.d(TAG,"signUp");
        if(!validateForm()){
            return;
        }

        String nama=edtNama.getText().toString();
        String email=edtEmail.getText().toString();
        String password=edtPass.getText().toString();
        String nohp=edtNoHp.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUser:onComplete:" + task.isSuccessful());
                        //hideProgressDialog();

                        if (task.isSuccessful()) {
                            onAuthSuccess(task.getResult().getUser());
                        } else {
                            Toast.makeText(DaftarAkun.this, "Sign Up Failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void onAuthSuccess(FirebaseUser user) {
        String username = usernameFromEmail(user.getEmail());

        // membuat User baru
        writeNewUser(user.getUid(), username, user.getEmail());

    }

    private void writeNewUser(String userId, String name, String email) {
        User user = new User(name,email);

        mDatabase.child("user").child(userId).setValue(user);
    }

    private boolean validateForm() {
        boolean result = true;
        if (TextUtils.isEmpty(edtEmail.getText().toString())) {
            edtEmail.setError("Required");
            result = false;
        } else {
            edtEmail.setError(null);
        }

        if (TextUtils.isEmpty(edtPass.getText().toString())) {
            edtPass.setError("Required");
            result = false;
        } else {
            edtPass.setError(null);
        }

        if (TextUtils.isEmpty(edtNama.getText().toString())) {
            edtNama.setError("Required");
            result = false;
        } else {
            edtNama.setError(null);
        }

        if (TextUtils.isEmpty(edtNoHp.getText().toString())) {
            edtNoHp.setError("Required");
            result = false;
        } else {
            edtNoHp.setError(null);
        }

        return result;
    }

    private String usernameFromEmail(String email) {
        if (email.contains("@")) {
            return email.split("@")[0];
        } else {
            return email;
        }
    }

    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btnDaftar) {
            signUp();
        }
    }

}
