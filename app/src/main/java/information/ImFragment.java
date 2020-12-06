package information;

import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.ysh.homework1.MainActivity;
import com.ysh.homework1.R;

import java.util.ArrayList;


public class ImFragment extends Fragment {

    private View view;
    private RecyclerView mRvIm;
    private ArrayList<Users> usersArrayList = new ArrayList<Users>();

    private ImAdapter imAdapter;

    private TextView mTvIm;

    public static ImFragment newInstance(String param1, String param2) {
        ImFragment fragment = new ImFragment();
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

    //布局文件
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_im, container, false);
        // Inflate the layout for this fragment
//        initRecyclerView();
//        initData();

        return view;
    }

    private void initData() {
        Users ysh = new Users(R.drawable.watch1_ysh,"Ysh","我是叶圣豪",null);
        Users zjt = new Users(R.drawable.watch1_zjt,"Zjt","我是周汉中",null);
        Users gq = new Users(R.drawable.watch1_longge,"Gq","我是泷歌",null);
        Users zx = new Users(R.drawable.watch1_zx,"Zx","我是张玺",null);
        Users pyx = new Users(R.drawable.watch1_pyx,"Pyx","我是彭有新",null);
        Users dk = new Users(R.drawable.watch1_dk,"Dk","我是代楷",null);
        Users rat = new Users(R.drawable.rat, "rat", "我是老鼠",null);
        Users mou = new Users(R.drawable.mou, "mou", "我是牛牛",null);
        Users lion = new Users(R.drawable.lion, "lion", "我是老虎",null);
        Users rabbit = new Users(R.drawable.rabbit, "rabbit", "我是兔子",null);
        Users dragon = new Users(R.drawable.dragon, "dragon", "我是龙哥",null);
        Users snake = new Users(R.drawable.snake, "snake", "我是蛇",null);
        Users horse = new Users(R.drawable.horse, "horse", "我是马",null);
        Users sheep = new Users(R.drawable.sheep, "sheep", "我是羊",null);
        Users monkey = new Users(R.drawable.monkey, "monkey", "我是猴",null);
        Users ken = new Users(R.drawable.ken, "ken", "我是鸡",null);
        Users dog = new Users(R.drawable.dog, "dog", "我是狗",null);
        Users pig = new Users(R.drawable.pig, "pig", "我是猪",null);
        usersArrayList.add(ysh);
        usersArrayList.add(zjt);
        usersArrayList.add(gq);
        usersArrayList.add(zx);
        usersArrayList.add(pyx);
        usersArrayList.add(dk);
        usersArrayList.add(rat);
        usersArrayList.add(mou);
        usersArrayList.add(lion);
        usersArrayList.add(rabbit);
        usersArrayList.add(dragon);
        usersArrayList.add(snake);
        usersArrayList.add(horse);
        usersArrayList.add(sheep);
        usersArrayList.add(monkey);
        usersArrayList.add(ken);
        usersArrayList.add(dog);
        usersArrayList.add(pig);
    }

    private void initRecyclerView() {
        mRvIm = view.findViewById(R.id.Rv_im);
        imAdapter = new ImAdapter(getActivity(), usersArrayList);
        mRvIm.setAdapter(imAdapter);
        mRvIm.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRvIm.addItemDecoration(new MyDecoration());

        imAdapter.setOnItemClickListener(new ImAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, Users users) {
                Toast.makeText(getActivity(), "我是item", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //findById
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView();
        initData();
    }
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }

}