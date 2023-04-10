package com.akshdev.cityguide.Common.LoginSignup;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.akshdev.cityguide.R;

public class SignUp3rdClass extends AppCompatActivity {

    AppCompatButton next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_sign_up3rd_class);

        //hook
        next = findViewById(R.id.signup_next_button3);

        //back_btn
        findViewById(R.id.signup_back_button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUp3rdClass.super.onBackPressed();
            }
        });

        //next_btn
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validate user
                //supposing user is validated

                Intent intent = new Intent(getApplicationContext(), VerifyOTP.class);

                //add transition
                Pair[] pairs = new Pair[1];
                //view--where we want to apply transition
                //String-- transition name
                pairs[0] = new Pair<View, String>(next, "transition_otp");


                //calling next activity with these transitions attached.
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp3rdClass.this, pairs);
                startActivity(intent, options.toBundle());
            }
        });


    }
}