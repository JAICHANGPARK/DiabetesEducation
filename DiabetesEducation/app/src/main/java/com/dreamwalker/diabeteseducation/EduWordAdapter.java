package com.dreamwalker.diabeteseducation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EduWordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvPrice;
        MyViewHolder(View view){
            super(view);
            tvPrice = view.findViewById(R.id.tv_price);
        }
    }

    private ArrayList<FoodInfo> foodInfoArrayList;
    EduWordAdapter(ArrayList<FoodInfo> foodInfoArrayList){
        this.foodInfoArrayList = foodInfoArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list2_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tvPrice.setText(foodInfoArrayList.get(position).price);
    }

    @Override
    public int getItemCount() {
        return foodInfoArrayList.size();
    }
}
