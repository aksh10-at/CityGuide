package com.akshdev.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.akshdev.cityguide.R;

public class VerifyOTP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_verify_otp);

        findViewById(R.id.verify_otp_close_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VerifyOTP.super.onBackPressed();
            }
        });

    }
}