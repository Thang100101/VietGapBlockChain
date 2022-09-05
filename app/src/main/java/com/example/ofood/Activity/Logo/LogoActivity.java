package com.example.ofood.Activity.Logo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ofood.Activity.Main.MainActivity;
import com.example.ofood.R;

public class LogoActivity extends AppCompatActivity {
    private ImageView imgO, imgFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        Mapping();
        runAnimationFood();
    }

    private void Mapping(){
        imgO = findViewById(R.id.img_o);
        imgFood = findViewById(R.id.img_food);
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
                Intent intent = new Intent(LogoActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },1500);
    }
}