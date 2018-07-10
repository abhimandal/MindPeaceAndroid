package com.gappmakers.mindpeace;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentBefo extends Fragment {
    View view;
    Context c;
    public FragmentBefo() {

    }
    @SuppressLint("ValidFragment")

    public FragmentBefo(Context context) {
        c=context;
    }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.befo_fragment,container,false);
        return view;


    }

}

