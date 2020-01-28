package com.mad.cekdokter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "LoginActivity";

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private EditText edtEmail;
    private EditText edtPass;
    private Button btnMasuk;

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

    private void signIn(){
        Log.d(TAG,"signIn");
        if(!validateForm()){
            return;
        }

        String email=edtEmail.getText().toString();
        String password =edtPass.getText().toString();

        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG,"signIn:onComplete:"+task.isSuccessful());

                        if(task.isSuccessful()){
                            onAuthSuccess(task.getResult().getUser());
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Sign In Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void onAuthSuccess(FirebaseUser user){
        String username =usernameFromEmail(user.getEmail());

        Toast.makeText(MainActivity.this,"Login Berhasil",Toast.LENGTH_SHORT).show();

        startActivity(new Intent(MainActivity.this, Chat.class));
        finish();
    }

    private String usernameFromEmail(String email){
        if(email.contains("@")){
            return email.split("@")[0];
        }else{
            return email;
        }
    }

    private boolean validateForm(){
        boolean result=true;

        if(TextUtils.isEmpty(edtEmail.getText().toString())){
            edtEmail.setError("Required");
            result=false;
        }else{
            edtEmail.setError(null);
        }

        if(TextUtils.isEmpty(edtPass.getText().toString())){
            edtPass.setError("Required");
            result=false;
        }
        else{
            edtPass.setError(null);
        }
        return result;
    }

    public void onClick(View v){
        int i=v.getId();
        if(i==R.id.btnLogin){
            signIn();
        }
    }

    public void daftarAkun(View view){
        Intent intent = new Intent(getApplicationContext(),DaftarAkun.class);
        startActivity(intent);
    }
}
