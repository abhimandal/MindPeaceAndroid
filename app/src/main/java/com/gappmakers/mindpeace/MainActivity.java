package com.gappmakers.mindpeace;

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
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {


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

        // this intend should be deleted
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);

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

        public boolean onOptionsItemSelected (MenuItem item){

            if(mToggle.onOptionsItemSelected(item)){return true;}
            return super.onOptionsItemSelected(item);
        }
        public void NewTrip(View view) {
        Intent newTrip = new Intent(this,NewTrip2.class);
        startActivity(newTrip);
        }
    public void MapTrip(View view) {
        Intent MapTrip = new Intent(this,MapsActivity.class);
        startActivity(MapTrip);
    }

}