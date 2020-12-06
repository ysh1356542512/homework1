package information;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import Contact.contact1Fragment;
import Contact.contact2Fragment;
import Contact.contact3Fragment;
import Contact.contact4Fragment;

public final class CtVpAdapter extends FragmentPagerAdapter {

    private List<String> mTitles;

    private List<Fragment> fragments = new ArrayList();


    public CtVpAdapter(@NonNull FragmentManager fm, int behavior, List<String> titles) {
        this(fm, behavior);
        this.mTitles = titles;
        if (mTitles == null) {
            mTitles = new ArrayList<>();
        }
    }

    public CtVpAdapter(FragmentManager fm, int behaviorResumeOnlyCurrentFragment) {
        super(fm, behaviorResumeOnlyCurrentFragment);
        fragments.add(new contact1Fragment());
        fragments.add(new contact2Fragment());
        fragments.add(new contact3Fragment());
        fragments.add(new contact4Fragment());
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
