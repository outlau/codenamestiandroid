package com.production.outlau.codenamesti.controllers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.production.outlau.codenamesti.R;
import com.production.outlau.codenamesti.models.ImageCard;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageCardAdapter extends RecyclerView.Adapter<ImageCardAdapter.MyViewHolder> {
    private ArrayList<ImageCard> imageCardList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public MyViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.img);
        }
    }

    public ImageCardAdapter(Context context, ArrayList<ImageCard> imageCardList) {
        this.context = context;
        this.imageCardList = imageCardList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_image, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final ImageCard imageCard = imageCardList.get(position);
        Picasso.with(context)
                .load(imageCard.link)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return imageCardList.size();
    }
}
