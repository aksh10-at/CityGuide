package com.akshdev.cityguide.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;
import android.view.View;

import com.akshdev.cityguide.R;

public class AllCategories extends AppCompatActivity {

    AppCompatImageView backBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);

        backBtn = findViewById(R.id.back_pressed);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDashboard.navigationView.setCheckedItem(R.id.nav_home);
                AllCategories.super.onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {
        UserDashboard.navigationView.setCheckedItem(R.id.nav_home);
        super.onBackPressed();
    }
}