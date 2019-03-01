package com.example.lab1;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TextIndexAdapter extends RecyclerView.Adapter<TextIndexAdapter.ItemHolder> {
    private final int itemNumber;
    private NumberToString converter;

    public TextIndexAdapter(int itemNumber) {
        this.itemNumber = itemNumber;

        converter = new NumberToString();
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.item, parent, false);

        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        int number = position + 1;

        holder.textView.setText(converter.numberToString(number));

        int backgroundColor = ContextCompat.getColor(holder.itemView.getContext(),
                number % 2 == 0 ? R.color.gray : R.color.white);

        holder.linearLayout.setBackgroundColor(backgroundColor);
    }

    @Override
    public int getItemCount() {
        return itemNumber;
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final LinearLayout linearLayout;

        ItemHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            linearLayout = itemView.findViewById(R.id.line);
        }
    }
}