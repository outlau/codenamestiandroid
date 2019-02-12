package com.production.outlau.codenamesti.controllers;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.DataSetObserver;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.production.outlau.codenamesti.R;
import com.production.outlau.codenamesti.activities.SoundsActivity;
import com.production.outlau.codenamesti.models.ImageCard;
import com.production.outlau.codenamesti.models.SoundCard;
import com.production.outlau.codenamesti.services.MediaPlayerService;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

public class SoundListAdapter implements ListAdapter {
    public static final String Broadcast_PLAY_NEW_AUDIO = "com.production.outlau.codenamesti.PlayNewAudio";

    private MediaPlayerService player;
    private boolean serviceBound = false;

    //Binding this Client to the AudioPlayer Service
    private ServiceConnection serviceConnection;

    private ArrayList<SoundCard> arrayList;
    private Context context;
    public SoundListAdapter(Context context, ArrayList<SoundCard> arrayList) {
        this.arrayList=arrayList;
        this.context=context;
        this.serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                // We've bound to LocalService, cast the IBinder and get LocalService instance
                MediaPlayerService.LocalBinder binder = (MediaPlayerService.LocalBinder) service;
                player = binder.getService();
                serviceBound = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                serviceBound = false;
            }
        };
    }
    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }
    @Override
    public boolean isEnabled(int position) {
        return true;
    }
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
    }
    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public boolean hasStableIds() {
        return false;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final SoundCard soundCard = arrayList.get(position);
        if(convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.sound_list_item, null);
            convertView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            final Button button = convertView.findViewById(R.id.stop);
            final TextView title = convertView.findViewById(R.id.title);
            ImageView image = convertView.findViewById(R.id.img);
            title.setText(soundCard.title);
            Picasso.with(context)
                    .load(soundCard.image)
                    .into(image);

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playAudio(soundCard.url);
                }
            });

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stopAudio();
                }
            });

        }
        return convertView;
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public int getViewTypeCount() {
        return arrayList.size();
    }
    @Override
    public boolean isEmpty() {
        return false;
    }

    private void playAudio(String media) {
        //Check is service is active
        if (!serviceBound) {
            System.out.println("TEST");
            Intent playerIntent = new Intent(this.context, MediaPlayerService.class);
            playerIntent.putExtra("media", media);
            this.context.startService(playerIntent);
            this.context.bindService(playerIntent, serviceConnection, Context.BIND_AUTO_CREATE);
        } else {
            //Service is active
            //Send media with BroadcastReceiver
                        System.out.println("TEST2");
            Intent broadcastIntent = new Intent(Broadcast_PLAY_NEW_AUDIO);
            broadcastIntent.putExtra("url",media);
            this.context.sendBroadcast(broadcastIntent);
        }
    }

    private void stopAudio() {
        if (serviceBound) {
            Intent broadcastIntent = new Intent(Broadcast_PLAY_NEW_AUDIO);
            this.context.sendBroadcast(broadcastIntent);
        }
    }

    public void stopConnection() {
        stopAudio();
        this.context.unbindService(serviceConnection);
    }
}
