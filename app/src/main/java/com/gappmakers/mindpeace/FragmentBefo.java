package com.gappmakers.mindpeace;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentBefo extends Fragment {
    View view;
    public FragmentBefo() {

    }
    @Nullable
    @Override


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.befo_fragment,container,false);
        return view;


    }

   // public void NewTrip(View view) {
        //Intent newTrip = new Intent(this,NewTrip.class);
        //startActivity(newTrip);
    //}

}

