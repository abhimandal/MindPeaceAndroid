package com.gappmakers.mindpeace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SosActivity extends AppCompatActivity {
    private Button msosyes;
    private Button msosno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);
        msosyes = (Button) findViewById(R.id.sosyes);
        msosno= (Button) findViewById(R.id.sosno);

        msosyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendsos = new Intent(SosActivity.this,MainActivity.class);
                startActivity(sendsos);
                Toast.makeText(SosActivity.this, "SOS Sent!", Toast.LENGTH_LONG).show();
            }
        });

        msosno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancelsos = new Intent(SosActivity.this,MainActivity.class);
                startActivity(cancelsos);
                Toast.makeText(SosActivity.this, "Action Cancelled", Toast.LENGTH_LONG).show();
            }
        });


    }
}
