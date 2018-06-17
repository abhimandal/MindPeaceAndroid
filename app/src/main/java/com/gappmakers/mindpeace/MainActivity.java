package com.gappmakers.mindpeace;

import android.app.FragmentTransaction;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



public class MainActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    android.support.v4.app.FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // ft= getSupportFragmentManager().beginTransaction();
        //ft.add(R.id.framelayout_id, new BlankFragment());
        //ft.commit();
        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        TABAdapter adapter = new TABAdapter(getSupportFragmentManager());
        //Add Fragments
        adapter.AddFragment(new FragmentBefo(),"BEFO");
<<<<<<< HEAD
        adapter.AddFragment(new FragmentFollo(),"FOLLO");
        adapter.AddFragment(new FragmentNotification(),"Notifications");
=======
       adapter.AddFragment(new FragmentFollo(),"FOLLO");
>>>>>>> 69c79868803bc4592ae768d67ffc9d21e794c655

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

                switch(item.getItemId()) {
                    case R.id.nav_home:
                        ft= getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.framelayout_id, new FragmentNotification());
                        ft.commit();
                        //getSupportActionBar().setTitle("HOME");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.nav_befo:
                        ft= getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.framelayout_id, new FragmentBefo());
                        ft.commit();
                        //getSupportActionBar().setTitle("BEFO");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.nav_follo:
                        ft= getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.framelayout_id, new FragmentFollo());
                        ft.commit();
                        //getSupportActionBar().setTitle("FOLLO");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        break;

                   // case R.id.nav_home:
                     //   return true;
                    //case R.id.nav_befo:
                      //  return true;
                    //case R.id.nav_follo:
                      //  return true;
                    //case R.id.nav_setting:
                      //  return true;
                    //case R.id.nav_delete:
                      //  return true;
                    //case R.id.nav_about:
                      //  return true;
                    //default:

                }
                return false;
            }
        });
    }

        public boolean onOptionsItemSelected (MenuItem item){

            if(mToggle.onOptionsItemSelected(item)){return true;}
            return super.onOptionsItemSelected(item);
        }
        public void NewTrip(View view) {
        Intent newTrip = new Intent(this,NewTrip.class);
        startActivity(newTrip);
        }

}