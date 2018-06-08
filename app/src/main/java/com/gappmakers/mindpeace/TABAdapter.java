package com.gappmakers.mindpeace;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TABAdapter extends FragmentPagerAdapter {

    private final List<Fragment>fragmentList = new ArrayList<>();
    private  final  List<String>FragmentListTitles = new ArrayList<>();


    public TABAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return FragmentListTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return FragmentListTitles.get(position);
    }
    public void AddFragment(FragmentTrip fragment, String Title){
        fragmentList.add(fragment);
        FragmentListTitles.add(Title);

    }
    public void AddFragment(FragmentHome fragment, String Title){
        fragmentList.add(fragment);
        FragmentListTitles.add(Title);

    }
    public void AddFragment(FragmentMore fragment, String Title){
        fragmentList.add(fragment);
        FragmentListTitles.add(Title);

    }

}
