package information;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.ysh.homework1.R;

import java.util.ArrayList;
import java.util.List;


public class ContactFragment extends Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;
    List<View> views;
    List<String> titles;


    public static ContactFragment newInstance(String param1, String param2) {
        ContactFragment fragment = new ContactFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = view.findViewById(R.id.contact_view_pager);
        tabLayout = view.findViewById(R.id.contact_tab_layout);

        titles = new ArrayList<>();
        titles.add("好友");
        titles.add("分组");
        titles.add("群聊");
        titles.add("设备");

        CtVpAdapter adapter = new CtVpAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, titles);

        for(String title:titles){
            tabLayout.addTab(tabLayout.newTab().setText(title));
        }

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact, container, false);
    }
}