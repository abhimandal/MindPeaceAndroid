package com.gappmakers.mindpeace;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
        adapter.AddFragment(new FragmentHome(),"Home");
        adapter.AddFragment(new FragmentTrip(),"Trip");
        adapter.AddFragment(new FragmentMore(),"More");
        //Add setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }}