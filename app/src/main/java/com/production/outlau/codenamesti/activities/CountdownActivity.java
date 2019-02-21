package com.production.outlau.codenamesti.activities;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.production.outlau.codenamesti.R;
import com.production.outlau.codenamesti.comparators.DateSorter;
import com.production.outlau.codenamesti.controllers.ImageCardAdapter;
import com.production.outlau.codenamesti.controllers.TimeCardAdapter;
import com.production.outlau.codenamesti.controllers.VolleyHelper;
import com.production.outlau.codenamesti.helpers.RecyclerViewHelper;
import com.production.outlau.codenamesti.interfaces.VolleyCallback;
import com.production.outlau.codenamesti.models.ImageCard;
import com.production.outlau.codenamesti.models.TimeCard;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.TimeZone;

public class CountdownActivity extends AppCompatActivity {
    VolleyHelper volleyHelper;

    RelativeLayout listViewContainer;

    CountDownTimer countDownTimer;
    TextView daysTv;
    TextView hoursTv;
    TextView minutesTv;
    TextView secondsTv;

    TextView daysSubTv;
    TextView hoursSubTv;
    TextView minutesSubTv;
    TextView secondsSubTv;

    LinearLayout timerContainer;

    long startMillis;
    long endMillis;

    Button dragButton;

    int closeHeight = 300;
    int headerHeight = 50;

    private RecyclerView recyclerView;
    private TimeCardAdapter timeCardAdapter;
    private ArrayList<TimeCard> timeCardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);
        daysTv = findViewById(R.id.days_tv);
        hoursTv = findViewById(R.id.hours_tv);
        minutesTv = findViewById(R.id.minutes_tv);
        secondsTv = findViewById(R.id.seconds_tv);

        daysSubTv = findViewById(R.id.days_sub_tv);
        hoursSubTv = findViewById(R.id.hours_sub_tv);
        minutesSubTv = findViewById(R.id.minutes_sub_tv);
        secondsSubTv = findViewById(R.id.seconds_sub_tv);

        timerContainer = findViewById(R.id.timer_container);
        listViewContainer = findViewById(R.id.list_view_container);
        dragButton = findViewById(R.id.button);

        recyclerView = findViewById(R.id.recycler_view);

        timeCardList = new ArrayList<>();
        timeCardAdapter = new TimeCardAdapter(this, timeCardList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new RecyclerViewHelper(1, 0, true, this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(timeCardAdapter);


        onTouchExpand(dragButton);

        volleyHelper = new VolleyHelper(this);
        volleyHelper.getString("timer", new VolleyCallback() {
            @Override
            public void onSuccess(String result) {
                startMillis = System.currentTimeMillis();
                try {
                    JSONArray jsonArray = new JSONArray(result);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String datetime = jsonObject.getString("datetime").replace("T"," ").replace("Z","");
                        timeCardList.add(new TimeCard(datetime));
                    }
                    Collections.sort(timeCardList, new DateSorter());
                    System.out.println(timeCardList.get(timeCardList.size()-1).getDate());
                    System.out.println("TESTESTSETSET");
                    System.out.println("TESTESTSETSET");
                    System.out.println("TESTESTSETSET");
                    System.out.println("TESTESTSETSET");
                    System.out.println("TESTESTSETSET");
                    endMillis = timeCardList.get(timeCardList.size()-1).getDate().getTime();
                    timeCardAdapter.notifyDataSetChanged();

                } catch (Exception e) {
                    System.out.println("My App" + "Could not parse malformed JSON: \"" + result + "\"");
                    System.out.println(e);
                }

                countDownTimer = new CountDownTimer(endMillis - startMillis, 1000) {
                public void onTick(long millisUntilFinished) {
                    updateTvs(millisUntilFinished);
                }

                public void onFinish() {
                    System.out.println("done");
                }
            };
                countDownTimer.start();
            }
        });
    }

    public void updateTvs(long timeInMillisSeconds) {
        long timeInSeconds = timeInMillisSeconds / 1000;

        long days = timeInSeconds / 86400;
        long hours = timeInSeconds / 3600;
        long secondsLeft = timeInSeconds - hours * 3600;
        long minutes = secondsLeft / 60;
        long seconds = secondsLeft - minutes * 60;

        daysTv.setText(Long.toString(days));
        if (days > 1) {
            daysSubTv.setText("days");
        } else if (days > 0) {
            daysSubTv.setText("day");
        }

        hoursTv.setText(Long.toString(hours%24));
        if (hours % 24 == 1) {
            hoursSubTv.setText("hour");
        } else {
            hoursSubTv.setText("hours");
        }

        minutesTv.setText(Long.toString(minutes));
        if (minutes == 1) {
            minutesSubTv.setText("minute");
        } else {
            minutesSubTv.setText("minutes");
        }

        secondsTv.setText(Long.toString(seconds));
        if (seconds == 1) {
            secondsSubTv.setText("second");
        } else {
            secondsSubTv.setText("seconds");
        }
    }


    private void onTouchExpand(final View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            float pos;
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) listViewContainer.getLayoutParams();
            int viewHeight;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        v.setPressed(true);
                        viewHeight = ((View) listViewContainer.getParent()).getHeight() + getSupportActionBar().getHeight();
                        open();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        pos = clamp(viewHeight-event.getRawY(),headerHeight,1000);

                        System.out.println("viewHeight "+viewHeight);
                        System.out.println("pos "+pos);
                        System.out.println("headerHeight "+headerHeight);

                        layoutParams.height = (int)pos;


//                        if(pos < closeHeight){
//                            System.out.println("NOW");
//                            close(viewHeight);
//                        }

                        listViewContainer.setLayoutParams(layoutParams);

                        break;
                    case MotionEvent.ACTION_UP:
                        v.setPressed(false);

                        if(listViewContainer.getLayoutParams().height < closeHeight){
                            close(viewHeight);
                        }
//                        else
//                            setExpanded(true, getActivity());

                        break;
                    default:
                        return false;
                }
                return true;
            }
        });
    }

    private void close(int viewHeight){

        animateListViewHeight(1);
        animateDragButtonMargin(25);

    }

    private void open(){
        animateDragButtonMargin(0);
    }

    private static float clamp(float val, float min, float max) {
        return Math.max(min, Math.min(max, val));
    }

    private void animateDragButtonMargin(final int newMargin) {
        final ConstraintLayout.LayoutParams dragButtonLayoutParams = (ConstraintLayout.LayoutParams) dragButton.getLayoutParams();
        dragButton.setLayoutParams(dragButtonLayoutParams);

        Animation a = new Animation() {

            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                dragButtonLayoutParams.bottomMargin = (int)(newMargin * interpolatedTime);
                dragButton.setLayoutParams(dragButtonLayoutParams);
            }
        };
        a.setDuration(500); // in ms
        dragButton.startAnimation(a);
    }

    private void animateListViewHeight(final int newHeight) {
        final ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) listViewContainer.getLayoutParams();

        final int startHeight = layoutParams.height;

        System.out.println("START");
        System.out.println("START");
        System.out.println("START");
        System.out.println("START");
        System.out.println("START");
        System.out.println("START");
        Animation a = new Animation() {

            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                System.out.println("time "+interpolatedTime);
                System.out.println("newheight! "+(newHeight * interpolatedTime));

                layoutParams.height = (int)((newHeight - startHeight) * interpolatedTime) + startHeight;
                listViewContainer.setLayoutParams(layoutParams);
            }
        };
        a.setDuration(500); // in ms
        listViewContainer.startAnimation(a);
    }


}
