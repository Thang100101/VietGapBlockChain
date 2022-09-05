package com.example.ofood.Activity.Main.Fragments.Scan;

import android.app.Activity;

import androidx.activity.result.ActivityResultLauncher;

import com.example.ofood.GrantPermission;
import com.journeyapps.barcodescanner.ScanOptions;

public class ScanQrPresenter {
    private ScanQrView view;
    private Activity activity;

    public ScanQrPresenter(ScanQrView view, Activity activity){
        this.view = view;
        this.activity = activity;
    }

    public void scanQrCode(ActivityResultLauncher<ScanOptions> launcher, ScanOptions options){
        GrantPermission.scanQRCode(launcher, options, activity);
    }
}
