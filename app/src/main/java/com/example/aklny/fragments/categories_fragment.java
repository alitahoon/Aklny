package com.example.aklny.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aklny.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link categories_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class categories_fragment extends Fragment {
    onCategorieClickListener listener;
    CardView btn_egy_food,btn_tun_food,btn_mor_food,btn_alg_food;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public categories_fragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof categories_fragment.onCategorieClickListener)
            listener=(categories_fragment.onCategorieClickListener)context;
        else
            throw  new ClassCastException("your activity doesn't implrmrnt onCategorieClickListener interface");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment categories_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static categories_fragment newInstance(String param1, String param2) {
        categories_fragment fragment = new categories_fragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_categories_fragment, container, false);
        btn_alg_food=v.findViewById(R.id.btn_alg_food);
        btn_egy_food=v.findViewById(R.id.btn_egy_food);
        btn_mor_food=v.findViewById(R.id.btn_mor_food);
        btn_tun_food=v.findViewById(R.id.btn_tun_food);

        btn_egy_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCategorieClick("egy_food");
            }
        });
        btn_tun_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCategorieClick("tun_food");
            }
        });
        btn_alg_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCategorieClick("alg_food");
            }
        });
        btn_mor_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCategorieClick("mor_food");
            }
        });
        return v;
    }
    public interface onCategorieClickListener{
        void onCategorieClick(String catName);
    }
}