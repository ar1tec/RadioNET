package edu.radionet;

import android.os.AsyncTask;

/**
 * Created by Александр on 22.09.2016.
 */
public class MyTask extends AsyncTask<Integer, Integer, Void> {
    private int delta_x;

    @Override
    protected Void doInBackground(Integer... params) {
        int x_start = params[0];
        int w_screen = params[1];

        while (w_screen > 0) { //вместо true
            delta_x = x_start - 10;
            if (delta_x + 400 < 0) {
                delta_x = w_screen;
            }
            try {
                Thread.sleep(0, 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(delta_x);
            x_start = delta_x;
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        int delta_x = values[0];
        MainActivity.radioName.setX(delta_x);
    }
}
