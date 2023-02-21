package com.moviltrack.testhttpreq;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class HttpReqest {
    public static void post(Context context, String URL, JSONObject json) {

        AsyncHttpClient client = new AsyncHttpClient();

        StringEntity entity = new StringEntity( json.toString(), "UTF-8" );


        client.post(
                context,
                URL,
                entity,
                "application/json",
                new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        Log.d( "PRUEBA", "onSuccess: " + statusCode + "  " + response.toString() );


                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure( statusCode, headers, throwable, errorResponse );

                        Log.e( "PRUEBA", "onError: " + statusCode + "  " + throwable );
                    }
                } );

    }


}
