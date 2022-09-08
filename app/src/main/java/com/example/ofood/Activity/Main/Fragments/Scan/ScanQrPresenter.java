package com.example.ofood.Activity.Main.Fragments.Scan;

import android.app.Activity;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ofood.Activity.Main.Fragments.Scan.Fragments.DetailProductFragment;
import com.example.ofood.Activity.Main.Fragments.Scan.Fragments.QrImageFragment;
import com.example.ofood.GrantPermission;
import com.example.ofood.Models.Product;
import com.example.ofood.R;
import com.journeyapps.barcodescanner.ScanOptions;

public class ScanQrPresenter {
    private ScanQrView view;
    private Activity activity;
    private FragmentManager fragmentManager;


    public ScanQrPresenter(ScanQrView view, Activity activity, FragmentManager fragmentManager){
        this.view = view;
        this.activity = activity;
        this.fragmentManager = fragmentManager;
    }

    public void scanQrCode(ActivityResultLauncher<ScanOptions> launcher, ScanOptions options){
        GrantPermission.scanQRCode(launcher, options, activity);
    }

    public void loadQrImageFragment(){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = new QrImageFragment();
        transaction.add(R.id.frame_qr, fragment);
        transaction.commit();
    }

    public void loadDetailProductFragment(Product product){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putSerializable("product", product);
        Fragment fragment = new DetailProductFragment();
        fragment.setArguments(bundle);
        transaction.replace(R.id.frame_qr, fragment);
        transaction.addToBackStack(DetailProductFragment.NAME);
        transaction.commit();
    }

    public void backToQrImageFragment(){
        fragmentManager.popBackStack();
    }
}
