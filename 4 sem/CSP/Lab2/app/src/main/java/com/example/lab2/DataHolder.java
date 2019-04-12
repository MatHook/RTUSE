package com.example.lab2;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {

    private final List<Data> storage;

    private static final DataHolder holder = new DataHolder();

    static class Data {
        final String name;
        final String graphic;
        final String helptext;
        Bitmap graphicBitmap;
        static Bitmap graphicBitmapError;
        boolean requested;

        Data(String name, String graphic, String helptext) {
            this.name = name;
            this.graphic = graphic;
            this.helptext = helptext;

            graphicBitmap = null;
            requested = false;
        }
    }

    private DataHolder() {
        storage = new ArrayList<>();
    }

    public Data getData(int index) {
        return storage.get(index);
    }

    public int size() {
        return storage.size();
    }

    void clear() {
        storage.clear();
    }

    void addData(Data data) {
        storage.add(data);
    }

    static DataHolder getInstance() {
        return holder;
    }
}
