package com.example.segundoauqui.androidthreads;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by segundoauqui on 8/9/17.
 */



public class TestAsynctask  extends AsyncTask<String, Integer, String> {

    private TextView view;


    private static final String TAG = " Asyntask";

    public TestAsynctask(TextView view) {
        this.view = view;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: " + Thread.currentThread());
    }

    @Override
    protected String doInBackground(String... strings) {

        Log.d(TAG, "doInBackground: " + strings[0] + Thread.currentThread());
        for (int i = 0; i < 10; i++) {

            try {

                Thread.sleep(1000);
                publishProgress(i);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String t = "this come from background";

        return t;
    }


    @Override
    protected void onProgressUpdate(Integer... values){
        super.onProgressUpdate(values);
        Log.d(TAG, "onProgressUpdate: " + Thread.currentThread());
        view.setText(String.valueOf(values[0]));
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        view.setText(s);
        Log.d(TAG, "onPostExecute: " + s + Thread.currentThread());
    }

}
