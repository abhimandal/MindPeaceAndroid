package com.gappmakers.mindpeace.models;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gappmakers.mindpeace.NewTrip;
import com.gappmakers.mindpeace.R;


class ConfirmPage extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Intent importdata = getIntent();


        String Destination= importdata.getStringExtra("Destination");
        TextView z= findViewById(R.id.destination);
        z.setText(Destination);
        String Source= importdata.getStringExtra("Source");
        TextView meh= findViewById(R.id.source);
        meh.setText(Source);


    }
    public void GotoTripPage(View view) {   //activate the sos
        EditText et = (EditText)findViewById(R.id.desiredDuration);
        String time= et.getText().toString();
        Intent newtrip = new Intent(this,NewTrip.class);
        newtrip.putExtra("time",time);
        startActivity(newtrip);
    }
}
