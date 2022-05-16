package com.example.aklny.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.aklny.R;
import com.example.aklny.fragments.categories_fragment;
import com.example.aklny.fragments.content;
import com.example.aklny.fragments.favourite;
import com.example.aklny.fragments.profile;

public class MainActivity extends AppCompatActivity implements categories_fragment.onCategorieClickListener{
    LinearLayout card,footer;
    Animation anim;
    ImageView btn_home,btn_favourite,btn_profile,card_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //change status bar color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#63BC3C"));
        }
        card=findViewById(R.id.main_card);
        anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scal);
        btn_home=findViewById(R.id.btn_main_home);
        btn_favourite=findViewById(R.id.btn_main_favourite);
        btn_profile=findViewById(R.id.btn_main_profile);
        footer=findViewById(R.id.main_footer);
//        card_img=findViewById(R.id.card_img);
        //handle slide show in cardView
//        int a[]={R.drawable.food_background1,R.drawable.food_background2,R.drawable.food_background3};
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    runOnUiThread(new Runnable() {
//
//                        @Override
//                        public void run() {
//                                card_img.setAnimation(anim);
//                                card_img.setAlpha(65);
//                                card.setBackgroundDrawable( R.drawable.food_background3);
//                        }
//                    });
//                }
//            }).start();



        //handle profile button
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            //make the action of hide the card to delay 0.5 seconds
            public void onClick(View view) {
                btn_home.setColorFilter(Color.parseColor("#F7F7F7"));
                btn_profile.setColorFilter(Color.parseColor("#926E6F"));
                btn_favourite.setColorFilter(Color.parseColor("#F7F7F7"));
                footer.setBackgroundColor(Color.parseColor("#343A40"));
                //change status bar color
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(Color.parseColor("#343A40"));
                }
                    ActionBar actionBar=getSupportActionBar();
                    actionBar.setTitle("Profile");
                    ColorDrawable colorDrawable= new ColorDrawable(Color.parseColor("#343A40"));
                    actionBar.setBackgroundDrawable(colorDrawable);
                    //get profile fragment
                    FragmentManager fm= getSupportFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    profile f=new profile();
                    ft.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
                    ft.replace(R.id.categories_fr_container,f);
                    ft.commit();
                    card.setVisibility(View.GONE);

                }
        });
        //handle home button
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(Color.parseColor("#63BC3C"));
                }
                btn_home.setColorFilter(Color.parseColor("#926E6F"));
                btn_profile.setColorFilter(Color.parseColor("#F7F7F7"));
                btn_favourite.setColorFilter(Color.parseColor("#F7F7F7"));
                ActionBar actionBar=getSupportActionBar();
                actionBar.setTitle("Aklny");
                ColorDrawable colorDrawable= new ColorDrawable(Color.parseColor("#63BC3C"));
                actionBar.setBackgroundDrawable(colorDrawable);
                footer.setBackgroundColor(Color.parseColor("#63BC3C"));
                //get categories fragment
                FragmentManager fm= getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                categories_fragment f=new categories_fragment();
                ft.setCustomAnimations(R.anim.pop_enter,R.anim.pop_exit);
                ft.replace(R.id.categories_fr_container,f);
                ft.commit();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                card.setAnimation(anim);
                                card.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                }).start();
            }
        });
        btn_favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_home.setColorFilter(Color.parseColor("#F7F7F7"));
                btn_profile.setColorFilter(Color.parseColor("#F7F7F7"));
                btn_favourite.setColorFilter(Color.parseColor("#926E6F"));
                card.setVisibility(View.GONE);
                ActionBar actionBar=getSupportActionBar();
                actionBar.setTitle("Aklny");
                ColorDrawable colorDrawable= new ColorDrawable(Color.parseColor("#92BA92"));
                actionBar.setBackgroundDrawable(colorDrawable);
                //change footer color
                footer.setBackgroundColor(Color.parseColor("#92BA92"));
                //change status bar color
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(Color.parseColor("#92BA92"));
                }
                //get favourite fragment
                FragmentManager fm= getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                favourite f=new favourite();
                ft.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);
                ft.replace(R.id.categories_fr_container,f);
                ft.commit();
            }
        });

        // Define ActionBar object
        ActionBar actionBar;
        actionBar = getSupportActionBar();

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter

        ColorDrawable colorDrawable= new ColorDrawable(Color.parseColor("#63BC3C"));
        actionBar.setBackgroundDrawable(colorDrawable);

        //set card view background
        Drawable cardView_background = getResources().getDrawable(R.drawable.food_background1);
        cardView_background.setAlpha(65);
        card.setBackground(cardView_background);
        //get categories fragment
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        categories_fragment f=new categories_fragment();
        ft.replace(R.id.categories_fr_container,f);
        ft.commit();

    }
    //handle click in fragment element
    @Override
    public void onCategorieClick(String catName) {
        Toast.makeText(this, "clicked "+ catName, Toast.LENGTH_SHORT).show();
        switch (catName){
            case "egy_food":
                //get the fragment of categorie content
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.setCustomAnimations(R.anim.pop_enter,R.anim.pop_exit);
                ft.replace(R.id.categories_fr_container,new content().newInstance("egy_food"));
                ft.commit();
                break;
            case "tun_food":
                FragmentManager fmm=getSupportFragmentManager();
                FragmentTransaction ftt=fmm.beginTransaction();
                ftt.setCustomAnimations(R.anim.pop_enter,R.anim.pop_exit);
                ftt.replace(R.id.categories_fr_container,new content().newInstance("tun_food"));
                ftt.commit();
                break;
            case "alg_food":
                FragmentManager fmmm=getSupportFragmentManager();
                FragmentTransaction fttt=fmmm.beginTransaction();
                fttt.setCustomAnimations(R.anim.pop_enter,R.anim.pop_exit);
                fttt.replace(R.id.categories_fr_container,new content().newInstance("alg_food"));
                fttt.commit();
                break;
            case "mor_food":
                FragmentManager fmmmm=getSupportFragmentManager();
                FragmentTransaction ftttt=fmmmm.beginTransaction();
                ftttt.setCustomAnimations(R.anim.pop_enter,R.anim.pop_exit);
                ftttt.replace(R.id.categories_fr_container,new content().newInstance("mor_food"));
                ftttt.commit();
                break;
        }
    }
}