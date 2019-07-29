package com.production.outlau.codenamesti.models;

import android.media.AudioManager;
import android.media.MediaPlayer;

import java.io.IOException;

public class SoundCard {
//    public String url = "http://www.hochmuth.com/mp3/Haydn_Cello_Concerto_D-1.mp3";
//    public String url = "https://freewavesamples.com/files/Crash-Cymbal-3.wav";

    public String title;
    public String url;

    public SoundCard(String title, String url) {
        this.title = title;
        this.url = url;
    }
}
