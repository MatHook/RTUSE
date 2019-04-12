package com.example.lab2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

class PagerFragment extends Fragment {
    private TechPagerAdapter pagerAdapter;
    private ViewPager pager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tech_pager_fragment, container, false);

        pager = view.findViewById(R.id.tech_pager);

        pagerAdapter = new TechPagerAdapter(getChildFragmentManager());

        pager.setAdapter(pagerAdapter);

        pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                TechActivity activity = (TechActivity) getActivity();

                assert activity != null;
                activity.requestGraphic(DataHolder.getInstance().getData(position), position);

                activity.updateListFragmentCurrentItem(position);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (getArguments() != null)
            pager.setCurrentItem(getArguments().getInt("arg_current_item"));
    }

    public TechPagerAdapter getAdapter() {
        return pagerAdapter;
    }
}

