package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private FirstReceiver mCustomReceiver = new FirstReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter Intent1 = new IntentFilter();
        Intent1.addAction(Intent.ACTION_POWER_CONNECTED);
        Intent1.addAction(Intent.ACTION_POWER_DISCONNECTED);

        registerReceiver(mCustomReceiver,Intent1);

        button = findViewById(R.id.send_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("ACTION_CUSTOM_BROADCAST");
                intent.putExtra("data","THIS IS DATA SIGNAL");
                LocalBroadcastManager.getInstance(view.getContext()).sendBroadcast(intent);
            }
        });
        IntentFilter intent2 = new IntentFilter("ACTION_CUSTOM_BROADCAST");
        LocalBroadcastManager.getInstance(this).registerReceiver(mCustomReceiver,intent2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mCustomReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mCustomReceiver);
    }
}