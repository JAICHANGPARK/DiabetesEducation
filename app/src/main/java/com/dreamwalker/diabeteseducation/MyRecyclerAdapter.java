package com.dreamwalker.diabeteseducation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    public static Context mContext;
    private final List<CardItem> mDataList;

    //
    // Adapter 초기화 및 생성자로 받은 데이터기반으로 Adapter 내 데이터 세팅
    public MyRecyclerAdapter(List<CardItem> dataList) {
        mDataList = dataList;
    }

    // ViewHolder가 초기화 될 때 혹은 ViewHolder를 초기화 할 때 실행되는 메서드
    // 뷰 홀더를 생성하는 부분. 레이아웃을 만드는 부분
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_intro, parent, false);
        return new ViewHolder(view);
    }

    // RecyclerView의 Row 하나하나를 구현하기위해 Bind(묶이다) 될 때
    // 뷰 홀더에 데이터를 설정하는 부분
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardItem item = mDataList.get(position);

//        ImageView image = holder.image;
        TextView name = holder.name;
        TextView grade = holder.grade;
        TextView email = holder.email;
        TextView call = holder.call;
        TextView assign = holder.assign;

//        holder.image.setImageResource(item.getImage());
        holder.name.setText(item.getName());
        holder.grade.setText(item.getGrade());
        holder.email.setText(item.getEmail());
        holder.call.setText(item.getCall());
        holder.assign.setText(item.getAssign());
    }

    // 아이템의 수
    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    // 각각의 아이템의 레퍼런스를 저장할 뷰 홀더 클래스
    // 반드시 RecyclerView.ViewHolder를 상속해야 함
    public class ViewHolder extends RecyclerView.ViewHolder {

        //        ImageView image;
        TextView name, grade, email, call, assign;

        public ViewHolder(View itemView) {
            super(itemView);
//            image = ( ImageView ) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.text_name);
            grade = (TextView) itemView.findViewById(R.id.text_grade);
            email = (TextView) itemView.findViewById(R.id.text_email);
            call = (TextView) itemView.findViewById(R.id.text_call);
            assign = (TextView) itemView.findViewById(R.id.text_assign);
        }
    }
}