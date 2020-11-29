package com.ysh.homework1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LineraViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;
    private OnItemLongClickListener mLongListen;

    private List<String> list;
    public LinearAdapter(Context context, OnItemClickListener listener, OnItemLongClickListener longListener){
        this.mContext = context; this.mListener = listener; this.mLongListen = longListener;
    }

    @Override
    public LinearAdapter.LineraViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LineraViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item,parent,false));
    }

    @Override
    public void onBindViewHolder(LinearAdapter.LineraViewHolder holder, int position) {
            holder.mTvlir1.setText("Hello world!");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClick(position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mLongListen.onLongClick(position);
                    return false;
                }
            });
    }
    @Override
    public int getItemCount() {
        return 30;
    }
    class LineraViewHolder extends RecyclerView.ViewHolder{
        private TextView mTvlir1;
        public LineraViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvlir1 = itemView.findViewById(R.id.tv_Lir1);
        }
    }
    //接口
    public interface  OnItemClickListener{
        void onClick(int position);
    }
    public interface OnItemLongClickListener{
        void onLongClick(int position);
    }
}
