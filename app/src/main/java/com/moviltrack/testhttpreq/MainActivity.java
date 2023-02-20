package com.moviltrack.testhttpreq;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

import static com.loopj.android.http.RequestParams.APPLICATION_JSON;

public class MainActivity extends AppCompatActivity {

    String URL="http://192.168.0.47:3000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        RequestParams params = new RequestParams();

        params.put( "lat", "latitud"  );
        params.put( "lon", "longitud" );
        params.setContentEncoding( "UTF-8" );



            httpReq(params);



    }

    private boolean httpReq(RequestParams params)  {

        AsyncHttpClient client = new AsyncHttpClient();
        StringEntity entity = null ;






        try {
            entity = new StringEntity( APPLICATION_JSON ) ;
        } catch ( UnsupportedEncodingException e ) {
            e . printStackTrace () ;
        }
        client.post(URL,params,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess( statusCode, headers, response );
                Log.d( "PRUEBA", "onSuccess: "+statusCode+ "  "+response.toString() );


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure( statusCode, headers, throwable, errorResponse );

                Log.e( "PRUEBA", "onError: "+statusCode+ "  "+throwable );
            }
        } );
        return true;
    }

}