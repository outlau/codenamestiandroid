package com.production.outlau.codenamesti.activities;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.production.outlau.codenamesti.R;
import com.production.outlau.codenamesti.controllers.ImageListAdapter;
import com.production.outlau.codenamesti.controllers.SoundListAdapter;
import com.production.outlau.codenamesti.models.SoundCard;
import com.production.outlau.codenamesti.services.MediaPlayerService;

import java.util.ArrayList;

public class SoundsActivity extends AppCompatActivity {

    SoundListAdapter soundListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounds);


//        playAudio("https://upload.wikimedia.org/wikipedia/commons/6/6c/Grieg_Lyric_Pieces_Kobold.ogg");

        final ListView list = findViewById(R.id.list);
        ArrayList<SoundCard> arrayList = new ArrayList<>();
        arrayList.add(new SoundCard("JAVA", "https://www.tutorialspoint.com/java/", "https://www.tutorialspoint.com/java/images/java-mini-logo.jpg"));
        arrayList.add(new SoundCard("Python", "https://www.tutorialspoint.com/python/", "https://www.tutorialspoint.com/python/images/python-mini.jpg"));
        arrayList.add(new SoundCard("Javascript", "https://www.tutorialspoint.com/javascript/", "https://www.tutorialspoint.com/javascript/images/javascript-mini-logo.jpg"));
        arrayList.add(new SoundCard("Cprogramming", "https://www.tutorialspoint.com/cprogramming/", "https://www.tutorialspoint.com/cprogramming/images/c-mini-logo.jpg"));
        arrayList.add(new SoundCard("Cplusplus", "https://www.tutorialspoint.com/cplusplus/", "https://www.tutorialspoint.com/cplusplus/images/cpp-mini-logo.jpg"));
        arrayList.add(new SoundCard("Android", "https://www.tutorialspoint.com/android/", "https://www.tutorialspoint.com/android/images/android-mini-logo.jpg"));
        soundListAdapter = new SoundListAdapter(this, arrayList);
        list.setAdapter(soundListAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundListAdapter.stopConnection();
    }

}
