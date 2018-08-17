package com.dreamwalker.diabeteseducation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class EduWordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView diabetes_list;
        MyViewHolder(View view){
            super(view);
            diabetes_list = view.findViewById(R.id.diabetes_list);
        }
    }

    private ArrayList<WordInfo> wordInfoArrayList;
    EduWordAdapter(ArrayList<WordInfo> wordInfoArrayList){
        this.wordInfoArrayList = wordInfoArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list2_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.diabetes_list.setText(wordInfoArrayList.get(position).list);
    }

    @Override
    public int getItemCount() {
        return wordInfoArrayList.size();
    }
}
