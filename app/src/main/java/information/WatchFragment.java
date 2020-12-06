package information;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.ysh.homework1.R;

import java.util.ArrayList;
import java.util.List;


public class WatchFragment extends Fragment {
    ViewPager viewPager;
    TabLayout tabLayout;
    List<View> views;
    List<String> titles;


    public static WatchFragment newInstance(String param1, String param2) {
        WatchFragment fragment = new WatchFragment();
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
        viewPager = view.findViewById(R.id.watch_view_pager);
        tabLayout = view.findViewById(R.id.watch_tab_layout);


        titles = new ArrayList<>();
        titles.add("关注");
        titles.add("推荐");
        titles.add("视频");
        titles.add("好友");
        titles.add("小说");
        titles.add("战役");


        WhVpAdapter adapter = new WhVpAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, titles);

        for (String title : titles) {
            tabLayout.addTab(tabLayout.newTab().setText(title));
        }

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_watch, container, false);
    }
}