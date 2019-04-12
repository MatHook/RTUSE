package com.example.lab2;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import java.util.Objects;

public class TechActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {
    private static final String TAG = "ListActivityTag";

    private ListAdapter listFragment;
    private PagerFragment pagerFragment;

    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech);

        queue = Volley.newRequestQueue(this);

        listFragment = new ListAdapter();

        pagerFragment = new PagerFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_placeholder, listFragment)
                .commit();

        getSupportFragmentManager().addOnBackStackChangedListener(this);
    }

    public void updateListFragmentCurrentItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("arg_current_item", position);

        listFragment.setArguments(bundle);
    }

    public void openViewPager(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("arg_current_item", position);

        pagerFragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_placeholder, pagerFragment)
                .addToBackStack(null)
                .commit();
    }

    public void requestGraphicForVisible() {
        LinearLayoutManager lm = listFragment.getLayoutManager();

        int firstVisibleItemPosition = lm.findFirstVisibleItemPosition();
        int lastVisibleItemPosition = lm.findLastVisibleItemPosition();

        DataHolder dataHolder = DataHolder.getInstance();

        for (int i = firstVisibleItemPosition; i <= lastVisibleItemPosition; i++) {
            DataHolder.Data data = dataHolder.getData(i);

            if (data.graphicBitmap == null && !data.requested) {
                requestGraphic(data, i);
            }
        }
    }

    public void requestGraphic(DataHolder.Data data, int position){
        String url = "https://raw.githubusercontent.com/wesleywerner/ancient-tech/master/src/images/tech/";

        TechListAdapter adapter1 = listFragment.getAdapter();
        TechPagerAdapter adapter2 = pagerFragment.getAdapter();

        ImageRequest request = new ImageRequest(
                url.concat(data.graphic),
                bitmap -> {
                    data.graphicBitmap = bitmap;

                    if (adapter1 != null)
                        adapter1.notifyItemChanged(position);

                    if (adapter2 != null)
                        adapter2.notifyDataSetChanged();

                },
                0,
                0,
                ImageView.ScaleType.CENTER,
                null,
                error -> {
                    data.graphicBitmap = DataHolder.Data.graphicBitmapError;

                    if (adapter1 != null)
                        adapter1.notifyItemChanged(position);

                    if (adapter2 != null)
                        adapter2.notifyDataSetChanged();

                    error.printStackTrace();
                });

        queue.add(request);

        data.requested = true;
    }

    @Override
    protected void onStop () {
        super.onStop();

        if (queue != null) {
            queue.cancelAll(TAG);
        }
    }

    @Override
    public void onBackStackChanged() {
        shouldDisplayHomeUp();
    }

    private void shouldDisplayHomeUp(){
        //Enable Up button only  if there are entries in the back stack
        boolean canGoBack = getSupportFragmentManager().getBackStackEntryCount()>0;
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(canGoBack);
    }

    @Override
    public boolean onSupportNavigateUp() {
        //This method is called when the up button is pressed. Just the pop back stack.
        getSupportFragmentManager().popBackStack();
        return true;
    }
}