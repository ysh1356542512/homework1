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

public class watch1LinAdapter extends RecyclerView.Adapter<watch1LinAdapter.DyViewHolder> {

    private Context mContext;

    private List<Wh1data> list;

    public watch1LinAdapter(Context context, List<Wh1data> list) {
        this.mContext = context;
        this.list = list;
    }

    @NonNull
    @Override
    public watch1LinAdapter.DyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_watch1lin, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull watch1LinAdapter.DyViewHolder holder, int position) {
        Wh1data wh1data = list.get(position);
        holder.mIvhead.setImageResource(wh1data.getHead());
        holder.mIvPicture.setImageResource(wh1data.getPicture());
        holder.mTvContext.setText(wh1data.getContext());
        holder.mTvName.setText(wh1data.getName());
        holder.mTvNumber1.setText(wh1data.getNumber1());
        holder.mTvNumber2.setText(wh1data.getNumber2());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class DyViewHolder extends RecyclerView.ViewHolder {

        private ImageView mIvhead,mIvPicture;
        private TextView mTvContext,mTvName,mTvNumber1,mTvNumber2;

        public DyViewHolder(View itemView) {
            super(itemView);
            mTvContext = itemView.findViewById(R.id.watch1_lin_context);
            mTvName = itemView.findViewById(R.id.watch1_lin_name);
            mTvNumber1 = itemView.findViewById(R.id.watch1_lin_number1);
            mTvNumber2 = itemView.findViewById(R.id.watch1_lin_number2);
            mIvhead = itemView.findViewById(R.id.watch1_lin_head);
            mIvPicture = itemView.findViewById(R.id.watch1_lin_picture);
        }
    }
}