package com.codsoft.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    EditText mEmail,mPassword;
    Button loginBtn;
    TextView mregisterBtn;
    ProgressBar progressBar;
    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);

        mregisterBtn = findViewById(R.id.registerBtn);
        loginBtn = findViewById(R.id.loginBtn);

        progressBar = findViewById(R.id.progressbar);

        fauth = FirebaseAuth.getInstance();

 /*       mregisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(login.this, "Register Button Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(login.this, register.class);
                Toast.makeText(login.this, "I m here", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                Toast.makeText(login.this, "Done!!!", Toast.LENGTH_SHORT).show();
            }
        });
*/

        mregisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(login.this, "REDIRECTING.....", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(login.this, register.class));
                Toast.makeText(login.this, "REDIRECED!!!!!!!!!!!", Toast.LENGTH_SHORT).show();
            }
        });


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email Is Required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password Is Required");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                fauth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(login.this,"LOGIN SUCCESSFULLY DONE!!!",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }

                        else {
                            Toast.makeText(login.this,"ERROR!!!"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

            }
        });

    }
}