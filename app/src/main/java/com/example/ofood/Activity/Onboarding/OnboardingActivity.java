package com.example.ofood.Activity.Onboarding;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.ofood.Activity.Onboarding.Fragments.OnboardingFragment1;
import com.example.ofood.Activity.Onboarding.Fragments.OnboardingFragment2;
import com.example.ofood.Activity.Onboarding.Fragments.OnboardingFragment3;
import com.example.ofood.Adapter.ViewPageOnBoardingAdapter;
import com.example.ofood.R;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class OnboardingActivity extends AppCompatActivity {

    private TextView txtSkip;
    private ViewPager viewPager;
    private LinearLayout layoutNext;
    private CircleIndicator circleIndicator;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        getSupportActionBar().hide();
        Mapping();
        customViewPage();
        eventHandler();
    }

    private void Mapping() {
        txtSkip = findViewById(R.id.txt_skip);
        viewPager = findViewById(R.id.view_page);
        layoutNext = findViewById(R.id.next_layout);
        circleIndicator = findViewById(R.id.circle_indicator);
        relativeLayout = findViewById(R.id.re_layout);
    }

    private void eventHandler(){
        txtSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
            }
        });

        layoutNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 2){
                    txtSkip.setVisibility(View.GONE);
                    relativeLayout.setVisibility(View.GONE);
                }else{
                    txtSkip.setVisibility(View.VISIBLE);
                    relativeLayout.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void customViewPage(){
        ViewPageOnBoardingAdapter adapter = new ViewPageOnBoardingAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, getFragmentOnboarding());
        viewPager.setAdapter(adapter);
        circleIndicator.setViewPager(viewPager);
    }

    private List<Fragment> getFragmentOnboarding(){
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new OnboardingFragment1());
        fragments.add(new OnboardingFragment2());
        fragments.add(new OnboardingFragment3());
        return fragments;
    }
}