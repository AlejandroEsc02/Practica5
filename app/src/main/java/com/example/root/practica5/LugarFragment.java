package com.example.root.practica5;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class LugarFragment extends Fragment implements RecyclerViewOnItemClickListener{
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MyLugarRecyclerViewAdapter myLugarRecyclerViewAdapter;
    private ArrayList<Miscarnes> miscarneslist;
    private FragmentManager fm;
    private RecyclerViewOnItemClickListener passe;

    private FragmentTransaction ft;

    private String [] ubicaciones={"CC Premium Plaza","CC San Diego","CC Santa Fe","CC Bosque Plaza","CC Los molinos"};
    private String [] direcciones={"Cra. 43A #30-25","Cl. 34 #43-66","Av. El Poblado #7","Cra. 52a #6586","Calle 30A ##82a-26"};
    private String [] horarios={"11:30-22:00","11:00-22:00","10:00-23:00","9:30–21:00","10:00-21:00"};

    public LugarFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lugar_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        miscarneslist = new ArrayList<>();
        myLugarRecyclerViewAdapter = new MyLugarRecyclerViewAdapter(miscarneslist);
        myLugarRecyclerViewAdapter.setOnRecyclerViewItemClickListener(this);
        recyclerView.setAdapter(myLugarRecyclerViewAdapter);




        fm = getFragmentManager();


        Miscarnes c1 = new Miscarnes(ubicaciones[0],direcciones[0],horarios[0]);
        Miscarnes c2 = new Miscarnes(ubicaciones[1],direcciones[1],horarios[1]);
        Miscarnes c3 = new Miscarnes(ubicaciones[2],direcciones[2],horarios[2]);
        Miscarnes c4 = new Miscarnes(ubicaciones[3],direcciones[3],horarios[3]);
        Miscarnes c5 = new Miscarnes(ubicaciones[4],direcciones[4],horarios[4]);
        miscarneslist.add(c1);
        miscarneslist.add(c2);
        miscarneslist.add(c3);
        miscarneslist.add(c4);
        miscarneslist.add(c5);

        myLugarRecyclerViewAdapter.notifyDataSetChanged();

        return view;
    }

    @Override
    public void onClick(View v, int position) {
        Miscarnes miscarnes = (Miscarnes) v.getTag();
        switch (v.getId()) {
            case R.id.click:
                passe.passposition(position);
                break;
        }
    }
    @Override
    public void passposition(int position) {

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            passe = (RecyclerViewOnItemClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnDataPass");
        }
    }

}