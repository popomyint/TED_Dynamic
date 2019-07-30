package com.example.ted_dynamic;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ted_dynamic.Bottom_Fragment.Talks_Frag;
import com.example.ted_dynamic.Child_Fragment.Most_Viewed_Frag;
import com.example.ted_dynamic.Child_Fragment.Newest_Frag;
import com.example.ted_dynamic.Child_Fragment.Trending_Frag;

public class TabAdapter extends FragmentPagerAdapter {
    Talks_Frag talksFrag;
    int tid;
    public TabAdapter(FragmentManager fm, Talks_Frag talks_frag, int tid) {
        super(fm);
        talksFrag = talks_frag;
        this.tid = tid;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Newest_Frag nFrag = new Newest_Frag();
                return nFrag;
            case 1:
                Trending_Frag tFrag = new Trending_Frag();
                return tFrag;
            case 2:
                Most_Viewed_Frag mvFrag = new Most_Viewed_Frag();
                return mvFrag;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tid;
    }
}
