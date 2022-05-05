package com.example.aklny;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        card=findViewById(R.id.main_card);
        //set card view background
        Drawable cardView_background = getResources().getDrawable(R.drawable.food_background);
        cardView_background.setAlpha(50);
        card.setBackground(cardView_background);

    }
}