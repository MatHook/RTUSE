package com.example.lab1;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity implements SplashScreenListener {

    private boolean isVisible;
    private SleepTask sleepTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sleepTask = new SleepTask(this);
        sleepTask.execute();
    }

    @Override
    protected void onPause() {
        super.onPause();
        isVisible = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isVisible = true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        sleepTask.cancel(true);
    }

    public void onSplashScreenEnd() {
        if (!isVisible) {
            finish();
            return;
        }

        Intent i = new Intent(SplashScreenActivity.this, ListActivity.class);

        startActivity(i);

        finish();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private static class SleepTask extends AsyncTask<Void, Void, Void> {
        final SplashScreenListener listener;

        SleepTask(SplashScreenListener listener) {
            super();

            this.listener = listener;
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (listener != null)
                listener.onSplashScreenEnd();
        }
    }
}
