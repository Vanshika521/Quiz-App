package com.codsoft.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity {

//Declaration

    public static final String TAG = "TAG";
    String UserId;
    EditText mFullname,mEmail,mPassword,mPhone;
    Button registerBtn;
    TextView loginBtn;
    ProgressBar progressBar;
    FirebaseAuth fauth;
    FirebaseFirestore fstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
     /*   ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
//Definition
        mFullname = findViewById(R.id.fullname);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mPhone = findViewById(R.id.phone);

        registerBtn = findViewById(R.id.registerBtn);

        loginBtn = findViewById(R.id.loginBtn);

        progressBar = findViewById(R.id.progressbar);

        fauth = FirebaseAuth.getInstance() ;
        fstore = FirebaseFirestore.getInstance() ;

   /*     //If User Get Successfully Logged In then it will redirect it to the MainActivity.xml file...
        if(fauth.getCurrentUser() != null) {
            Intent intent = new Intent(getApplicationContext(), login.class);
            startActivity(intent);
            finish();
        }*/

        //Defining Movement From register.xml to login.xml

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (register.this,login.class);
                startActivity(intent);
            }
        });

        //Defining Functionality of Register Button

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//Password is not set to FINAL because pwd can be change by time but other fields are permanent....
                String password = mPassword.getText().toString().trim();
                final String email = mEmail.getText().toString().trim();
                final String fullname = mFullname.getText().toString();
                final String phone = mPhone.getText().toString();

                if(TextUtils.isEmpty(fullname)){
                    mFullname.setError("Fullname Is Required");
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email Is Required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password Is Required");
                    return;
                }

                if (password.length()<6){
                    mPassword.setError("Password Must be 6 Characters Long");
                    return;
                }

                if(TextUtils.isEmpty(phone)){
                    mPhone.setError("Phone Number Is Required");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                fauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            FirebaseUser fuser = fauth.getCurrentUser();
                            fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                //Success (Account Created) Failure (Mail Not Sent)
                                public void onSuccess(Void unused) {
                                    Toast.makeText(register.this,"REGISTRATION SUCCESSFULLY COMPLETED!!!",Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG,"OnFailure: Email Not Sent"+e.getMessage());
                                }
                            });

                            Toast.makeText(register.this,"User Created",Toast.LENGTH_SHORT).show();
                            UserId = fauth.getCurrentUser().getUid();
                            DocumentReference documentReference = fstore.collection("users").document(UserId);
                            Map<String,Object> user = new HashMap<>();
                            user.put("fName",fullname);
                            user.put("email",email);
                            user.put("phone",phone);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d(TAG,"onSuccess:user profile is created for "+ UserId );
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG,"onFailure: "+e.toString());

                                }
                            });

                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }

                        else {
                            Toast.makeText(register.this,"ERROR!!!"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });



//Member function intent


            }
        });

    }
}