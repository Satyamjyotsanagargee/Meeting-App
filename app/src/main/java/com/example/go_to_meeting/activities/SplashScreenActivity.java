package com.example.go_to_meeting.activities;
import   com.example.go_to_meeting.R;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import maes.tech.intentanim.CustomIntent;

public class SplashScreenActivity extends AppCompatActivity {
    private ImageView appLogo, pattern1, pattern2;
    private TextView appSlogan, poweredBy, developerDepository;

    //Other Variables
    private Animation topAnimation, bottomAnimation, startAnimation, endAnimation;
    private SharedPreferences onBoardingPreference;



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(getColor(R.color.colorBackground));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        initViews();
        initAnimation();
    }

    private void initViews() {
        //Initialize Views
        appLogo = findViewById(R.id.app_logo);
        pattern1 = findViewById(R.id.pattern1);
        pattern2 = findViewById(R.id.pattern2);
        appSlogan = findViewById(R.id.app_slogan);
        poweredBy = findViewById(R.id.powered_by);
        developerDepository = findViewById(R.id.go_to_meet);
    }

    private void initAnimation() {
        //Initialize Animations
        topAnimation = AnimationUtils.loadAnimation(SplashScreenActivity.this, R.anim.splash_top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(SplashScreenActivity.this, R.anim.splash_bottom_animation);
        startAnimation = AnimationUtils.loadAnimation(SplashScreenActivity.this, R.anim.splash_start_animation);
        endAnimation = AnimationUtils.loadAnimation(SplashScreenActivity.this, R.anim.splash_end_animation);
    }

    @Override
    protected void onStart() {
        super.onStart();
        int SPLASH_TIMER = 3000;

        //Set Preferences
        onBoardingPreference = getSharedPreferences("onBoardingPreference", MODE_PRIVATE);
        final boolean isFirstTime = onBoardingPreference.getBoolean("firstTime", true);

        //Set Animation To Views
        appLogo.setAnimation(topAnimation);
        pattern1.setAnimation(startAnimation);
        pattern2.setAnimation(endAnimation);
        appSlogan.setAnimation(bottomAnimation);
        poweredBy.setAnimation(bottomAnimation);
        developerDepository.setAnimation(bottomAnimation);

        new Handler().postDelayed(() -> {
            if (isFirstTime) {
                @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = onBoardingPreference.edit();
                editor.putBoolean("firstTime", false);
                editor.apply();

                Intent intent = new Intent(SplashScreenActivity.this, OnBoardActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            } else {
                Intent intent = new Intent(SplashScreenActivity.this,SignInActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
            CustomIntent.customType(SplashScreenActivity.this, "fadein-to-fadeout");
            finish();
        }, SPLASH_TIMER);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}

