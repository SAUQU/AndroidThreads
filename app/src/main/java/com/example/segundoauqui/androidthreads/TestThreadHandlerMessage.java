package com.example.segundoauqui.androidthreads;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * Created by segundoauqui on 9/8/17.
 */

public class TestThreadHandlerMessage extends Thread {


    private Handler handler;
    public static final String TAG = "TestThreadHandler";

    public TestThreadHandlerMessage(Handler handler) {
        this.handler = handler;
    }



    @Override
    public void run() {
        super.run();

        System.out.println("run: Thread: " + Thread.currentThread());
        //adding data to be sent to bundle
        String data = " message from test handler";
        Bundle bundle = new Bundle();
        bundle.putString("key", data);

        //add the bundle to the message object
        Message message = new Message();
        message.setData(bundle);

        //send the message object to the handler
        handler.sendMessage(message);
    }


}
