package watch;

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

import information.DyUsers;

public class watch1Adapter extends RecyclerView.Adapter<watch1Adapter.DyViewHolder> {

    private Context mContext;

    private List<DyUsers> list;

    public watch1Adapter(Context context, List<DyUsers> list) {
        this.mContext = context;
        this.list = list;
    }

    @NonNull
    @Override
    public watch1Adapter.DyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_watch1hor, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull watch1Adapter.DyViewHolder holder, int position) {
        DyUsers dyUsers = list.get(position);
        holder.mIvhead.setImageResource(dyUsers.getImageId());
        holder.mTvContext.setText(dyUsers.getviewText());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class DyViewHolder extends RecyclerView.ViewHolder {

        private ImageView mIvhead;
        private TextView mTvContext;

        public DyViewHolder(View itemView) {
            super(itemView);
            mTvContext = itemView.findViewById(R.id.watch1_context);
            mIvhead = itemView.findViewById(R.id.watch1_head);
        }
    }
}