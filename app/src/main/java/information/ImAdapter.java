package information;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ysh.homework1.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ImAdapter extends RecyclerView.Adapter<ImAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Users> usersArrayList;

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView mIvusers;
        private TextView mTvName;
        private TextView mTvMessage;

        public ViewHolder(View view){
            super(view);
            mIvusers = view.findViewById(R.id.item_head);
            mTvName = view.findViewById(R.id.item_name);
            mTvMessage = view.findViewById(R.id.item_message);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"点击了xxx",Toast.LENGTH_SHORT).show();
                    if(onItemClickListener!=null){
                        onItemClickListener.OnItemClick(v,usersArrayList.get(getLayoutPosition()));
                    }
                }
            });
        }
    }
    public ImAdapter(Context context, ArrayList<Users> usersArrayList){
        this.usersArrayList = usersArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = View.inflate(context,R.layout.item_im,null);

        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ImAdapter.ViewHolder holder, int position) {

        Users users = usersArrayList.get(position);
            holder.mIvusers.setImageResource(users.getImageId());
            holder.mTvName.setText(users.getUsersName());
            holder.mTvMessage.setText(users.getUsersMessage());
    }

    @Override
    public int getItemCount() {
        return usersArrayList.size();
    }
    public interface OnItemClickListener {
        public void OnItemClick(View view, Users users);
    }
    private OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
}
