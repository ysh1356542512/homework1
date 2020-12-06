package Contact;

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

import information.Users;
import watch.Wh1data;

public class Contact1Adapter extends RecyclerView.Adapter<Contact1Adapter.DyViewHolder> {

    private Context mContext;

    private List<Users> list;

    public Contact1Adapter(Context context, List<Users> list) {
        this.mContext = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Contact1Adapter.DyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_contact1, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Contact1Adapter.DyViewHolder holder, int position) {
        Users users = list.get(position);
        holder.mIvhead.setImageResource(users.getImageId());
        holder.mTvContext.setText(users.getUsersMessage());
        holder.mTvName.setText(users.getUsersName());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class DyViewHolder extends RecyclerView.ViewHolder {

        private ImageView mIvhead;
        private TextView mTvName,mTvContext;

        public DyViewHolder(View itemView) {
            super(itemView);
            mTvContext = itemView.findViewById(R.id.contact1_context);
            mTvName = itemView.findViewById(R.id.contact1_name);
            mIvhead = itemView.findViewById(R.id.contact1_head);
        }
    }
}