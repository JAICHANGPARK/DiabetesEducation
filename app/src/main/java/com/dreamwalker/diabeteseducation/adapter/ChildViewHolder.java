/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.dreamwalker.diabeteseducation.adapter;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.dreamwalker.diabeteseducation.R;
import com.dreamwalker.diabeteseducation.model.Child;

public class ChildViewHolder extends com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder {
    private static final String TAG = "ChildViewHolder";
    private TextView childTextView;

    public ChildViewHolder(View itemView) {
        super(itemView);
        childTextView = (TextView) itemView.findViewById(R.id.list_item_artist_name);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e(TAG, "onClick: +clicked "  + childTextView.getText().toString());
            }
        });
    }

    public void setArtistName(String name) {
        childTextView.setText(name);
    }

    public void binData(final Child items, final EduAdapter.OnItemClickListener listener){
        childTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(items);
            }
        });
    }

}