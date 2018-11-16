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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private BackgrountMusicWithBindService mServiceBinder;
    Intent intent1;
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
        setContentView(R.layout.activity_main);

        Intent intent1 = new Intent(this,BackgrountMusicWithBindService.class);
        bindService(intent1, myConnection, Context.BIND_AUTO_CREATE);

        ((Button)findViewById(R.id.buttonMusicPlayer)).setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, BackgroundMusic.class);
        startActivity(intent);
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mServiceBinder.stopSelf();
//    }
}
