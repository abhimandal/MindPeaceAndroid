package com.gappmakers.mindpeace;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

//import com.gappmakers.mindpeace.models.ConfirmPage;
import com.gappmakers.mindpeace.models.MapsActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private static final String TAG = null ;
    //    private TabLayout tabLayout;
//    private AppBarLayout appBarLayout;
//    private ViewPager viewPager;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private int count =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate:1 ");
        // this intend should be deleted
//            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//            startActivity(intent);
//            finish();

////
//        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
//        //appBarLayout = (AppBarLayout) findViewById(R.id.appbarid);
//        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
//        TABAdapter adapter = new TABAdapter(getSupportFragmentManager());
//        //Add Fragments
//        adapter.AddFragment(new FragmentBefo(),"BEFO");
//        adapter.AddFragment(new FragmentFollo(),"FOLLO");
//       // adapter.AddFragment(new Home_Fragment(),"Notifications");
//
//        //Add setup
//        viewPager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(viewPager);
//        mToggle= new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close );
//       mDrawerLayout.addDrawerListener(mToggle);
//       mToggle.syncState();
//       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

//       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

            mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            mToggle = new ActionBarDrawerToggle(
                    this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            mDrawerLayout.addDrawerListener(mToggle);
            mToggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            //--------------------set the initial fragment-------------------

            Home_Fragment front_page_fragment = new Home_Fragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, front_page_fragment);
            fragmentTransaction.commit();
            //  getSupportActionBar().setTitle("Home");

    }
    public void NewTrip(View view) {  // create new trip
        Intent newTrip = new Intent(this,NewTrip.class);
        startActivity(newTrip);
    }
    public void MapTrip(View view) {  // activate the map
        Intent MapTrip = new Intent(this, MapsActivity.class);
        startActivity(MapTrip);
        
    }
//    public void GotoHome(View view) {
//        Log.d(TAG, "onClick: onClick inside");// activate homepage
//        Home_Fragment front_page_fragment = new Home_Fragment();
//        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_container,front_page_fragment);
//        fragmentTransaction.commit();
//
//    }

    public void Start(View view) {  // start the trip
        Intent starttrip = new Intent(this, MapsActivity.class);
        startActivity(starttrip);
    }
    public void Sos(View view) {   //activate the sos
            Intent Sos = new Intent(this,SosActivity.class);
            startActivity(Sos);
    }
//    public void Next(View view) {   //activate the confirmpage
//        Intent next = new Intent(this,ConfirmPage.class);
//        startActivity(next);
//    }
    public void Befo(View view) {
        FragmentBefo page_fragment = new FragmentBefo();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,page_fragment);
        fragmentTransaction.commit();
    }
    public void Follo(View view) {
        FragmentFollo pfragment = new FragmentFollo();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,pfragment);
        fragmentTransaction.commit();
    }

//        public boolean onOptionsItemSelected (MenuItem item){
//
//            if(mToggle.onOptionsItemSelected(item)){return true;}
//            return super.onOptionsItemSelected(item);
//        }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            //--------------------set the initial fragment-------------------
            Home_Fragment front_page_fragment = new Home_Fragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,front_page_fragment);
            fragmentTransaction.commit();        }

            else if (id == R.id.nav_befo) {
            FragmentBefo front_page_fragment = new FragmentBefo();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,front_page_fragment);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_follo) {
            FragmentFollo front_page_fragment = new FragmentFollo();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,front_page_fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_setting) {
            FragmentSetting front_page_fragment = new FragmentSetting();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,front_page_fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_contact) {
            FragmentContact front_page_fragment = new FragmentContact();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,front_page_fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_about) {
            FragmentAbout front_page_fragment = new FragmentAbout();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,front_page_fragment);
            fragmentTransaction.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}