package com.ysh.homework1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class TextFragmentAdapter extends FragmentPagerAdapter {
    private String mTabTitles[];
    private List<Fragment> mList;

    public TextFragmentAdapter(FragmentManager fm,String tabTitles[],List<Fragment> list){
        super(fm);
        this.mList = list;
        this.mTabTitles = tabTitles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles[position];
    }
}
