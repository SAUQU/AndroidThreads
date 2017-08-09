package com.example.segundoauqui.androidthreads;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;


/**
 * Created by segundoauqui on 8/9/17.
 */

public class TestRunnable implements Runnable {


    int i;
    TextView textView;
    Handler handler = new Handler(Looper.getMainLooper());

    public TestRunnable(TextView textView) {
        this.textView = textView;
    }


    @Override
    public void run() {

        System.out.print(Thread.currentThread());

        for (i = 0; i < 10; i++) {

            try {

                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    textView.setText(String.valueOf(i));

                }

            }, 2000);

        }
    }
}
