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
import com.example.aklny.databases.my_database;
import com.example.aklny.fragments.categories;
import com.example.aklny.fragments.content;
import com.example.aklny.fragments.details;
import com.example.aklny.fragments.empty_favourite;
import com.example.aklny.fragments.favourite;
import com.example.aklny.fragments.profile;
import com.example.aklny.objects.meals;

public class MainActivity extends AppCompatActivity implements categories.onCategorieClickListener ,content.getClickedElement,favourite.getElementIDfromFavourite{
    LinearLayout card,footer;
    Animation anim;
    ImageView btn_home,btn_favourite,btn_profile,card_img;
    my_database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //insert data to database
        db=new my_database(this);
        db.insertNewMeal(new meals(getString(R.string.Feteer_Meshaltet_for_the_diet_EG),R.drawable.feteer_meshaltet_for_the_diet,getString(R.string.Feteer_Meshaltet_for_the_diet_details_EG),4,1,"none"));
        db.insertNewMeal(new meals(getString(R.string.Hawawshi_EG),R.drawable.hawawshi,getString(R.string.Hawawshi_details_EG),2,2,"none"));
        db.insertNewMeal(new meals(getString(R.string.Egyptian_Fattah_Cups_EG),R.drawable.egyptian_fattah_cups,getString(R.string.Freekeh_soup_details_ALG),3,3,"none"));
        db.insertNewMeal(new meals(getString(R.string.Hamaam_Mahshiun_EG),R.drawable.hamaam_mahshiun,getString(R.string.Hamaam_Mahshiun_details_EG),5,4,"none"));
        db.insertNewMeal(new meals(getString(R.string.Moussaka_EG),R.drawable.moussaka,getString(R.string.Moussaka_details_EG),4,5,"none"));
        db.insertNewMeal(new meals(getString(R.string.Muammar_rice_EG),R.drawable.muammar_rice,getString(R.string.Muammar_rice_Details_EG),1,6,"none"));
        db.insertNewMeal(new meals(getString(R.string.Al_Tameya),R.drawable.al_tameya,getString(R.string.Al_Tameya_details),1,6,"none"));
        db.insertNewMeal(new meals(getString(R.string.cabbage_EG),R.drawable.cobbage,getString(R.string.cabbage_details_EG),1,6,"none"));
        db.insertNewMeal(new meals(getString(R.string.alraqaq_bialluhmat_almafruma_EG),R.drawable.alraqaq_bialluhmat_almafruma,getString(R.string.alraqaq_bialluhmat_almafruma_details_EG),1,6,"none"));

        db.insertNewMeal(new meals(getString(R.string.Eggplant_salad_TU),R.drawable.eggplant_salad,getString(R.string.Eggplant_salad_details_TU),4,7,"none"));
        db.insertNewMeal(new meals(getString(R.string.Frecasian_TU),R.drawable.frecasian,getString(R.string.Frecasian_details_TU),2,8,"none"));
        db.insertNewMeal(new meals(getString(R.string.Fried_crovet_TU),R.drawable.fried_crovet,getString(R.string.Fried_crovet_details_TU),3,9,"none"));
        db.insertNewMeal(new meals(getString(R.string.Masmota_salad_TU),R.drawable.masmota_salad,getString(R.string.Masmota_salad_details_TU),4,10,"none"));
        db.insertNewMeal(new meals(getString(R.string.Omelettes_in_the_mercury_TU),R.drawable.omelette_with_mergaz,getString(R.string.Omelettes_in_the_mercury_details_TU),4,11,"none"));
        db.insertNewMeal(new meals(getString(R.string.the_break_TU),R.drawable.the_break,getString(R.string.the_break_details_TU),4,11,"none"));
        db.insertNewMeal(new meals(getString(R.string.Tunisian_tagine_with_chicken_TU),R.drawable.tunisian_tagine_with_chicken,getString(R.string.Tunisian_tagine_with_chicken_details_TU),4,11,"none"));

        db.insertNewMeal(new meals(getString(R.string.Freekeh_soup_ALG),R.drawable.freekeh_soup,getString(R.string.Freekeh_soup_details_ALG),4,12,"none"));
        db.insertNewMeal(new meals(getString(R.string.Sable_ajwa_ALG),R.drawable.sable_ajwa,getString(R.string.Sable_ajwa_details_ALG),4,13,"none"));
        db.insertNewMeal(new meals(getString(R.string.Tagen_ALG),R.drawable.tagine,getString(R.string.Tagen_details_ALG),4,15,"none"));
        db.insertNewMeal(new meals(getString(R.string.couscous_ALG),R.drawable.couscous,getString(R.string.couscous_details_ALG),4,15,"none"));
        db.insertNewMeal(new meals(getString(R.string.alzalabih_ALG),R.drawable.alzalabih,getString(R.string.alzalabih_details_ALG),4,15,"none"));
        db.insertNewMeal(new meals(getString(R.string.nerves_ALG),R.drawable.nerves,getString(R.string.nerves_details_ALG),4,15,"none"));
        db.insertNewMeal(new meals(getString(R.string.bread_in_Algeria_ALG),R.drawable.bread_in_algeria,getString(R.string.bread_in_Algeria_details_ALG),4,15,"none"));
        db.insertNewMeal(new meals(getString(R.string.percox_ALG),R.drawable.percox,getString(R.string.percox_details_ALG),4,15,"none"));


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
                categories f=new categories();
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
                if (db.getFavMeals().size()==0){
                    empty_favourite f=new empty_favourite();
                    ft.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);
                    ft.replace(R.id.categories_fr_container,f);
                    ft.commit();
                }else{
                    favourite f=new favourite();
                    ft.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);
                    ft.replace(R.id.categories_fr_container,f);
                    ft.commit();
                }

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
        categories f=new categories();
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


    @Override
    public void getElementID(int elementID) {
        card.setVisibility(View.GONE);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Details");
        ColorDrawable colorDrawable= new ColorDrawable(Color.parseColor("#4D4C7D"));
        actionBar.setBackgroundDrawable(colorDrawable);
        //change footer color
        footer.setBackgroundColor(Color.parseColor("#827397"));
        //change status bar color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#4D4C7D"));
        }
        meals m=db.getMealsWithid(elementID);
        FragmentManager fmmmm=getSupportFragmentManager();
        FragmentTransaction ftttt=fmmmm.beginTransaction();
        ftttt.setCustomAnimations(R.anim.pop_enter,R.anim.pop_exit);
        ftttt.replace(R.id.categories_fr_container,new details().newInstance(m.getName(),m.getDetails(),m.getImg(),m.getRate()));
        ftttt.commit();
    }

    @Override
    public void getFavElementID(int id) {
        card.setVisibility(View.GONE);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Details");
        ColorDrawable colorDrawable= new ColorDrawable(Color.parseColor("#4D4C7D"));
        actionBar.setBackgroundDrawable(colorDrawable);
        //change footer color
        footer.setBackgroundColor(Color.parseColor("#827397"));
        //change status bar color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#4D4C7D"));
        }
        meals m=db.getMealsWithid(id);
        FragmentManager fmmmm=getSupportFragmentManager();
        FragmentTransaction ftttt=fmmmm.beginTransaction();
        ftttt.setCustomAnimations(R.anim.pop_enter,R.anim.pop_exit);
        ftttt.replace(R.id.categories_fr_container,new details().newInstance(m.getName(),m.getDetails(),m.getImg(),m.getRate()));
        ftttt.commit();
    }
}