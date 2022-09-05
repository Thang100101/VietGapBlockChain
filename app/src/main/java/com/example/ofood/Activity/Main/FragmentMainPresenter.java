package com.example.ofood.Activity.Main;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ofood.Activity.Main.Fragments.AboutUs.AboutUsFragment;
import com.example.ofood.Activity.Main.Fragments.Rate.RateForUsFragment;
import com.example.ofood.Activity.Main.Fragments.Scan.ScanQrFragment;
import com.example.ofood.R;

public class FragmentMainPresenter {
    private FragmentView fragmentView;
    private FragmentManager fragmentManager;

    public FragmentMainPresenter(FragmentView view, FragmentManager fragmentManager) {
        this.fragmentView = view;
        this.fragmentManager = fragmentManager;
    }

    public void loadQRFragment(){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame, new ScanQrFragment());
        transaction.commit();
    }

    public void loadAboutUsFragment(){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame, new AboutUsFragment());
        transaction.commit();
    }

    public void loadRateForUsFragment(){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame, new RateForUsFragment());
        transaction.commit();
    }
}
