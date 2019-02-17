package com.production.outlau.codenamesti.controllers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.IBinder;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.production.outlau.codenamesti.R;
import com.production.outlau.codenamesti.models.SoundCard;
import com.production.outlau.codenamesti.services.MediaPlayerService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SoundListAdapter extends RecyclerView.Adapter<SoundListAdapter.MyViewHolder> {
    public static final String Broadcast_PLAY_NEW_AUDIO = "com.production.outlau.codenamesti.PlayNewAudio";

    private MediaPlayerService player;
    private boolean serviceBound = false;

    //Binding this Client to the AudioPlayer Service
    private ServiceConnection serviceConnection;

    private ArrayList<SoundCard> soundCardList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public Button button;
        public TextView title;
        public ImageView image;
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            button = view.findViewById(R.id.stop);
            image = view.findViewById(R.id.img);
        }
    }


    public SoundListAdapter(Context context, ArrayList<SoundCard> soundCardList) {
        this.context = context;
        this.soundCardList = soundCardList;
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
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_sound, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final SoundCard soundCard = soundCardList.get(position);


        System.out.println("onbindview");
        holder.title.setText(soundCard.title);
        Picasso.with(context)
                .load(soundCard.image)
                .into(holder.image);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(soundCard.url);
            }
        });

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAudio();
            }
        });


//        holder.title.setText(soundCard.getName());
//
//        holder.thumbnail.setImageResource(soundCard.getThumbnail());

//        int colorResId = soundCard.getColor();
//
//        holder.background.setBackgroundResource(colorResId);

//        holder.background.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, soundCard.getNextActivity());
//                context.startActivity(intent);
//            }
//        });
        // loading mainCard cover using Glide library
//        Glide.with(context).load(mainCard.getThumbnail()).into(holder.thumbnail);

//        holder.overflow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showPopupMenu(holder.overflow);
//            }
//        });
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
        player.onCompletion();
        //TODO
//        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                performOnEnd();
//            }
//
//        });
//        })
    }

    private void stopAudio() {
        if (serviceBound) {
            Intent broadcastIntent = new Intent(Broadcast_PLAY_NEW_AUDIO);
            this.context.sendBroadcast(broadcastIntent);
        }
    }

    public void stopConnection() {
        stopAudio();
        if(serviceBound) {
            this.context.unbindService(serviceConnection);
        }
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
                    Toast.makeText(context, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(context, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return soundCardList.size();
    }
}
