package com.example.aklny.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aklny.R;
import com.example.aklny.adapters.meals_adapter;
import com.example.aklny.databases.my_database;
import com.example.aklny.interfaces.onRecycleViewClickListener;
import com.example.aklny.objects.meals;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link favourite#newInstance} factory method to
 * create an instance of this fragment.
 */
public class favourite extends Fragment {
    int i=0;
    getElementIDfromFavourite listener;
    RecyclerView content_favourite_meals_RCV;
    ArrayList<meals> newArrayListMeals=new ArrayList<>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public favourite() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment favourite.
     */
    // TODO: Rename and change types and number of parameters
    public static favourite newInstance(String param1, String param2) {
        favourite fragment = new favourite();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof getElementIDfromFavourite){
            listener=(getElementIDfromFavourite) context;
        }else{
            throw new ClassCastException("your activity doesn't implement getElementIDfromFavourite interface");
        }
        my_database db=new my_database(context);
        newArrayListMeals=db.getFavMeals();
        i=newArrayListMeals.size();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
//        newArrayListMeals.add(new meals("gfdg",R.drawable.food_background1,"sdfsdf",2,1,"fwefwef"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_favourite, container, false);
        content_favourite_meals_RCV=v.findViewById(R.id.content_favourite_meals_RCV);
        meals_adapter newAdapter=new meals_adapter(newArrayListMeals, "favourite",getContext(),new onRecycleViewClickListener() {
            @Override
            public void getElementID(int elementID) {
                Toast.makeText(getActivity(), "id =" + elementID, Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), " بكلمك م الفيفورت ي زعييم  وصلني بالمين وحياات ابوووك ", Toast.LENGTH_SHORT).show();
                listener.getFavElementID(elementID);
            }
        });
        Toast.makeText(getActivity(), "size = " +i, Toast.LENGTH_SHORT).show();
        content_favourite_meals_RCV.setHasFixedSize(true);
        content_favourite_meals_RCV.setAdapter(newAdapter);
        return v;
    }
    public  interface getElementIDfromFavourite{
        void getFavElementID(int id);
    }
}