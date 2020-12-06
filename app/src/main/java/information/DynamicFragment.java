package information;

import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ysh.homework1.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class DynamicFragment extends Fragment {

    private View view;
    private RecyclerView mRvDy;
    private List<DyUsers> list = new ArrayList<>();

    private DyAdapter dyAdapter;

    public DynamicFragment() {
    }

    public static DynamicFragment newInstance(String param1, String param2) {
        DynamicFragment fragment = new DynamicFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dynamic, container, false);
        // Inflate the layout for this fragment
        initRecyclerView();
        initData();
        return view;
    }

    private void initData(){
        DyUsers title = new DyUsers(0,"我是标题",0);
        DyUsers dongtai = new DyUsers(R.drawable.dy_dongtai,"好友动态",R.drawable.dy_arrow);
        DyUsers world = new DyUsers(R.drawable.dy_world,"小世界",R.drawable.dy_arrow);
        DyUsers near = new DyUsers(R.drawable.dy_near,"附近",R.drawable.dy_arrow);
        DyUsers friend = new DyUsers(R.drawable.dy_friend,"扩列",R.drawable.dy_arrow);
        DyUsers study = new DyUsers(R.drawable.dy_book,"自习室",R.drawable.dy_arrow);
        DyUsers yuyin = new DyUsers(R.drawable.dy_yuyin,"语音房",R.drawable.dy_arrow);
        DyUsers live = new DyUsers(R.drawable.dy_live,"直播",R.drawable.dy_arrow);
        DyUsers game = new DyUsers(R.drawable.dy_game,"游戏中心",R.drawable.dy_arrow);
        DyUsers dongman = new DyUsers(R.drawable.dy_dongman,"动漫",R.drawable.dy_arrow);
        DyUsers smgame = new DyUsers(R.drawable.dy_smgame,"小游戏",R.drawable.dy_arrow);
        DyUsers read = new DyUsers(R.drawable.dy_read,"阅读",R.drawable.dy_arrow);
        DyUsers shop = new DyUsers(R.drawable.dy_shop,"购物",R.drawable.dy_arrow);
        DyUsers aiqiyi = new DyUsers(R.drawable.dy_aiqiyi,"爱奇艺",R.drawable.dy_arrow);
        list.add(title);
        list.add(dongtai);
        list.add(near);
        list.add(friend);
        list.add(study);
        list.add(yuyin);
        list.add(live);
        list.add(game);
        list.add(dongman);
        list.add(smgame);
        list.add(read);
        list.add(shop);
        list.add(aiqiyi);
    }

    private void initRecyclerView(){
        mRvDy = view.findViewById(R.id.Rv_dy);
        mRvDy.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        dyAdapter = new DyAdapter(getActivity(),list);
        mRvDy.setAdapter(dyAdapter);
        mRvDy.addItemDecoration(new MyDecoration());

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

     class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}