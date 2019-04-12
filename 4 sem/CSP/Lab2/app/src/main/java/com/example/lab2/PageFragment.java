package com.example.lab2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PageFragment extends Fragment {
    private static final String TECH_NUMBER = "arg_tech_number";

    private ProgressBar progressBar;

    private int techNumber;

    public static PageFragment newInstance(int page) {
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(TECH_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        assert getArguments() != null;
        techNumber = getArguments().getInt(TECH_NUMBER);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tech_pager_page, null);

        ImageView imageView = view.findViewById(R.id.tech_image);
        TextView nameTextView = view.findViewById(R.id.tech_name);
        TextView helptextTextView = view.findViewById(R.id.tech_helptext);
        progressBar = view.findViewById(R.id.progress_bar);

        DataHolder dataHolder = DataHolder.getInstance();

        DataHolder.Data data = dataHolder.getData(techNumber);

        nameTextView.setText(data.name);
        helptextTextView.setText(data.helptext);

        if (data.graphicBitmap == null) {
            imageView.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);

        } else {
            imageView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);

            imageView.setImageBitmap(data.graphicBitmap);
        }

        return view;
    }

    public int getTechNumber() {
        return techNumber;
    }

    public boolean hasProgressBar() {
        return progressBar != null && progressBar.getVisibility() == View.VISIBLE;
    }
}