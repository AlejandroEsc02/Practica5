package com.example.root.practica5;


import android.view.View;

public interface RecyclerViewOnItemClickListener {
    void onClick(View v,int position);
    void passposition(int posi);
}
