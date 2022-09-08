package com.example.ofood.Activity.Main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ofood.Activity.Main.Fragments.AboutUs.AboutUsFragment;
import com.example.ofood.Activity.Main.Fragments.Rate.RateForUsFragment;
import com.example.ofood.Activity.Main.Fragments.Scan.ScanQrFragment;
import com.example.ofood.R;

public class FragmentMainPresenter {
    private FragmentView fragmentView;
    private FragmentManager fragmentManager;
    private int fragmentCount;

    public FragmentMainPresenter(FragmentView view, FragmentManager fragmentManager) {
        this.fragmentView = view;
        this.fragmentManager = fragmentManager;
        fragmentCount =0;
    }

    public void loadQRFragment(){
        if(!fragmentManager.popBackStackImmediate(ScanQrFragment.NAME, 0)
                && fragmentCount == 0) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.frame, new ScanQrFragment());
            transaction.commit();
            fragmentCount = 1;
            return;
        }
        if(fragmentCount == 1)
            return;
        if(fragmentCount >1){
            removeFragment();
            return;
        }
    }

    public void loadAboutUsFragment(){
        removeFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = new AboutUsFragment();
        transaction.replace(R.id.frame, fragment);
        transaction.addToBackStack(AboutUsFragment.NAME);
        transaction.commit();
        fragmentCount ++;
    }

    public void loadRateForUsFragment(){
        removeFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = new RateForUsFragment();
        transaction.replace(R.id.frame, fragment);
        transaction.addToBackStack(RateForUsFragment.NAME);
        transaction.commit();
        fragmentCount ++;
    }


    public void backToMainFragment(){
        fragmentCount = 1;
        return;
    }

    private void removeFragment(){
        for(int i = 0; i < fragmentManager.getBackStackEntryCount(); i++){
            fragmentManager.popBackStack();
        }
        fragmentCount = 1;
        return;
    }

    public int getFragmentCount() {
        return fragmentCount;
    }
}
