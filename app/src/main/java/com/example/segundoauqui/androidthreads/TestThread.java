package com.example.segundoauqui.androidthreads;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by segundoauqui on 8/9/17.
 */

public class TestThread extends Thread {




    TextView tvTesting;
    TextView tvT;
    Handler handler = new Handler(Looper.getMainLooper());

    public TestThread(TextView tvTesting) {
        this.tvTesting = tvTesting;
    }



    int i;

    @Override
    public void run() {
        super.run();

        System.out.print(Thread.currentThread());

        for (i = 0; i < 10 ; i++) {


            try {

                Thread.sleep(1000);
                System.out.println(i);

            }catch (InterruptedException e) {
                e.printStackTrace();
            }

            handler.post(new Runnable(){
                @Override
                public void run() {
                    tvTesting.setText(String.valueOf(i));
                   // tvT.setText(String.valueOf(i));
                }
            });
            EventBus.getDefault().post(new MessageEvent(String.valueOf(i)));

        }

    }
}
