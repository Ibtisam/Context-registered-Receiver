package com.example.contextregisteredreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Message from Broadcast: "+intent.getStringExtra("MESS"), Toast.LENGTH_SHORT).show();
    }
}
