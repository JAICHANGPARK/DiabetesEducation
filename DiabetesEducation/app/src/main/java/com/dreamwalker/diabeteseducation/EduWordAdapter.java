package com.dreamwalker.diabeteseducation;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class EduWordAdapter extends RecyclerView.Adapter<EduWordAdapter.ViewHolder> {
    private Context mContext;
    private ArrayLIst<DataForm> dataList;

    public EduWordAdapter(Context mContext, ArrayList<Integer> dataList){
        this.mContext = mContext;
        this.dataList = dataList;
    }

    public int getItemCount(){
        return dataList.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext().inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView){
            super(itemView);
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int i) {

    }

    private void removeItem(int position){
        dataList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, dataList.size());
    }

    private class ArrayLIst<T> {
    }
}