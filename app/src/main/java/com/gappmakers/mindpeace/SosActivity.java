package com.gappmakers.mindpeace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SosActivity extends AppCompatActivity {


    private Button mbtsyes ;
    private Button mbtsno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);
        mbtsyes = (Button) findViewById(R.id.btsyes);
        mbtsno = (Button) findViewById(R.id.btsno);

        mbtsyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sossentintent = new Intent(SosActivity.this,MainActivity.class);
                startActivity(sossentintent);
        Toast.makeText(SosActivity.this,"SOS SENT ",Toast.LENGTH_LONG).show();
            }
        });

        mbtsno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent soscancelintent = new Intent(SosActivity.this,MainActivity.class);
                startActivity(soscancelintent);
                Toast.makeText(SosActivity.this,"SOS CANCELLED ",Toast.LENGTH_LONG).show();

            }
        });

    }
}
