package com.example.aklny.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.aklny.R;
import com.example.aklny.fragments.login;
import com.example.aklny.fragments.register;

public class splash extends AppCompatActivity implements login.onLoginFragmentClcicked,register.onRegisterFragmentClicked{
    ImageView logo_img;
    TextView txt_title;
    LottieAnimationView LAV_spalsh_anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        //change status bar color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#222831"));
        }
        logo_img=findViewById(R.id.logo_img);
        LAV_spalsh_anim=findViewById(R.id.lotti_anim);
        txt_title=findViewById(R.id.txt_title);
        logo_img.animate().translationY(-200).setDuration(800).setStartDelay(2000);
        txt_title.animate().translationY(-200).setDuration(800).setStartDelay(2000);
        LAV_spalsh_anim.animate().translationY(1000).setDuration(800).setStartDelay(2000);
        txt_title.animate().translationY(-200).setDuration(800).setStartDelay(2000);
        logo_img.animate().rotationX(360).setDuration(800).setStartDelay(2000);
        logo_img.animate().rotationY(360).setDuration(800).setStartDelay(2000);
        logo_img.animate().rotationYBy(360).setDuration(800).setStartDelay(2000);
        logo_img.animate().rotationXBy(360).setDuration(800).setStartDelay(2000);

        txt_title.animate().rotationX(360).setDuration(800).setStartDelay(2000);
        txt_title.animate().rotationY(360).setDuration(800).setStartDelay(2000);
        txt_title.animate().rotationYBy(360).setDuration(800).setStartDelay(2000);
        txt_title.animate().rotationXBy(360).setDuration(800).setStartDelay(2000);
        //get login fragment
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        FragmentManager fm=getSupportFragmentManager();
                        FragmentTransaction ft=fm.beginTransaction();
                        login l=new login();
                        ft.setCustomAnimations(R.anim.enter,R.anim.exit);
                        ft.replace(R.id.login_container,l);
                        ft.commit();
                    }
                });
            }
        }).start();

    }


    @Override
    public void onLoginButtonClick(String loginClickedButton) {
        switch (loginClickedButton){
            case "register":
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                register l=new register();
                ft.setCustomAnimations(R.anim.enter,R.anim.exit);
                ft.replace(R.id.login_container,l);
                ft.commit();
                break;
            case "login":
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                overridePendingTransition(R.anim.enter,R.anim.exit);
                startActivity(i);
        }
    }

    @Override
    public void onRegisterRegisterClick(String RegisterClciked) {
        switch (RegisterClciked){
            case "register":
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                login l=new login();
                ft.setCustomAnimations(R.anim.enter,R.anim.exit);
                ft.replace(R.id.login_container,l);
                ft.commit();
                break;
        }
    }
}