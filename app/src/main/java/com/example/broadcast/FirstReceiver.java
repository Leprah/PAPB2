package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class FirstReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String msg= "";
        switch (intent.getAction()){
            case Intent.ACTION_POWER_CONNECTED:
                msg = "Power Charging Now";
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                msg = "Power Disconnect";
                break;
            case "ACTION_CUSTOM_BROADCAST":
//                msg = "THIS IS CUSTOM SIGNAL";
                msg = intent.getStringExtra("data");
                break;
            default:
                break;
        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}