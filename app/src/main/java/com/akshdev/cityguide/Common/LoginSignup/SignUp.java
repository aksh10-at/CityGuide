package com.akshdev.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.akshdev.cityguide.R;

public class SignUp extends AppCompatActivity {

    //Variables
    AppCompatImageView backBtn;
    AppCompatButton next,login;
    AppCompatTextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_sign_up);

        //Hooks
        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);
        titleText = findViewById(R.id.signup_title_text);


        findViewById(R.id.signup_next_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validate user
                //supposing user is validated

                Intent intent = new Intent(getApplicationContext(),SignUp2ndClass.class);

                //add transition
                Pair[] pairs = new Pair[4];
                //view--where we want to apply transition
                //String-- transition name
                pairs[0] = new Pair<View,String>(backBtn,"transition_back_arrow_btn");
                pairs[1] = new Pair<View,String>(next,"transition_next_btn");
                pairs[2] = new Pair<View,String>(login,"transition_login_btn");
                pairs[3] = new Pair<View,String>(titleText,"transition_title_text");

                //calling next activity with these transitions attached.
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this,pairs);
                startActivity(intent,options.toBundle());

            }
        });


        //back_btn
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUp.super.onBackPressed();
            }
        });

    }
}