package com.production.outlau.codenamesti.controllers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.production.outlau.codenamesti.R;
import com.production.outlau.codenamesti.models.TimeCard;

import java.util.ArrayList;

public class TimeCardAdapter extends RecyclerView.Adapter<TimeCardAdapter.MyViewHolder> {
    private ArrayList<TimeCard> timeCardList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView timeText;
        public TextView dateText;
        public MyViewHolder(View view) {
            super(view);
            timeText = view.findViewById(R.id.time);
            dateText = view.findViewById(R.id.date);
        }
    }

    public TimeCardAdapter(Context context, ArrayList<TimeCard> timeCardList) {
        this.context = context;
        this.timeCardList = timeCardList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_time, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final TimeCard timeCard = timeCardList.get(position);
        holder.timeText.setText(timeCard.getTimeString());
        holder.dateText.setText(timeCard.getDateString());
    }

    @Override
    public int getItemCount() {
        return timeCardList.size();
    }
}
