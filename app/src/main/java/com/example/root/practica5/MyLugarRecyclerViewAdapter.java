package com.example.root.practica5;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class MyLugarRecyclerViewAdapter extends RecyclerView.Adapter<MyLugarRecyclerViewAdapter.MyLugarRecyclerViewAdapterViewHolder> {

    private ArrayList<Miscarnes> miscarneslist;
    private RecyclerViewOnItemClickListener onRecyclerViewItemClickListener;



    public MyLugarRecyclerViewAdapter(ArrayList<Miscarnes> miscarneslist) {
        this.miscarneslist = miscarneslist;
    }

    @NonNull
    @Override
    public MyLugarRecyclerViewAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.fragment_lugar,parent,false);
        return new MyLugarRecyclerViewAdapterViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull MyLugarRecyclerViewAdapterViewHolder holder, int position) {
        Miscarnes miscarnes=miscarneslist.get(position);
        holder.bindMiscarnes(miscarnes);
    }

    @Override
    public int getItemCount() {
        return miscarneslist.size();
    }

    public class MyLugarRecyclerViewAdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView tDireccion, tHorario, tUbicacion;
        private LinearLayout click;

        public MyLugarRecyclerViewAdapterViewHolder(View itemView) {
            super(itemView);

            tUbicacion = itemView.findViewById(R.id.tUbicacion);

            click = itemView.findViewById(R.id.click);

            click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onRecyclerViewItemClickListener != null) {
                        onRecyclerViewItemClickListener.onClick(v, getAdapterPosition());

                    }
                }
            });
        }

        public void bindMiscarnes(Miscarnes miscarnes){
            tUbicacion.setText("Mis Carnes Parrilla: "+miscarnes.getUbicacion());
        }
    }
    public void setOnRecyclerViewItemClickListener(RecyclerViewOnItemClickListener onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }
}