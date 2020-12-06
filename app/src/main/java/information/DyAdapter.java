package information;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ysh.homework1.R;

import java.util.List;

public class DyAdapter extends RecyclerView.Adapter<DyAdapter.DyViewHolder>{

    private Context mContext;

    private List<DyUsers> list;

    public DyAdapter(Context context,List<DyUsers> list){
        this.mContext = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DyAdapter.DyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_dynatic,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DyAdapter.DyViewHolder holder, int position) {
        DyUsers dyUsers = list.get(position);
        if(position == 0){
            holder.mTvTitle.setText(dyUsers.getviewText());
        } else{
            holder.mIvhead.setImageResource(dyUsers.getImageId());
            holder.mTvContext.setText(dyUsers.getviewText());
            holder.mIvEnd.setImageResource(dyUsers.getImageIcon());
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class DyViewHolder extends RecyclerView.ViewHolder{

        private TextView mTvContext;
        private ImageView mIvhead;
        private TextView mTvTitle;
        private ImageView mIvEnd;

        public DyViewHolder(View itemView){
            super(itemView);
            mTvContext = itemView.findViewById(R.id.dy_context);
            mIvhead = itemView.findViewById(R.id.dy_head);
            mTvTitle = itemView.findViewById(R.id.dy_title);
            mIvEnd = itemView.findViewById(R.id.dy_end);
        }
    }
}