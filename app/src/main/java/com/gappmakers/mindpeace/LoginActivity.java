package com.gappmakers.mindpeace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPassword;
    private Button mLogin;
    private Button mRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEmail = (EditText) findViewById(R.id.logemail);
        mPassword=(EditText)findViewById(R.id.logpassword);
        mLogin=(Button)findViewById(R.id.logbtn);
        mRegister = (Button)findViewById(R.id.regbtn);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regintent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(regintent);
            }
        });
    }
}
