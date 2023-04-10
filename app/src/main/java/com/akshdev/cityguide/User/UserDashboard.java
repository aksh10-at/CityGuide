package com.akshdev.cityguide.User;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.akshdev.cityguide.Common.LoginSignup.RetailerStartUpScreen;
import com.akshdev.cityguide.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.akshdev.cityguide.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.akshdev.cityguide.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //variables
    static final float END_SCALE = 0.7f;
    static NavigationView navigationView;
    LinearLayoutCompat contentView;
    RecyclerView featuredRecycler;
    RecyclerView.Adapter adapter;
    AppCompatImageView menuIcon;
    AppCompatImageView plusIcon;
    //DrawerMenu
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove status bar (No need)
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //OnBoarding Screen SharedPreferences
        SharedPreferences onBoardingScreen = getSharedPreferences("onScreenBoarding", MODE_PRIVATE);
        SharedPreferences.Editor editor = onBoardingScreen.edit();
        editor.putBoolean("firstTime", false);
        editor.apply();


        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);
        plusIcon = findViewById(R.id.plus_icon);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        //Retailer Screen setup (plus icon)
        retailerScreens();

        //Navigation Drawer
        navigationDrawer();

        //Recycler View function call
        featuredRecycler();

    }

    private void retailerScreens() {
        plusIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RetailerStartUpScreen.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void navigationDrawer() {
        //as we want to interact with navigation drawer like..scroll_added..swipe_works..etc
        navigationView.bringToFront();
        //not recommended way.
        //navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener)this);;
        navigationView.setNavigationItemSelectedListener(this);
        //by default home is checked...
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(view -> {
            //if drawer is visible then close
            if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {
        //color of side part.
        drawerLayout.setScrimColor(getResources().getColor(R.color.nav_background));

        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();
        //drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);
                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }

    private void featuredRecycler() {
        //recycler view has large size. so this fxn will only load those views which are visible to user.
        featuredRecycler.setHasFixedSize(true);

        //layout manager
        //by default linearlayout manager is horizontal.
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocation = new ArrayList<>();
        featuredLocation.add(new FeaturedHelperClass(R.drawable.add_missing_place, "Missing Place", "gfgfgf fggffg gdggfgfhg jjhjhje ewewesesf gv"));
        featuredLocation.add(new FeaturedHelperClass(R.drawable.restaurant_icon, "Restaurant ", "gfgfgf fggffg gdggfgfhg jjhjhje ewewesesf gv"));
        featuredLocation.add(new FeaturedHelperClass(R.drawable.menu_icon, "Menu", "gfgfgf fggffg gdggfgfhg jjhjhje ewewesesf gv"));

        adapter = new FeaturedAdapter(featuredLocation);
        featuredRecycler.setAdapter(adapter);

        // to pass color
        Drawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff2ff400, 0xffaff600});
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //fxn outside onCreate

        int id = item.getItemId();
        if (id == R.id.all_categories) {
            startActivity(new Intent(getApplicationContext(), AllCategories.class));
        }


//        false means no item will be selected
//        true -- item can be selected
        return true;
    }
}