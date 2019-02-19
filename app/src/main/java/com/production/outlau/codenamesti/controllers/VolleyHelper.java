package com.production.outlau.codenamesti.controllers;

import android.app.DownloadManager;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.production.outlau.codenamesti.interfaces.VolleyCallback;

public class VolleyHelper {

    private Context context;

    public VolleyHelper(Context context){
        this.context = context;
    }


    public void getString(String subUrl, final VolleyCallback callback) {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="http://10.0.2.2:3000/api/" + subUrl;

        System.out.println("GO GET STRING");
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("RESPONSE GET STRING");
                        // Display the first 500 characters of the response string.
                        callback.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("ERROR GET STRING"+error);
            }
        });

        queue.add(stringRequest);
    }
}
