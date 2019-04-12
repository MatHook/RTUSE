package com.example.lab2;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TechPagerAdapter extends FragmentStatePagerAdapter {
    public TechPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        if (!(object instanceof PageFragment))
            return super.getItemPosition(object);

        PageFragment pageFragment = (PageFragment) object;

        DataHolder.Data data = DataHolder.getInstance().getData(pageFragment.getTechNumber());

        if (data.graphicBitmap != null && pageFragment.hasProgressBar()) {
            return POSITION_NONE;
        }

        return POSITION_UNCHANGED;
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        try{
            super.restoreState(state, loader);
        }catch (NullPointerException | IllegalStateException e){
            // null caught
        }
    }

    @Override
    public int getCount() {
        DataHolder dataHolder = DataHolder.getInstance();

        return dataHolder.size();
    }
}
