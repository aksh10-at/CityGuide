package com.akshdev.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.akshdev.cityguide.R;

public class RetailerStartUpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_start_up_screen);

        findViewById(R.id.login_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Login.class);

                //for animation
                //no of elements we want to animate.here 1
                Pair[] pairs = new Pair[1];

                //everything in android is view.
                //View- jisko animate karna hai
                //String-- animation ka naam
                pairs[0] = new Pair<View,String>(findViewById(R.id.login_btn),"transition_login");

                //do only if minimum sdk is more than ----
                //if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(RetailerStartUpScreen.this,pairs);

                startActivity(intent,options.toBundle());
            }
        });

        //SignUp btn
        findViewById(R.id.signup_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignUp.class);

                //for animation
                //no of elements we want to animate.here 1
                Pair[] pairs = new Pair[1];

                //everything in android is view.
                //View- jisko animate karna hai
                //String-- animation ka naam
                pairs[0] = new Pair<View,String>(findViewById(R.id.signup_btn),"transition_signup");

                //do only if minimum sdk is more than ----
                //if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(RetailerStartUpScreen.this,pairs);

                startActivity(intent,options.toBundle());
            }
        });


    }
}