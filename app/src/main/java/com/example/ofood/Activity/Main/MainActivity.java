package com.example.ofood.Activity.Main;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ofood.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements FragmentView{
    private BottomNavigationView bottomNavigationView;
    private FragmentMainPresenter fragmentPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mapping();
        customActionBar();
        eventHandler();
        loadMainFragment();
    }

    private void Mapping(){
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        fragmentPresenter = new FragmentMainPresenter(this, getSupportFragmentManager());
    }

    private void customActionBar(){
        getSupportActionBar().setLogo(R.drawable.logo_ofood_removebg);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.background_actionbar));
    }

    private void eventHandler(){
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        loadMainFragment();
                        break;
                    case R.id.menu_about_us:
                        loadAboutUsFragment();
                        break;
                    case R.id.menu_rate:
                        loadRateForUsFragment();
                        break;
                }
                return true;
            }
        });
    }

    private void loadMainFragment(){
        fragmentPresenter.loadQRFragment();
    }

    private void loadAboutUsFragment(){
        fragmentPresenter.loadAboutUsFragment();
    }

    private void loadRateForUsFragment(){
        fragmentPresenter.loadRateForUsFragment();
    }
}