package com.gappmakers.mindpeace;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentNotification extends Fragment{
    View view;
    Context c;
    @SuppressLint("ValidFragment")
    public FragmentNotification(Context context) {
        c=context;
    }
    public FragmentNotification() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.notification_fragment,container,false);
        return view;
    }
}
