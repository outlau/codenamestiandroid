package com.production.outlau.codenamesti;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.production.outlau.codenamesti.activities.CountdownActivity;
import com.production.outlau.codenamesti.activities.MapsActivity;
import com.production.outlau.codenamesti.activities.MessagingActivity;
import com.production.outlau.codenamesti.activities.PicturesActivity;
import com.production.outlau.codenamesti.activities.SoundsActivity;
import com.production.outlau.codenamesti.controllers.MainCardAdapter;
import com.production.outlau.codenamesti.controllers.VolleyHelper;
import com.production.outlau.codenamesti.helpers.RecyclerViewHelper;
import com.production.outlau.codenamesti.interfaces.VolleyCallback;
import com.production.outlau.codenamesti.models.MainCard;
import com.production.outlau.codenamesti.models.SoundCard;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // CMD to run emulator
    //Emulator -avd Nexus_5X_API_24 -partition-size 512 -feature WindowsHypervisorPlatform

    private RecyclerView recyclerView;
    private MainCardAdapter adapter;
    private List<MainCard> mainCardList;

    RelativeLayout backdrop;
    ImageButton backButton;
    LinearLayout fragmentHolder;

    TextView dateTv;
    TextView blitziQuote;

    int backdropExpandedHeight = 1000;
    int backdropMinimizedHeight = 600;

    ImageButton stiButton;


    MediaPlayer mPlayer;
    boolean isPlaying;
    VolleyHelper volleyHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        initCollapsingToolbar();

        backdrop = findViewById(R.id.backdrop);
        animateViewHeight(backdropExpandedHeight,backdrop);

        fragmentHolder = findViewById(R.id.fragment_container);
        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitFragment();
            }
        });
        backButton.setVisibility(View.GONE);

        stiButton = findViewById(R.id.sti);
        stiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isPlaying){
                    playSti();
                } else {
                    stopSti();
                }
            }
        });

        blitziQuote = findViewById(R.id.blitzi_quote);
        dateTv = findViewById(R.id.today);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        System.out.println(sdf.format(date));
        dateTv.setText(sdf.format(date));


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mainCardList = new ArrayList<>();
        adapter = new MainCardAdapter(this, mainCardList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new RecyclerViewHelper(1, 0, true, this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        volleyHelper = new VolleyHelper(this);
        volleyHelper.getString("quotes", new VolleyCallback() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject jsonArray = new JSONObject(result);
                    String quote = jsonArray.getString("name");
                    blitziQuote.setText(quote);

                } catch (Exception e) {
                    System.out.println("My App" + "Could not parse malformed JSON: \"" + result + "\"");
                    System.out.println(e);
                }
            }
            @Override
            public void onError(String error){
                //TODO

            }
            @Override
            public void onResponse(){
                // TODO
//                loadingIcon.setVisibility(View.GONE);
            }
        });

        for (Fragment fragment:getSupportFragmentManager().getFragments()) {
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }

        prepareCards();
//
//        try {
//            Glide.with(this).load(R.drawable.background_top).into((ImageView) findViewById(R.id.backdrop));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }


    private View.OnClickListener getViewOnClick(final Fragment fragment){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation fade_out = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.fade_out);

                recyclerView.startAnimation(fade_out);
                recyclerView.setVisibility(View.INVISIBLE);
                blitziQuote.startAnimation(fade_out);
                blitziQuote.setVisibility(View.INVISIBLE);
                backButton.setVisibility(View.VISIBLE);

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, fragment);
                animateViewHeight(backdropMinimizedHeight,backdrop);
                ft.commit();
            }
        };
    }

    private void prepareCards() {
        int[] icons = new int[]{
                R.drawable.icon_music_note,
                R.drawable.icon_message,
                R.drawable.icon_image,
                R.drawable.icon_map,
                R.drawable.icon_timer,
        };

        int[] colors = new int[]{R.color.red,R.color.pink,R.color.orange,R.color.yellow,R.color.green,R.color.lightblue,R.color.blue,R.color.darkblue};


        mainCardList.add(new MainCard(
                "Sounds",
                "The sounds of boyfriend",
                icons[0],
                R.color.blue,
                getViewOnClick(new SoundsActivity())
        ));

        mainCardList.add(new MainCard(
                "Boyfriend pics",
                "Pictures of boyfriend",
                icons[2],
                R.color.orange,
                getViewOnClick(new PicturesActivity())
        ));

//        mainCardList.add(new MainCard(
//                "Couples pics",
//                "Pictures of boyfriend with sti",
//                icons[2],
//                R.color.orange,
//                getViewOnClick(new PicturesActivity())
//        ));


        mainCardList.add(new MainCard(
                "Messages",
                "Always responsive boyfriend",
                icons[1],
                R.color.green,
                getViewOnClick(new MessagingActivity())
        ));

        mainCardList.add(new MainCard(
                "Maps",
                "Places boyfriend and you have been",
                icons[3],
                R.color.yellow,
                getViewOnClick(new MapsActivity())
        ));

        mainCardList.add(new MainCard(
                "Countdown",
                "Check when boyfriend is in Sweden",
                icons[4],
                R.color.darkblue,
                getViewOnClick(new CountdownActivity())
        ));

        adapter.notifyDataSetChanged();
    }

    private void playSti() {
        isPlaying = true;
        stiButton.setImageDrawable(getResources().getDrawable(R.drawable.icon_stop_white,null));

        String audioUrl = volleyHelper.url+"sti";
        mPlayer = new MediaPlayer();
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try{
            mPlayer.setDataSource(audioUrl);
            mPlayer.prepare();

            mPlayer.start();

        }catch (IOException e){
            // Catch the exception
            e.printStackTrace();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }catch (SecurityException e){
            e.printStackTrace();
        }catch (IllegalStateException e){
            e.printStackTrace();
        }

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stiButton.setImageDrawable(getResources().getDrawable(R.drawable.icon_play_white,null));
                isPlaying = false;
            }
        });
    }

    private void stopSti() {
        isPlaying = false;
        mPlayer.stop();
        stiButton.setImageDrawable(getResources().getDrawable(R.drawable.icon_play_white,null));
    }

    @Override
    public void onBackPressed() {
        if(!exitFragment()){
            super.onBackPressed();
        }
    }

    public boolean exitFragment() {
        // returns false if the user is not in a fragment
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();

        if(fragmentList.isEmpty()){
            return false;
        }

        for (Fragment fragment:getSupportFragmentManager().getFragments()) {
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
        Animation fade_in = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);

        recyclerView.startAnimation(fade_in);
        recyclerView.setVisibility(View.VISIBLE);
        blitziQuote.startAnimation(fade_in);
        blitziQuote.setVisibility(View.VISIBLE);
        backButton.setVisibility(View.GONE);

        animateViewHeight(backdropExpandedHeight,backdrop);

        return true;
    }

    private void animateViewHeight(final int newHeight, final View v) {
        final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();

        final int startHeight = layoutParams.height;

        Animation a = new Animation() {

            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {

                layoutParams.height = (int)((newHeight - startHeight) * interpolatedTime) + startHeight;
                v.setLayoutParams(layoutParams);
            }
        };
        a.setDuration(500); // in ms
        v.startAnimation(a);
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
