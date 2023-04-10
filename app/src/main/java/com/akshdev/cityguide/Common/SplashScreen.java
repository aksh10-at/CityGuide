package com.akshdev.cityguide.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.akshdev.cityguide.R;
import com.akshdev.cityguide.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {

    static final int SPLASH_TIMER = 3000;
    //variables
    //use camel-case in java not "_"one..
    SharedPreferences onBoardingScreen;
    AppCompatImageView backgroundImage;
    AppCompatTextView poweredByLine;

    Animation sideAnim, bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        //remove status bar.. (No need)
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Hooks (set design element to our java code)
        backgroundImage = findViewById(R.id.background_image);
        poweredByLine = findViewById(R.id.powered_by_line);

        //Animations
        sideAnim = AnimationUtils.loadAnimation(this,R.anim.splash_top_anim);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.splash_bottom_anim);

        //set animations to variables
        backgroundImage.setAnimation(sideAnim);
        poweredByLine.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                onBoardingScreen = getSharedPreferences("onScreenBoarding",MODE_PRIVATE);
                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime",true);

                if(isFirstTime){
                    startActivity(new Intent(SplashScreen.this, OnBoarding.class));
                }
                else {
                    startActivity(new Intent(SplashScreen.this, UserDashboard.class));
                }
                finish();
            }
        },SPLASH_TIMER);

    }
}