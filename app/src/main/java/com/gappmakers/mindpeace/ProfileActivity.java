package com.gappmakers.mindpeace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {

    private Button mbacktomain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mbacktomain = (Button) findViewById(R.id.backtomain);
        mbacktomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logintent = new Intent(ProfileActivity.this,MainActivity.class);
                startActivity(logintent);
            }
        });


    }
}
