package com.production.outlau.codenamesti.controllers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.production.outlau.codenamesti.R;
import com.production.outlau.codenamesti.models.SoundCard;
import com.production.outlau.codenamesti.services.MediaPlayerService;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SoundCardAdapter extends RecyclerView.Adapter<SoundCardAdapter.MyViewHolder> {
    public static final String Broadcast_PLAY_NEW_AUDIO = "com.production.outlau.codenamesti.PlayNewAudio";

    private MediaPlayerService player;
    private boolean serviceBound = false;

    AsyncTask asyncTask;

    //Binding this Client to the AudioPlayer Service
    private ServiceConnection serviceConnection;

    private ArrayList<SoundCard> soundCardList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView image;
        public boolean isPlaying = false;
        public AsyncMediaTask asyncTask;
        public volatile CountDownLatch mediaDoneLatch;
        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            image = view.findViewById(R.id.img);
            asyncTask = new AsyncMediaTask(this);
            mediaDoneLatch = new CountDownLatch(1);
            LocalBroadcastManager.getInstance(context).registerReceiver(completeMessage,
                    new IntentFilter("completeMessage"));
            LocalBroadcastManager.getInstance(context).registerReceiver(startMessage,
                    new IntentFilter("startMessage"));
        }

        public void resetLatch(){
            isPlaying = false;
            mediaDoneLatch.countDown();
            mediaDoneLatch = new CountDownLatch(1);
        }

        public void playAudio(String media) {
            resetLatch();

            isPlaying = true;

            asyncTask.cancel(true);
            asyncTask = new AsyncMediaTask(this);
            asyncTask.execute();

            image.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_stop,null));

            if (!serviceBound) {
                Intent playerIntent = new Intent(context, MediaPlayerService.class);
                playerIntent.putExtra("url", media);
                playerIntent.putExtra("title", title.getText().toString());
                context.startService(playerIntent);
                context.bindService(playerIntent, serviceConnection, Context.BIND_AUTO_CREATE);
            } else {
                //Service is active
                //Send media with BroadcastReceiver
                Intent broadcastIntent = new Intent(Broadcast_PLAY_NEW_AUDIO);
                broadcastIntent.putExtra("url",media);
                broadcastIntent.putExtra("title", title.getText().toString());
                context.sendBroadcast(broadcastIntent);
            }
        }

        public void stopAudio() {
            resetLatch();
            if (serviceBound) {
                Intent broadcastIntent = new Intent(Broadcast_PLAY_NEW_AUDIO);
                context.sendBroadcast(broadcastIntent);
            }
        }

        private BroadcastReceiver completeMessage = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                // Get extra data included in the Intent
                String message = intent.getStringExtra("message");
                System.out.println("receiver " + "Got message: " + message);
                resetLatch();
            }
        };

        private BroadcastReceiver startMessage = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String message = intent.getStringExtra("message");
                String titleText = intent.getStringExtra("title");
                System.out.println("receiver " + "Got message titleText: " + titleText);
                if(title.getText().toString().equals(titleText)){
                    return;
                }
                resetLatch();
            }
        };
    }

    public SoundCardAdapter(Context context, ArrayList<SoundCard> soundCardList) {
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
        holder.title.setText(soundCard.title);
//        Picasso.with(context)
//                .load(soundCard.image)
//                .into(holder.image);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.isPlaying){
                    holder.stopAudio();
                } else {
                    holder.playAudio(soundCard.url);
                }
            }
        });
    }



    // TODO
//    public void stopConnection() {
//        stopAudio();
//        if(serviceBound) {
//            this.context.unbindService(serviceConnection);
//        }
//        LocalBroadcastManager.getInstance(this.context).unregisterReceiver(mMessageReceiver);
//    }

    private class AsyncMediaTask extends AsyncTask<Object, Boolean, Boolean> {
        MyViewHolder holder;

        AsyncMediaTask(MyViewHolder holder){
            this.holder = holder;
        }

        @Override
        protected Boolean doInBackground(Object... params) {
            try {
                return holder.mediaDoneLatch.await(60, TimeUnit.SECONDS);
            } catch (final InterruptedException e) {
                System.out.println("Someone has disturbed the condition awaiter.");
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            updateUI(holder);
            holder.resetLatch();
        }

    }

    void updateUI(final MyViewHolder holder){
        Handler mainHandler = new Handler(context.getMainLooper());

        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                holder.image.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_play,null));
            }
        };
        mainHandler.post(myRunnable);
    }

    @Override
    public int getItemCount() {
        return soundCardList.size();
    }
}
