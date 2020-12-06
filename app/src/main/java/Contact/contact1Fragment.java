package Contact;

import android.graphics.Rect;
import android.os.Bundle;
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
import information.Users;
import watch.Wh1data;
import watch.watch1Adapter;
import watch.watch1LinAdapter;


public class contact1Fragment extends Fragment {

    private View view;
    private RecyclerView mRvCt1;
    private List<Users> list = new ArrayList<>();
    private Contact1Adapter contact1Adapter;

    public contact1Fragment() {
    }

    public static contact1Fragment newInstance(String param1, String param2) {
        contact1Fragment fragment = new contact1Fragment();
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
        view = inflater.inflate(R.layout.fragment_contact_1, container, false);

        return view;
    }


    private void initData(){
        Users ysh = new Users(R.drawable.watch1_ysh,"Ysh","[手机在线]");
        Users zjt = new Users(R.drawable.watch1_zjt,"Zjt","[iPhone在线]");
        Users pyx = new Users(R.drawable.watch1_pyx,"Pyx","[4G在线]");
        Users zx = new Users(R.drawable.watch1_zx,"Zx","[iPhone在线]");
        Users gq = new Users(R.drawable.watch1_longge,"Gq","[5G在线]");
        Users dk = new Users(R.drawable.watch1_dk,"Dk","[手机在线]");
        list.add(ysh);
        list.add(zjt);
        list.add(pyx);
        list.add(zx);
        list.add(gq);
        list.add(dk);
    }

    private void initRecyclerView(View view){

        mRvCt1 = view.findViewById(R.id.Rv_contact1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getParentFragment().getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvCt1.setLayoutManager(linearLayoutManager);
        contact1Adapter = new Contact1Adapter(getContext(),list);
        mRvCt1.setAdapter(contact1Adapter);

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