package com.example.ofood.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

public class MainBroadcast extends BroadcastReceiver {
    private BroadcastView view;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            if(isConnect(context)){
                view.connect();
            }else{
                view.disconnect();
            }
        }
    }

    private boolean isConnect(Context context){
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if(connectivityManager == null){
            return false;
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            Network network = connectivityManager.getActiveNetwork();
            if(network == null){
                return false;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            return networkCapabilities != null && networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI);
        }else{
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected();
        }
    }

    public void setView(BroadcastView view) {
        this.view = view;
    }
}
