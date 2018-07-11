package com.gappmakers.mindpeace;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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


public class LoginActivity extends AppCompatActivity {

    private static final String TAG ="" ;
    private EditText mEmail;
    private EditText mPassword;
    private Button mLogin;
    private TextView mRegister;
    //firebase auth object
    private FirebaseAuth firebaseAuth;      //1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initializing firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();


        if (firebaseAuth.getCurrentUser() != null) {
            //that means user is already logged in
            //so close this activity
            finish();

            //and open profile activity
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        mEmail = (EditText) findViewById(R.id.logemail);
        mPassword = (EditText) findViewById(R.id.logpassword);
        mLogin = (Button) findViewById(R.id.logbtn);
        mRegister = (TextView) findViewById(R.id.toregpage);


        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logintent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(logintent);
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });

    }

    private void userLogin() {
        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();


        //checking if email and passwords are empty
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
//
                        //if the task is successfull
                        if (task.isSuccessful()) {
                            //start the profile activity
                            finish();

                            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                            finish();
                        }
                        else{
                            //display some message here
                            Toast.makeText(LoginActivity.this,"Check Email or Password ",Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }
}
