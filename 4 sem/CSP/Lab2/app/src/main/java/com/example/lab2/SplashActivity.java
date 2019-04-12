package com.example.lab2;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = "SplashActivityTag";

    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        queue = Volley.newRequestQueue(this);

        final String url = "https://raw.githubusercontent.com/wesleywerner/ancient-tech/master/src/data/techs.ruleset.json";

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    DataHolder dataHolder = DataHolder.getInstance();

                    dataHolder.clear();

                    int len = response.length();

                    for(int i = 1; i < len; i++) {
                        try {
                            JSONObject obj = (JSONObject) response.get(i);

                            dataHolder.addData(new DataHolder.Data(
                                    obj.optString("name"),
                                    obj.optString("graphic"),
                                    obj.optString("helptext")
                            ));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    goToListActivity();

                }, error -> {
            error.printStackTrace();

            // TODO: Handle error
        });

        DataHolder.Data.graphicBitmapError = BitmapFactory.decodeResource(
                getResources(), R.drawable.close
        );

        queue.add(jsonObjectRequest);
    }

    private void goToListActivity() {
        Intent intent = new Intent(this, TechActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStop () {
        super.onStop();

        if (queue != null) {
            queue.cancelAll(TAG);
        }
    }
}