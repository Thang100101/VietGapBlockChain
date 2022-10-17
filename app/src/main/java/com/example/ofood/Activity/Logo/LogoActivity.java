package com.example.ofood.Activity.Logo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ofood.Activity.Main.MainActivity;
import com.example.ofood.Activity.Onboarding.OnboardingActivity;
import com.example.ofood.R;

public class LogoActivity extends AppCompatActivity {
    private ImageView imgO, imgFood;
    private SharedPreferences prefer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        Mapping();
        runAnimationFood();
        getSupportActionBar().hide();
    }

    private void Mapping(){
        imgO = findViewById(R.id.img_o);
        imgFood = findViewById(R.id.img_food);
        prefer = getPreferences(MODE_PRIVATE);
    }

    private void runAnimationFood(){
        imgFood.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imgFood.setVisibility(View.VISIBLE);
                Animation animation = AnimationUtils.loadAnimation(LogoActivity.this, R.anim.bot_to_mid);
                imgFood.startAnimation(animation);
                nextActivity();
            }
        },500);
    }

    private void nextActivity(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean isNewMember =prefer.getBoolean("isNewMember", true);
                Intent intent;
                if(isNewMember) {
                    SharedPreferences.Editor editor = prefer.edit();
                    editor.putBoolean("isNewMember", false);
                    editor.commit();
                    intent = new Intent(LogoActivity.this, OnboardingActivity.class);
                }else{
                    intent = new Intent(LogoActivity.this, MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        },1500);
    }
}