package com.example.edu.backgroundmusicwithbindservice_11_16;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BackgroundMusic extends AppCompatActivity implements View.OnClickListener {

    private BackgrountMusicWithBindService mServiceBinder;
    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            mServiceBinder = ((BackgrountMusicWithBindService.MyBinder)binder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBinder = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_music);

        Intent intent = new Intent(this,BackgrountMusicWithBindService.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);

        ((Button)findViewById(R.id.buttonPlay)).setOnClickListener(this);
        ((Button)findViewById(R.id.buttonStop)).setOnClickListener(this);

    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        mServiceBinder.stop();
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonPlay:
                mServiceBinder.play();
                break;

            case R.id.buttonStop:
                mServiceBinder.stop();
                break;
        }
    }
}
