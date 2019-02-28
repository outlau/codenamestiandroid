package com.production.outlau.codenamesti.activities;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.production.outlau.codenamesti.R;
import com.production.outlau.codenamesti.comparators.DateSorter;
import com.production.outlau.codenamesti.controllers.TimeCardAdapter;
import com.production.outlau.codenamesti.controllers.VolleyHelper;
import com.production.outlau.codenamesti.helpers.RecyclerViewHelper;
import com.production.outlau.codenamesti.interfaces.VolleyCallback;
import com.production.outlau.codenamesti.models.TimeCard;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

public class CountdownActivity extends Fragment {
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

    TextView timeHeaderText;

    LinearLayout timerContainer;

    // This is the layout of the main content of MainActivity
    // Holds everything
    RelativeLayout mainContent;

    long startMillis;
    long endMillis;

    ImageButton dragButton;

    ProgressBar loadingIcon;

    int closeHeight = 300;
    int headerHeight = 50;

    private RecyclerView recyclerView;
    private TimeCardAdapter timeCardAdapter;
    private ArrayList<TimeCard> timeCardList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.activity_countdown, parent, false);
        mainContent = (RelativeLayout)parent.getParent();

        daysTv = v.findViewById(R.id.days_tv);
        hoursTv = v.findViewById(R.id.hours_tv);
        minutesTv = v.findViewById(R.id.minutes_tv);
        secondsTv = v.findViewById(R.id.seconds_tv);

        daysSubTv = v.findViewById(R.id.days_sub_tv);
        hoursSubTv = v.findViewById(R.id.hours_sub_tv);
        minutesSubTv = v.findViewById(R.id.minutes_sub_tv);
        secondsSubTv = v.findViewById(R.id.seconds_sub_tv);

        timeHeaderText = v.findViewById(R.id.header_text);

        timerContainer = v.findViewById(R.id.timer_container);
        listViewContainer = v.findViewById(R.id.list_view_container);
        dragButton = v.findViewById(R.id.slide_button);

        recyclerView = v.findViewById(R.id.recycler_view);

        loadingIcon = v.findViewById(R.id.loading_icon);
        timeCardList = new ArrayList<>();
        timeCardAdapter = new TimeCardAdapter(getContext(), timeCardList);

        if(countDownTimer != null){
            countDownTimer.cancel();
        }

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new RecyclerViewHelper(1, 0, true, getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(timeCardAdapter);

        onTouchExpand(dragButton);

        volleyHelper = new VolleyHelper(getContext());
        volleyHelper.getString("times", new VolleyCallback() {
            @Override
            public void onSuccess(String result) {
                startMillis = System.currentTimeMillis();
                timeHeaderText.setText("Arriving in:");
                try {
                    JSONArray jsonArray = new JSONArray(result);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String datetime = jsonObject.getString("datetime").replace("T"," ").replace("Z","");
                        timeCardList.add(new TimeCard(datetime));
                    }
                    Collections.sort(timeCardList, new DateSorter());
                    endMillis = timeCardList.get(0).getDate().getTime();
                    timeCardAdapter.notifyDataSetChanged();

                    timerContainer.setVisibility(View.VISIBLE);


                } catch (Exception e) {
                    System.out.println("My App" + "Could not parse malformed JSON: \"" + result + "\"");
                    System.out.println(e);
                }


                countDownTimer = new CountDownTimer(endMillis - startMillis, 1000) {
                public void onTick(long millisUntilFinished) {
                    updateTvs(millisUntilFinished);
                }

                public void onFinish() {
                    timeHeaderText.setText("No upcoming arrivals");
                    timerContainer.setVisibility(View.INVISIBLE);
                }
            };
                countDownTimer.start();
            }
            @Override
            public void onError(String error){
                timeHeaderText.setText(error);
                //TODO
            }
            @Override
            public void onResponse(){
                loadingIcon.setVisibility(View.GONE);
            }
        });

        animateListViewHeight(1,500);

        return v;
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
            int height;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        v.setPressed(true);
                        viewHeight = ((View) listViewContainer.getParent()).getHeight();// + getSupportActionBar().getHeight();
                        height = mainContent.getHeight();
                        open();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        pos = clamp(height-event.getRawY(),headerHeight,(int)(viewHeight*.8));

                        System.out.println("viewHeight "+viewHeight);
                        System.out.println("pos "+pos);
                        System.out.println("headerHeight "+headerHeight);

                        System.out.println("getHeight "+height );
                        System.out.println("event.getRawY() "+event.getRawY() );

                        layoutParams.height = (int)pos;

                        listViewContainer.setLayoutParams(layoutParams);

                        break;
                    case MotionEvent.ACTION_UP:
                        v.setPressed(false);

                        if(listViewContainer.getLayoutParams().height < closeHeight){
                            close(viewHeight);
                        }

                        break;
                    default:
                        return false;
                }
                return true;
            }
        });
    }

    private void close(int viewHeight){

        animateListViewHeight(1, 500);
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

    private void animateListViewHeight(final int newHeight, final int duration) {
        final ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) listViewContainer.getLayoutParams();
        final int startHeight = layoutParams.height;

        Animation a = new Animation() {

            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                layoutParams.height = (int)((newHeight - startHeight) * interpolatedTime) + startHeight;
                listViewContainer.setLayoutParams(layoutParams);
            }
        };
        a.setDuration(500); // in ms
        listViewContainer.startAnimation(a);
    }
}
