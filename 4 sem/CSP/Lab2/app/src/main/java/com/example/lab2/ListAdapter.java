package com.example.lab2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ListAdapter extends Fragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private TechListAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tech_list_fragment, null);

        recyclerView = view.findViewById(R.id.tech_list);

        recyclerView.setItemAnimator(null);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        TechActivity activity = (TechActivity) getActivity();

        adapter = new TechListAdapter(activity);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy != 0) {
                    assert activity != null;
                    activity.requestGraphicForVisible();
                }
            }
        });

        assert activity != null;
        recyclerView.post(activity::requestGraphicForVisible);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (getArguments() != null)
            recyclerView.scrollToPosition(getArguments().getInt("arg_current_item"));
    }

    public TechListAdapter getAdapter() {
        return adapter;
    }

    public LinearLayoutManager getLayoutManager() {
        return layoutManager;
    }

}
