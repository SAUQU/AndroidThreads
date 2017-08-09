package com.example.segundoauqui.androidthreads;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    TextView tvTesting;
    TextView tvT2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTesting = (TextView) findViewById(R.id.tvTesting);

        tvT2 = (TextView) findViewById(R.id.tvT2);
    }


    public void executeThreads(View view) {

        switch (view.getId()) {
            case R.id.btnThread:

                TestThread testThread = new TestThread(tvTesting);
                testThread.start();
                break;



            case R.id.btnRunnable:
                TestRunnable testRunnable = new TestRunnable(tvTesting);
                Thread thread = new Thread(testRunnable);
                thread.start();

//
                break;

            case R.id.btnAsyntask:
                TestAsynctask testAsynctask = new TestAsynctask(tvT2);
                testAsynctask.execute("Staring");


                break;



        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent){
        Toast.makeText(this, messageEvent.getMessage(), Toast.LENGTH_SHORT).show();
    }


}
