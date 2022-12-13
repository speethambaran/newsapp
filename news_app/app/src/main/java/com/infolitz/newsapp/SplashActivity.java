package com.infolitz.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import com.infolitz.newsapp.databinding.ActivitySplashBinding;

public class SplashActivity extends BaseActivity {
    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (savedInstanceState == null) {

            boolean isConnected = checkConnection(this);

            if (!isConnected) {
                showNoConnectionSnackBar(" Internet connection lost");
                return;
            }
            Init();
        }

    }

    private void Init() {
        Handler handler = new Handler(getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, DashBoardActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}