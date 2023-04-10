package com.akshdev.cityguide.Common;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewpager.widget.ViewPager;

import com.akshdev.cityguide.HelperClasses.SliderAdapter;
import com.akshdev.cityguide.R;
import com.akshdev.cityguide.User.UserDashboard;

public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayoutCompat dotsLayout;
    AppCompatButton letsGetStarted;
    AppCompatTextView[] dots;
    SliderAdapter sliderAdapter;
    int currentPos;
    Animation animation;
    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            if (position == 3) {
                animation = AnimationUtils.loadAnimation(OnBoarding.this, R.anim.get_started_btn_anim);
                letsGetStarted.setAnimation(animation);

                //visibility setup for buttons...
                letsGetStarted.setVisibility(View.VISIBLE);
                findViewById(R.id.skip_btn).setVisibility(View.INVISIBLE);
                findViewById(R.id.next_btn).setVisibility(View.INVISIBLE);
            } else {
                //visibility setup for buttons...
                letsGetStarted.setVisibility(View.INVISIBLE);
                findViewById(R.id.skip_btn).setVisibility(View.VISIBLE);
                findViewById(R.id.next_btn).setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    View.OnClickListener nextListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            viewPager.setCurrentItem(currentPos + 1);
        }
    };

    View.OnClickListener skipListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(OnBoarding.this, UserDashboard.class));
            finish();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        //remove status bar (battery wala)(no need)
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //hooks
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        letsGetStarted = findViewById(R.id.get_started_btn);

        //Call Adapter
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        //setting up click listeners
        letsGetStarted.setOnClickListener(skipListener);
        findViewById(R.id.skip_btn).setOnClickListener(skipListener);
        findViewById(R.id.next_btn).setOnClickListener(nextListener);

        //Dots
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }


    private void addDots(int position) {
        currentPos = position;
        dots = new AppCompatTextView[4];
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new AppCompatTextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }

    }

}