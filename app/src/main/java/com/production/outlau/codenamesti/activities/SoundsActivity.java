package com.production.outlau.codenamesti.activities;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.production.outlau.codenamesti.R;
import com.production.outlau.codenamesti.controllers.SoundListAdapter;
import com.production.outlau.codenamesti.helpers.RecyclerViewHelper;
import com.production.outlau.codenamesti.models.SoundCard;

import java.util.ArrayList;

public class SoundsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SoundListAdapter soundListAdapter;
    private ArrayList<SoundCard> soundCardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounds);

        recyclerView = findViewById(R.id.recycler_view);

        soundCardList = new ArrayList<>();
        soundListAdapter = new SoundListAdapter(this, soundCardList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new RecyclerViewHelper(1, 10, true, this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(soundListAdapter);

        prepareCards();

//        try {
//            Glide.with(this).load(R.drawable.backdrop_gradient).into((ImageView) findViewById(R.id.backdrop));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }


    /**
     * Adding few albums for testing
     */
    private void prepareCards() {

        soundCardList.add(new SoundCard("JAVA", "https://www.tutorialspoint.com/java/", "https://www.tutorialspoint.com/java/images/java-mini-logo.jpg"));
        soundCardList.add(new SoundCard("Python", "https://www.tutorialspoint.com/python/", "https://www.tutorialspoint.com/python/images/python-mini.jpg"));
        soundCardList.add(new SoundCard("Javascript", "https://www.tutorialspoint.com/javascript/", "https://www.tutorialspoint.com/javascript/images/javascript-mini-logo.jpg"));
        soundCardList.add(new SoundCard("Cprogramming", "https://www.tutorialspoint.com/cprogramming/", "https://www.tutorialspoint.com/cprogramming/images/c-mini-logo.jpg"));
        soundCardList.add(new SoundCard("Cplusplus", "https://www.tutorialspoint.com/cplusplus/", "https://www.tutorialspoint.com/cplusplus/images/cpp-mini-logo.jpg"));
        soundCardList.add(new SoundCard("Android", "https://www.tutorialspoint.com/android/", "https://www.tutorialspoint.com/android/images/android-mini-logo.jpg"));

        soundListAdapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // TODO
//        soundListAdapter.stopConnection();
    }
}
