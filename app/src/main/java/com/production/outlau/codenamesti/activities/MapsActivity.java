package com.production.outlau.codenamesti.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.production.outlau.codenamesti.R;
import com.production.outlau.codenamesti.controllers.VolleyHelper;
import com.production.outlau.codenamesti.interfaces.VolleyCallback;

import org.json.JSONArray;
import org.json.JSONObject;

public class MapsActivity extends Fragment implements OnMapReadyCallback {

    VolleyHelper volleyHelper;

    private FragmentActivity mContext;

    private GoogleMap mMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.activity_maps, parent, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        volleyHelper = new VolleyHelper(getContext());
        volleyHelper.getString("coordinates", new VolleyCallback() {
            @Override
            public void onSuccess(String result) {
                setMarkers(result);
            }
            @Override
            public void onError(String error) {
                // TODO
            }
            @Override
            public void onResponse() {

            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        mContext = (FragmentActivity) context;
        super.onAttach(context);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    private void setMarkers(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                float latitude = (float)jsonObject.getDouble("latitude");
                float longitude = (float)jsonObject.getDouble("longitude");
                String name = jsonObject.getString("name");

                LatLng location = new LatLng(latitude, longitude);
                mMap.addMarker(new MarkerOptions().position(location).title("Marker in "+name));
                if(i == 0) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
                }
                System.out.println("latitude"+latitude);
                System.out.println("longitude"+longitude);
                System.out.println("name"+name);
            }
        } catch (Exception e) {
            System.out.println("My App" + "Could not parse malformed JSON: \"" + json + "\"");
            System.out.println(e);
        }
    }
}