package com.example.contextregisteredreceiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String CUSTOM_ACTION = "com.example.contextregisteredreceiver.ACTION_SIMPLEST_BCAST";
    private MyBroadcastReceiver receiver;
    private IntentFilter intentFilter;
    private LocalBroadcastManager mBroadcastMgr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentFilter = new IntentFilter(CUSTOM_ACTION);
        receiver = new MyBroadcastReceiver();

        mBroadcastMgr = LocalBroadcastManager.getInstance(getApplicationContext());
        mBroadcastMgr.registerReceiver(receiver, intentFilter);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(CUSTOM_ACTION);
                intent.putExtra("MESS", "Hello Receiver");
                mBroadcastMgr.sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        mBroadcastMgr.unregisterReceiver(receiver);
    }
}
