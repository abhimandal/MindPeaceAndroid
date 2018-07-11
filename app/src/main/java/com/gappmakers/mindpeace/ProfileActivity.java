package com.gappmakers.mindpeace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "hallo";
    private Button mbacktomain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mbacktomain = (Button) findViewById(R.id.backtomain);
        mbacktomain.setOnClickListener(new View.OnClickListener() { public void onClick(View v) {
            Intent logintent = new Intent(ProfileActivity.this,MainActivity.class);
            startActivity(logintent);

        }

        });


    }
//    public void GotoHome(View view) {
//        Log.d(TAG, "onClick: onClick inside");// activate homepage
//        Home_Fragment front_page_fragment = new Home_Fragment();
//        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.fragment_container,front_page_fragment);
//        fragmentTransaction.commit();
//
//    }
}
