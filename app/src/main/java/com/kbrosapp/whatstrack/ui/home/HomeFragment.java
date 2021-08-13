package com.kbrosapp.whatstrack.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.kbrosapp.whatstrack.R;
import com.kbrosapp.whatstrack.SectionsPagerAdapter;

public class HomeFragment extends Fragment {

    ViewPager viewPager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getActivity(), getChildFragmentManager());
        viewPager = root.findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = root.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);


        return root;
    }

    public boolean onBackPressed(){
        //If first tab is open, then quit
        if (viewPager.getCurrentItem() == 0) {
            return true;
        }else {
            //If any other tab is open, then switch to first tab
            viewPager.setCurrentItem(0);
            return false;
        }
    }

    public void arrangeAccOrderPressed(){
        if (viewPager.getCurrentItem() != 0) {
            viewPager.setCurrentItem(0);
        }
    }
}