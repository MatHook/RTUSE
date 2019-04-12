package com.example.lab2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TechListAdapter extends RecyclerView.Adapter<TechListAdapter.ItemViewHolder> {
    private final TechActivity activity;
    private final DataHolder dataHolder;

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        final LinearLayout mLinearLayout;
        final ImageView mImageView;
        final TextView mTextView;

        ItemViewHolder(LinearLayout view) {
            super(view);

            mLinearLayout = view;

            mImageView = view.findViewById(R.id.tech_image);
            mTextView = view.findViewById(R.id.tech_title);
        }
    }

    public TechListAdapter(TechActivity activity) {
        dataHolder = DataHolder.getInstance();

        this.activity = activity;
    }

    @NonNull
    @Override
    public TechListAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater
                .from(parent.getContext())
                .inflate(
                        viewType == 0 ? R.layout.tech_list_item : R.layout.tech_list_item_loading,
                        parent,
                        false
                );

        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, final int position) {
        DataHolder.Data data = dataHolder.getData(position);

        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.openViewPager(position);
            }
        });

        holder.mTextView.setText(data.name);

        if(holder.getItemViewType() == 0)
            holder.mImageView.setImageBitmap(data.graphicBitmap);
    }

    @Override
    public int getItemViewType(int position) {
        DataHolder.Data data = dataHolder.getData(position);

        return data.graphicBitmap == null ? 1 : 0;
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }
}
