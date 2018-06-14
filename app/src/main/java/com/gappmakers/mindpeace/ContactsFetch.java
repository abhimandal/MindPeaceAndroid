package com.gappmakers.mindpeace;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ContactsFetch extends AppCompatActivity {

    ListView L1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        L1 = (ListView)findViewById(R.id.MyContactsView);


    }

    public void get(View v) {
        Cursor cursor =
                getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null, null, null, null);

        startManagingCursor(cursor);

        String[] from = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone._ID};

        int[] to = {android.R.id.text1, android.R.id.text2};

        SimpleCursorAdapter simpleCursorAdapter =
                new SimpleCursorAdapter(this,
                        android.R.layout.simple_list_item_2,
                        cursor, from, to);

        L1.setAdapter(simpleCursorAdapter);
        L1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }


}

