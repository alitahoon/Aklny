package com.example.aklny.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aklny.R;
import com.example.aklny.adapters.meals_adapter;
import com.example.aklny.databases.my_database;
import com.example.aklny.interfaces.onRecycleViewClickListener;
import com.example.aklny.objects.meals;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link content#newInstance} factory method to
 * create an instance of this fragment.
 */
public class content extends Fragment {
    my_database db;
    getClickedElement listener;
    RecyclerView RCV_content;
    TextView title;
    ArrayList<meals> newMealsList=new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_kindOfData = "kindOfData";
    // TODO: Rename and change types of parameters
    private String mkindOfData;

    public content() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof getClickedElement){
            listener=(getClickedElement) context;
        }else{
            throw  new ClassCastException("your activity doesn't implrmrnt getClickedElement interface");
        }
        db=new my_database(context);
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
     * @param kindOfData Parameter 2.
     * @return A new instance of fragment content.
     */
    // TODO: Rename and change types and number of parameters
    public static content newInstance(String kindOfData) {
        content fragment = new content();
        Bundle args = new Bundle();
        args.putString(ARG_kindOfData,kindOfData);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mkindOfData = getArguments().getString(ARG_kindOfData);
        }
        if (mkindOfData=="egy_food"){
            //fill the list
            Toast.makeText(getActivity(), ""+mkindOfData, Toast.LENGTH_SHORT).show();
            newMealsList=db.getMealsWithid(0,9);
        }else if(mkindOfData=="tun_food"){
            newMealsList=db.getMealsWithid(10,16);
        }else if(mkindOfData == "mor_food"){
            newMealsList=db.getMealsWithid(1,9);
        }else if(mkindOfData == "alg_food"){
            newMealsList=db.getMealsWithid(17,23);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_content, container, false);
        RCV_content=v.findViewById(R.id.content_meals_RCV);
        title=v.findViewById(R.id.categorie_title);
        //handle categorie title
        switch (mkindOfData){
            case "egy_food":
                title.setText("Egyption Food");
                break;
            case "mor_food":
                title.setText("Morcooean Food");
            case "tun_food":
                title.setText("Tunsian Food");
                break;
            case"alg_food":
                title.setText("Algrian Food");
                break;
        }
        //create adapter
        meals_adapter newAdapetr=new meals_adapter(newMealsList, "not favourite",getContext(),new onRecycleViewClickListener() {
            @Override
            public void getElementID(int elementID) {
                listener.getElementID(elementID);

            }
        });
        RCV_content.setHasFixedSize(true);
        RCV_content.setAdapter(newAdapetr);
        Toast.makeText(getActivity(), "done "+newAdapetr.getItemCount(), Toast.LENGTH_SHORT).show();
        return v;
    }
    public interface getClickedElement {
        void getElementID(int elementID);
    }
}