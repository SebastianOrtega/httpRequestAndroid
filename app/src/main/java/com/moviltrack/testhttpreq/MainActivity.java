package com.moviltrack.testhttpreq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    String URL = "http://192.168.0.47:3000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        JSONObject json = new JSONObject();
        try {
            json.put( "app_key", "appKey" );
        } catch (JSONException e) {
            Log.e( "PRUEBA", e.getMessage() );
        }


        HttpReqest.post( this, URL, json );


    }
}