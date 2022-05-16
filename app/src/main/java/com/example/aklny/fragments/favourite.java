package com.example.aklny.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aklny.R;
import com.example.aklny.adapters.meals_adapter;
import com.example.aklny.interfaces.onRecycleViewClickListener;
import com.example.aklny.objects.meals;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link favourite#newInstance} factory method to
 * create an instance of this fragment.
 */
public class favourite extends Fragment {
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        newArrayListMeals.add(new meals("alg",R.drawable.egyption_food,"kosherykosherykosherykosherykoshery",3,1,"kosherykosherykosherykoshery"));
        newArrayListMeals.add(new meals("koshery",R.drawable.egyption_food,"kosherykosherykosherykosherykoshery",3,2,"kosherykosherykosherykoshery"));
        newArrayListMeals.add(new meals("koshery",R.drawable.egyption_food,"kosherykosherykosherykosherykoshery",3,2,"kosherykosherykosherykoshery"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_favourite, container, false);
        content_favourite_meals_RCV=v.findViewById(R.id.content_favourite_meals_RCV);
        meals_adapter newAdapter=new meals_adapter(newArrayListMeals, "favourite",new onRecycleViewClickListener() {
            @Override
            public void getElementID(int elementID) {
                Toast.makeText(getActivity(), "id =" + elementID, Toast.LENGTH_SHORT).show();
            }
        });
        content_favourite_meals_RCV.setHasFixedSize(true);
        content_favourite_meals_RCV.setAdapter(newAdapter);
        return v;
    }
}