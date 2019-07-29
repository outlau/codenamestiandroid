package com.production.outlau.codenamesti.helpers;

import android.app.DownloadManager;
import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.production.outlau.codenamesti.interfaces.VolleyCallback;

public class VolleyHelper {

//    public String url ="http://10.0.2.2:3000/api/";
    public String url ="http://stidiblitzi.com/api/";
    private Context context;

    public VolleyHelper(Context context){
        this.context = context;
    }

    public void getString(String subUrl, final VolleyCallback callback) {
        RequestQueue queue = Volley.newRequestQueue(context);
        String requestUrl = url + subUrl;

        System.out.println("GO GET STRING");
        StringRequest stringRequest = new StringRequest(Request.Method.GET, requestUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("RESPONSE GET STRING");
                        // Display the first 500 characters of the response string.
                        callback.onSuccess(response);
                        callback.onResponse();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                String message = null;
                if (volleyError instanceof NetworkError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (volleyError instanceof ServerError) {
                    message = "Server error. Uh oh!";
                } else if (volleyError instanceof AuthFailureError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (volleyError instanceof ParseError) {
                    message = "Parsing error! Please try again after some time!!";
                } else if (volleyError instanceof NoConnectionError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (volleyError instanceof TimeoutError) {
                    message = "Connection TimeOut! Please check your internet connection.";
                } else {
                    message = volleyError.toString();
                }
                callback.onError(message);
                callback.onResponse();
            }
        });

        queue.add(stringRequest);
    }
}
