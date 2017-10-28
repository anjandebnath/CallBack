package com.uss.anjan.callback;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Anjan on 4/11/2017.
 */

public class SecondActivity extends AppCompatActivity implements UiCallback {

    WorkerThread workerThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        workerThread = WorkerThread.getInstance();
        workerThread.setUiCallback(this);

    }



    @Override
    public void onUpdateUi(final String title) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), title, Toast.LENGTH_LONG).show();
            }
        });

    }
}
