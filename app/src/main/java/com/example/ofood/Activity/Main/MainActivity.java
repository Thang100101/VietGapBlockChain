package com.example.ofood.Activity.Main;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ofood.Broadcast.BroadcastView;
import com.example.ofood.Broadcast.MainBroadcast;
import com.example.ofood.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements FragmentView, BroadcastView {
    private BottomNavigationView bottomNavigationView;
    private FragmentMainPresenter fragmentPresenter;
    private MainBroadcast broadcast;
    private TextView txtInternet;

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
        txtInternet = findViewById(R.id.txt_none_internet);
        broadcast = new MainBroadcast();
        broadcast.setView(this);
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
                        Log.d("selected item ","0");
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


    private long clickTime = 0;
    private Toast toast;
    @Override
    public void onBackPressed() {
        toast = Toast.makeText(this, "Bấm lần nữa để thoát", Toast.LENGTH_SHORT);

        if(fragmentPresenter.getFragmentCount() >1){
            fragmentPresenter.backToMainFragment();
            bottomNavigationView.setSelectedItemId(R.id.menu_home);
            super.onBackPressed();
        }else if(fragmentPresenter.getFragmentCount() == 1){
            if(System.currentTimeMillis() - clickTime <= 2000){
                toast.cancel();
                super.onBackPressed();
            }else{
                clickTime = System.currentTimeMillis();
                toast.show();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadcast, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcast);
    }

    @Override
    public void disconnect() {
        txtInternet.setVisibility(View.VISIBLE);
    }

    @Override
    public void connect() {
        txtInternet.setVisibility(View.GONE);
    }
}