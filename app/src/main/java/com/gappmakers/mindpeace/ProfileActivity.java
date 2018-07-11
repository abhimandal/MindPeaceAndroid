package com.gappmakers.mindpeace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "hallo";
    private Button mbacktomain;
    private Button saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        saveButton = (Button) findViewById(R.id.saveUserInfo);
        mbacktomain = (Button) findViewById(R.id.continueButton);

        mbacktomain.setOnClickListener(new View.OnClickListener() { public void onClick(View v) {
            Intent logintent = new Intent(ProfileActivity.this,MainActivity.class);
            startActivity(logintent);
        }
        });

        saveButton.setOnClickListener(new View.OnClickListener() { public void onClick(View v) {


            if (TextUtils.isEmpty(String.valueOf(R.id.phoneNo)) || TextUtils.isEmpty(String.valueOf(R.id.displayName))) {
                Toast.makeText(ProfileActivity.this, "Please enter email", Toast.LENGTH_LONG).show();
                return;
            }

            else
                Toast.makeText(ProfileActivity.this, "User Info Saved", Toast.LENGTH_LONG).show();
        }
        });


        if (TextUtils.isEmpty(String.valueOf(R.id.phoneNo))) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(String.valueOf(R.id.displayName))) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;

        }


    }

}
