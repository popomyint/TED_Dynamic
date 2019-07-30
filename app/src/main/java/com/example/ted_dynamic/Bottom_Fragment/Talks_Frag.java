package com.example.ted_dynamic.Bottom_Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.ted_dynamic.Child_Fragment.Newest_Frag;
import com.example.ted_dynamic.R;
import com.example.ted_dynamic.TabAdapter;
import com.google.android.material.tabs.TabLayout;

public class Talks_Frag extends Fragment {
    TabLayout tab;
    ViewPager tabcontent;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.talks_layout, container, false);
        tab = v.findViewById(R.id.tab);
        tabcontent = v.findViewById(R.id.tabcontent);
        tab.addTab(tab.newTab().setText("Newest"));
        tab.addTab(tab.newTab().setText("Most Viewed"));
        tab.addTab(tab.newTab().setText("Trending"));
        final TabAdapter tar = new TabAdapter(getChildFragmentManager(), this, tab.getTabCount());
        tabcontent.setAdapter(tar);
        tabcontent.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabcontent.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return v;
    }

    private onMainFragmentInteractionListener oMF;

    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof onMainFragmentInteractionListener){
            oMF = (onMainFragmentInteractionListener) context;
        }
    }

    public void onDetach(){
        super.onDetach();
        oMF = null;
    }

    public interface onMainFragmentInteractionListener{
        void mainOne(Uri uri);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Fragment newestFragment = new Newest_Frag();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.child_fragment_container, newestFragment).commit();
    }

}
