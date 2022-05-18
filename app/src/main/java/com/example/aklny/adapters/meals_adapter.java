package com.example.aklny.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.aklny.R;
import com.example.aklny.databases.my_database;
import com.example.aklny.interfaces.onRecycleViewClickListener;
import com.example.aklny.objects.meals;

import java.util.ArrayList;

public class meals_adapter extends RecyclerView.Adapter<meals_adapter.meal> {
    ArrayList<meals> newMealsList;
    onRecycleViewClickListener listener;
    String RCV_type;
    my_database db;

    public meals_adapter(ArrayList<meals> newMealsList, String Rcv_type , Context context,onRecycleViewClickListener listener) {
        this.newMealsList = newMealsList;
        this.listener=listener;
        this.RCV_type=Rcv_type;
        db=new my_database(context);
    }

    @NonNull
    @Override
    public meal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (RCV_type=="favourite"){
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_meals_layout,null,false);
            meal newMeal=new meal(v);
            return newMeal;
        }else {
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.meals_layout,null,false);
            meal newMeal=new meal(v);
            return newMeal;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull meal holder, int position) {
        meals m= newMealsList.get(position);
        holder.name.setText(m.getName());
        holder.id=m.getId();
        holder.img.setImageResource(m.getImg());
        holder.rate.setRating(m.getRate());
        holder.details.setText(m.getDetails());

    }

    @Override
    public int getItemCount() {
        return newMealsList.size();
    }

    class meal extends RecyclerView.ViewHolder{
        TextView name;
        TextView details;
        ImageView img;
        RatingBar rate;
        LottieAnimationView LAV_fav;
        int id;
        public meal(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.meal_name);
            details=itemView.findViewById(R.id.meal_details);
            img=itemView.findViewById(R.id.meal_img);
            rate=itemView.findViewById(R.id.meal_rating);
            if (RCV_type=="not favourite"){
                LAV_fav=itemView.findViewById(R.id.lotti_anim_content);
                //handle click favourite lotti button
                LAV_fav.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LAV_fav.playAnimation();
                        db.insertNewFavMeal(db.getMealsWithid(id));
                    }
                });
            }
            //send clcked item id to the fragment
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (RCV_type=="not favourite"){
                        listener.getElementID(id);
                    }else{
                        listener.getElementID(db.getFavMealsWithid(id).getId());
                    }

                }
            });

        }
    }
}
