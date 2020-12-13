package com.ysh.homework1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LvTwoAdapter extends RecyclerView.Adapter<LvTwoAdapter.ViewHolder> {


    private Context context;
    private ArrayList<Data> dataArrayList;

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTvOne;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvOne = itemView.findViewById(R.id.item_one_url);

            itemView.setOnClickListener(this);
            mTvOne.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(onItemClickListener!=null){
                WebActivity.web = mTvOne.getText().toString();
                onItemClickListener.OnItemClick(v,getAdapterPosition());
            }
        }
    }
    public LvTwoAdapter(Context context, ArrayList<Data> dataArrayList){
        this.dataArrayList = dataArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemone,parent,false);
                return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LvTwoAdapter.ViewHolder holder, int position) {
        Data data = dataArrayList.get(position);
        holder.mTvOne.setText(data.getData());
    }


    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return dataArrayList.get(position).type;
    }

    public interface OnItemClickListener {
        public void OnItemClick(View view, int postion);
    }
    private OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
}
