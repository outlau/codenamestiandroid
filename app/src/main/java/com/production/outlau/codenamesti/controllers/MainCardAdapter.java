package com.production.outlau.codenamesti.controllers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.production.outlau.codenamesti.R;
import com.production.outlau.codenamesti.models.MainCard;

import java.util.List;

public class MainCardAdapter extends RecyclerView.Adapter<MainCardAdapter.MyViewHolder> {

    private Context mContext;
    private List<MainCard> mainCardList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;
        public RelativeLayout background;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
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

        holder.thumbnail.setImageResource(mainCard.getThumbnail());

        int colorResId = mainCard.getColor();

        holder.background.setBackgroundResource(colorResId);

        holder.background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, mainCard.getNextActivity());
                mContext.startActivity(intent);
            }
        });
        // loading mainCard cover using Glide library
//        Glide.with(mContext).load(mainCard.getThumbnail()).into(holder.thumbnail);

//        holder.overflow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showPopupMenu(holder.overflow);
//            }
//        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_main_card, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return mainCardList.size();
    }
}
