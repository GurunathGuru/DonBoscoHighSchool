package com.integro.dbhs.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.integro.dbhs.fragments.HomeFragment;
import com.integro.dbhs.fragments.NewsFragment;
import com.integro.dbhs.fragments.NotificationsFragment;
import com.integro.dbhs.fragments.AddressFragment;

public class SlideAdapter extends FragmentPagerAdapter {

    public SlideAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        if (i == 0) {
            fragment = new HomeFragment();
        }
        if (i == 1) {
            fragment = new NewsFragment();
        }
        if (i == 2) {
            fragment = new NotificationsFragment();
        }
        if (i == 3) {
            fragment = new AddressFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
