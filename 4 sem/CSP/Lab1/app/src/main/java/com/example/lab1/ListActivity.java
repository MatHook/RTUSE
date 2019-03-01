package com.example.lab1;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // Create and set adapter
        TextIndexAdapter textIndexAdapter = new TextIndexAdapter(1_000_000);
        recyclerView.setAdapter(textIndexAdapter);

        // Create and set linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (Build.VERSION.SDK_INT < 21) {
                finishAffinity();
            } else {
                finishAndRemoveTask();
            }

            return false;
        }

        return super.onKeyDown(keyCode, event);
    }
}
