package watch;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ysh.homework1.R;

import java.util.ArrayList;
import java.util.List;

import information.DyUsers;


public class watch1Fragment extends Fragment {

    private View view;
    private RecyclerView mRvWhHor;
    private RecyclerView mRvWhLin;
    private List<DyUsers> list = new ArrayList<>();
    private List<Wh1data> list1 = new ArrayList<>();

    public watch1Fragment() {
    }

    public static watch1Fragment newInstance(String param1, String param2) {
        watch1Fragment fragment = new watch1Fragment();
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
        view = inflater.inflate(R.layout.fragment_watch1, container, false);

        return view;
    }


    private void initData(){
        DyUsers ysh = new DyUsers(R.drawable.watch1_ysh,"叶圣豪");
        DyUsers zjt = new DyUsers(R.drawable.watch1_zjt,"周汉中");
        DyUsers pyx = new DyUsers(R.drawable.watch1_pyx,"彭有新");
        DyUsers dk = new DyUsers(R.drawable.watch1_dk,"代楷");
        DyUsers zx = new DyUsers(R.drawable.watch1_zx,"张玺");
        DyUsers gq = new DyUsers(R.drawable.watch1_longge,"泷歌");
        DyUsers xueba = new DyUsers(R.drawable.watch1_master,"学霸");
        DyUsers son = new DyUsers(R.drawable.watch1_son,"儿子");
        DyUsers daughter = new DyUsers(R.drawable.watch1_daughter,"女儿");
        list.add(ysh);
        list.add(zjt);
        list.add(pyx);
        list.add(dk);
        list.add(zx);
        list.add(gq);
        list.add(xueba);
        list.add(son);
        list.add(daughter);

        Wh1data ysh1 = new Wh1data(R.drawable.watch1_ysh,R.drawable.watch1_lin_grandfather,"叶圣豪","我是爷爷，我儿孙满堂","25","1157");
        Wh1data zjt1 = new Wh1data(R.drawable.watch1_zjt,R.drawable.watch1_lin_son,"周汉中","我是孙子","12","162");
        Wh1data pyx1 = new Wh1data(R.drawable.watch1_pyx,R.drawable.watch1_lin_daughter,"彭有新","我是孙女","17","239");
        Wh1data dk1 = new Wh1data(R.drawable.watch1_dk,R.drawable.watch1_lin_son,"代楷","我是孙子","40","1288");
        Wh1data zx1 = new Wh1data(R.drawable.watch1_zx,R.drawable.watch1_lin_daughter,"张玺","我是男同","1","1");
        Wh1data gq1 = new Wh1data(R.drawable.watch1_longge,R.drawable.watch1_lin_son,"泷歌","我是孙子","2","67");
        list1.add(ysh1);
        list1.add(zjt1);
        list1.add(pyx1);
        list1.add(dk1);
        list1.add(zx1);
        list1.add(gq1);
    }

    private void initRecyclerView(View view){

        mRvWhHor = view.findViewById(R.id.Rv_watch1Hor);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getParentFragment().getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvWhHor.setLayoutManager(linearLayoutManager);
        watch.watch1Adapter watch1Adapter = new watch1Adapter(getContext(), list);
        mRvWhHor.setAdapter(watch1Adapter);

        mRvWhLin = view.findViewById(R.id.Rv_watch1Lin);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getParentFragment().getActivity());
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        mRvWhLin.setLayoutManager(linearLayoutManager1);
        watch.watch1LinAdapter watch1LinAdapter = new watch1LinAdapter(getContext(),list1);
        mRvWhLin.setAdapter(watch1LinAdapter);
//        mRvWhHor.addItemDecoration(new MyDecoration());
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initData();
        initRecyclerView(view);
    }

     class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}