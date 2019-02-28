package com.production.outlau.codenamesti.activities;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.production.outlau.codenamesti.R;
import com.production.outlau.codenamesti.controllers.SoundCardAdapter;
import com.production.outlau.codenamesti.controllers.VolleyHelper;
import com.production.outlau.codenamesti.helpers.RecyclerViewHelper;
import com.production.outlau.codenamesti.interfaces.VolleyCallback;
import com.production.outlau.codenamesti.models.SoundCard;

import org.json.JSONArray;

import java.util.ArrayList;

public class SoundsActivity extends Fragment {

    private RecyclerView recyclerView;
    private SoundCardAdapter soundListAdapter;
    private ArrayList<SoundCard> soundCardList;

    ProgressBar loadingIcon;
    TextView errorMsg;
    VolleyHelper volleyHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.activity_sounds, parent, false);

        loadingIcon = v.findViewById(R.id.loading_icon);
        errorMsg = v.findViewById(R.id.error_message);

        recyclerView = v.findViewById(R.id.recycler_view);

        soundCardList = new ArrayList<>();
        soundListAdapter = new SoundCardAdapter(getContext(), soundCardList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new RecyclerViewHelper(3, 10, true, getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(soundListAdapter);

        prepareCards();

//        try {
//            Glide.with(this).load(R.drawable.backdrop_gradient).into((ImageView) findViewById(R.id.backdrop));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return v;
    }

    private void prepareCards() {
        volleyHelper = new VolleyHelper(getContext());
        volleyHelper.getString("sounds", new VolleyCallback() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONArray jsonArray = new JSONArray(result);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        String audioFile = jsonArray.getString(i);
                        soundCardList.add(new SoundCard(audioFile, volleyHelper.url+"sounds/"+audioFile));
                    }

                } catch (Exception e) {
                    System.out.println("My App" + "Could not parse malformed JSON: \"" + result + "\"");
                    System.out.println(e);
                }
            }
            @Override
            public void onError(String error){
                //TODO
                errorMsg.setText(error);
                errorMsg.setVisibility(View.VISIBLE);
            }
            @Override
            public void onResponse(){
                loadingIcon.setVisibility(View.GONE);
            }
        });
//        soundCardList.add(new SoundCard("Python", "https://www.tutorialspoint.com/python/", "https://www.tutorialspoint.com/python/images/python-mini.jpg"));
//        soundCardList.add(new SoundCard("Javascript", "https://www.tutorialspoint.com/javascript/", "https://www.tutorialspoint.com/javascript/images/javascript-mini-logo.jpg"));
//        soundCardList.add(new SoundCard("Cprogramming", "https://www.tutorialspoint.com/cprogramming/", "https://www.tutorialspoint.com/cprogramming/images/c-mini-logo.jpg"));
//        soundCardList.add(new SoundCard("Cplusplus", "https://www.tutorialspoint.com/cplusplus/", "https://www.tutorialspoint.com/cplusplus/images/cpp-mini-logo.jpg"));
//        soundCardList.add(new SoundCard("Android", "https://www.tutorialspoint.com/android/", "https://www.tutorialspoint.com/android/images/android-mini-logo.jpg"));

        soundListAdapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */

    // TODO
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        // TODO
////        soundListAdapter.stopConnection();
//    }
}
