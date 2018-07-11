package com.gappmakers.mindpeace.models;


import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import java.io.IOException;
import java.util.HashMap;


public class GetDirectionsData extends AsyncTask<Object,String,String> {

    GoogleMap mMap;
    String url;
    String googleDirectionsData;

   private String duration, distance;
//   public  exportdata ed;

    LatLng latLng;



    @Override
    protected String doInBackground(Object... objects) {
        mMap = (GoogleMap)objects[0];
        url = (String)objects[1];
        latLng = (LatLng)objects[2];

        DownloadUrl downloadUrl = new DownloadUrl();
        try {
            googleDirectionsData = downloadUrl.readUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return googleDirectionsData;
    }

    @Override
    protected void onPostExecute(String s) {
        HashMap<String, String> directionsList= null;
        DataParser parser = new DataParser();
        directionsList = parser.parseDurandDist(s);
        duration = directionsList.get("duration");
        distance= directionsList.get("distance");
        Log.d("mama", "onClick:Duration "+duration);


        mMap.clear();
        MarkerOptions m = new MarkerOptions();
        m.position(latLng);
        m.draggable(true);
        m.title("Duration =" +duration);
        m.snippet("Distance =" +distance);
        mMap.addMarker(m);
        Log.d("mema", "onClick:Duration "+duration);


        String[] path;
        path= parser.parseDirections(s);
        displayDirection(path);


    }


    public void displayDirection(String[] directionsList)
    {

        int count = directionsList.length;
        for(int i = 0;i<count;i++)
        {
            PolylineOptions options = new PolylineOptions();
            options.color(Color.RED);
            options.width(10);
            options.addAll(PolyUtil.decode(directionsList[i]));

            mMap.addPolyline(options);
        }
    }






}

