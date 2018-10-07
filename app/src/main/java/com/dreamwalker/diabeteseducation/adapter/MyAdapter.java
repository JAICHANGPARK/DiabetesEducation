package com.dreamwalker.diabeteseducation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dreamwalker.diabeteseducation.R;
import com.dreamwalker.diabeteseducation.model.Index;

import java.util.ArrayList;

public class MyAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private ArrayList<Index> index;
    private LayoutInflater inflater;

    //class Constructor
    public MyAdapter(Context mContext, ArrayList<Index> index) {

        this.mContext = mContext;
        this.index = index;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        return index.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return index.get(groupPosition).contents.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return index.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return index.get(groupPosition).contents.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //get parent row
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.parent_list, null);
        }

        Index position = (Index) getGroup(groupPosition);
        String positionName = position.index;

        TextView textView = (TextView) convertView.findViewById(R.id.position_tv);
        textView.setText(positionName);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.indicator);
        if (isExpanded) {
            imageView.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
        } else {
            imageView.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.child_list, null);
        }

        String child = (String) getChild(groupPosition, childPosition);

        TextView name = (TextView) convertView.findViewById(R.id.name_tv);
        name.setText(child);

        String indexName = (String) getGroup(groupPosition).toString();
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}