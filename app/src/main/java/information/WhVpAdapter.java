package information;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import watch.watch1Fragment;
import watch.watch2Fragment;
import watch.watch3Fragment;
import watch.watch4Fragment;
import watch.watch5Fragment;

public final class WhVpAdapter extends FragmentPagerAdapter {

    private List<String> mTitles;

    private List<Fragment> fragments = new ArrayList();


    public WhVpAdapter(@NonNull FragmentManager fm, int behavior, List<String> titles) {
        this(fm, behavior);
        this.mTitles = titles;
        if (mTitles == null) {
            mTitles = new ArrayList<>();
        }
    }

    public WhVpAdapter(FragmentManager fm, int behaviorResumeOnlyCurrentFragment) {
        super(fm, behaviorResumeOnlyCurrentFragment);
        fragments.add(new watch1Fragment());
        fragments.add(new watch2Fragment());
        fragments.add(new watch3Fragment());
        fragments.add(new watch4Fragment());
        fragments.add(new watch5Fragment());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.size() > 0 ? mTitles.get(position) : "";
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


}
