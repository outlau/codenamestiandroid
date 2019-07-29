package com.production.outlau.codenamesti.controllers;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.production.outlau.codenamesti.R;
import com.production.outlau.codenamesti.activities.CountdownActivity;
import com.production.outlau.codenamesti.models.MainCard;

import java.util.List;

public class MainCardAdapter extends RecyclerView.Adapter<MainCardAdapter.MyViewHolder> {

    private Context mContext;
    private List<MainCard> mainCardList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView subTitle;
        public ImageView thumbnail;
        public RelativeLayout background;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            subTitle = (TextView) view.findViewById(R.id.sub_title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            background = (RelativeLayout) view.findViewById(R.id.main_card_background);
        }
    }


    public MainCardAdapter(Context mContext, List<MainCard> mainCardList) {
        this.mContext = mContext;
        this.mainCardList = mainCardList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_main, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final MainCard mainCard = mainCardList.get(position);
        holder.title.setText(mainCard.getName());
        holder.subTitle.setText(mainCard.getSubTitle());
        holder.thumbnail.setImageResource(mainCard.getThumbnail());

        int colorResId = mainCard.getColor();

        holder.background.setBackgroundResource(colorResId);
        holder.background.setOnClickListener(mainCard.getOnClickListener());
    }


    @Override
    public int getItemCount() {
        return mainCardList.size();
    }
}
