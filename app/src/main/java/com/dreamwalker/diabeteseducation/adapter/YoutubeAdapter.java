package com.dreamwalker.diabeteseducation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dreamwalker.diabeteseducation.R;
import com.dreamwalker.diabeteseducation.model.YoutubeItem;

import java.util.List;

public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeAdapter.ViewHolder> {

    private final List<YoutubeItem> mDataList;
    private YoutubeViewClickListener mListener;
    private static int TYPE_FOOTER = 3;

    public YoutubeAdapter(List<YoutubeItem> dataList) {
        mDataList = dataList;
    }

    // 뷰 홀더를 생성하는 부분. 레이아웃을 만드는 부분
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.youtube_item, parent, false);
        return new ViewHolder(view);
    }

    // 뷰 홀더에 데이터를 설정하는 부분
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        YoutubeItem item = mDataList.get(position);

        holder.itemImage.setImageResource(item.getImage());
        holder.itemName.setText(item.getText());

        // 클릭 이벤트
        if (mListener != null) {
            // 현재 위치
            final int pos = holder.getAdapterPosition();
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClicked(pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemName;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.itemImage);
            itemName = (TextView) itemView.findViewById(R.id.itemName);
        }
    }

    public void setOnClickListener(YoutubeViewClickListener listener) {
        mListener = listener;
    }

    public interface YoutubeViewClickListener {
        void onItemClicked(int position);
    }
}
