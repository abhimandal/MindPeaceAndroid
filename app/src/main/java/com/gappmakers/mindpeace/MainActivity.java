package com.gappmakers.mindpeace;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarid);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        TABAdapter adapter = new TABAdapter(getSupportFragmentManager());
        //Add Fragments
        adapter.AddFragment(new FragmentBefo(),"BEFO");
        adapter.AddFragment(new FragmentFollo(),"FOLLO");
        adapter.AddFragment(new FragmentNotification(),"Notification");
        //Add setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
    public void NewTrip(View view) {
        Intent newTrip = new Intent(this,NewTrip.class);
        startActivity(newTrip);
        }
}