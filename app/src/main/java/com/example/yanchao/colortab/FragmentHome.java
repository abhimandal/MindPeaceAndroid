package com.example.yanchao.colortab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;

public class FragmentHome extends Fragment {
    View view;
    public FragmentHome() {
    }
    @Nullable
    @Override


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment,container,false);
        Button button1=(Button) view.findViewById(R.id.NewTrip);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   Intent intent1 = new Intent(getActivity(),Newtrip.class);
                   startActivity(intent1);
                }

        });
        return view;

    }






}

