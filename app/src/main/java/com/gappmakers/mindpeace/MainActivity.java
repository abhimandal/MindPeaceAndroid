package com.gappmakers.mindpeace;

import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    FragmentNotification n = new FragmentNotification(this);
    FragmentBefo b = new FragmentBefo(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        //appBarLayout = (AppBarLayout) findViewById(R.id.appbarid);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        TABAdapter adapter = new TABAdapter(getSupportFragmentManager());
        //Add Fragments
        adapter.AddFragment(new FragmentBefo(),"BEFO");
        adapter.AddFragment(new FragmentFollo(),"FOLLO");
        adapter.AddFragment(new FragmentNotification(),"Notifications");

        //Add setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
       mDrawerLayout= (DrawerLayout)findViewById(R.id.drawerlayout_id);
       mToggle= new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close );
       mDrawerLayout.addDrawerListener(mToggle);
       mToggle.syncState();
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final NavigationView navigation = (NavigationView) findViewById(R.id.nav_view);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id=item.getItemId();
                switch(item.getItemId()) {
//                    case R.id.nav_home:
//                        return true;
//                    case R.id.nav_befo:
//                        return true;
//                    case R.id.nav_follo:
//                        return true;
                    case R.id.nav_setting:
                        return true;
                    case R.id.nav_delete:
                        return true;
                    case R.id.nav_about:
                        return true;
                    default:
                        return false;
                }

              //  if (id == R.id.nav_home) {
               //     startActivity(new Intent(, FragmentNotification.class));
               // } else if (id == R.id.nav_befo) {
               //     startActivity(new Intent(this, FragmentBefo.class));
               // }
            }
        });
    }

        public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");
        int available= GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);
        if(available== ConnectionResult.SUCCESS){
            Log.d(TAG, "isServicesOK: checking google services is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            Log.d(TAG, "isServicesOK: error occured but can be fixed");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this,available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }
        else{
            Toast.makeText(this, "you can't make map request",Toast.LENGTH_SHORT).show();
        }
        return false;
        }

        public boolean onOptionsItemSelected (MenuItem item){

            if(mToggle.onOptionsItemSelected(item)){return true;}
            return super.onOptionsItemSelected(item);
        }
        public void NewTrip(View view) {
        if(isServicesOK()) {
            Intent newTrip = new Intent(this, NewTrip.class);
            startActivity(newTrip);
        }
        }

}