package com.gappmakers.mindpeace;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Home_Fragment extends Fragment{

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    View view;
    Context c;
    @SuppressLint("ValidFragment")
    public Home_Fragment(Context context) {
        c=context;
    }
    public Home_Fragment() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment,container,false);
//        tabLayout = (TabLayout) view.findViewById(R.id.tablayout_id);
//        //appBarLayout = (AppBarLayout) findViewById(R.id.appbarid);
//        viewPager = (ViewPager) view.findViewById(R.id.viewpager_id);
//        TABAdapter adapter = new TABAdapter(getFragmentManager());
//        //Add Fragments
//        adapter.AddFragment(new FragmentBefo(),"BEFO");
//        adapter.AddFragment(new FragmentFollo(),"FOLLO");
//        // adapter.AddFragment(new Home_Fragment(),"Notifications");
//
//        //Add setup
//        viewPager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}
