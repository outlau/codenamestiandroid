package com.production.outlau.codenamesti;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.production.outlau.codenamesti.activities.MessagingActivity;
import com.production.outlau.codenamesti.activities.PicturesActivity;
import com.production.outlau.codenamesti.activities.SoundsActivity;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void GoToPictures(View v){
        Intent intent = new Intent(this, PicturesActivity.class);
        startActivity(intent);
    }


    public void GoToSounds(View v){
        Intent intent = new Intent(this, SoundsActivity.class);
        startActivity(intent);
    }

    public void GoToMessaging(View v){
        Intent intent = new Intent(this, MessagingActivity.class);
        startActivity(intent);
    }
}
