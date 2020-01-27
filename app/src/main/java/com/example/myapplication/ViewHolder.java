package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView textview;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        textview = itemView.findViewById(R.id.tv_holder);
    }
    public void setText(String text){
        textview.setText(text);
    }
}
