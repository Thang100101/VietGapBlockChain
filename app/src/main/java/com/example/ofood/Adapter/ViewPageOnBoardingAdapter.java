package com.example.ofood.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class ViewPageOnBoardingAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragments;

    public ViewPageOnBoardingAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> fragments) {
        super(fm, behavior);
        this.fragments = fragments;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(fragments != null){
            if(fragments.get(position) != null)
                return fragments.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        if(fragments != null)
            return fragments.size();
        return 0;
    }
}
