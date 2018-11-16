package com.example.edu.backgroundmusicwithbindservice_11_16;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.view.View;

public class BackgrountMusicWithBindService extends Service {
    MediaPlayer mPlayer;

    public BackgrountMusicWithBindService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public class MyBinder extends Binder{
        BackgrountMusicWithBindService getService(){
            return BackgrountMusicWithBindService.this;
        }
    }

    public void play(){

        mPlayer = MediaPlayer.create(this, R.raw.waste_it_on_me);
        mPlayer.setLooping(false);
        mPlayer.setVolume(100,100);
        mPlayer.start();
    }

    public void stop(){
        if(mPlayer==null) return;
        mPlayer.stop();
        mPlayer.release();
    }

//    @Override
//    public void onTaskRemoved(Intent rootIntent) {
//        super.onTaskRemoved(rootIntent);
//        stopSelf();
//    }
}
