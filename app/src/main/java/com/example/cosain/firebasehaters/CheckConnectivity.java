package com.example.cosain.firebasehaters;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

/**
 * Created by cosain on 10/7/2017.
 */

public class CheckConnectivity extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equalsIgnoreCase(ConnectivityManager.CONNECTIVITY_ACTION)) {
            boolean noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);

            if (noConnectivity) {
                Toast.makeText(context, "No Internet Connection Available", Toast.LENGTH_SHORT).show();
            } else {
                context.sendBroadcast(new Intent("Internet is Available"));
                Toast.makeText(context, "Internet Connection Available", Toast.LENGTH_SHORT).show();

            }
        }
    }
}
