package edu.radionet;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends Activity implements MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener,
        SeekBar.OnSeekBarChangeListener{
    private static MediaPlayer mediaPlayer;
    private AudioManager am;
    private static boolean isReconected = false;
    private static String DATA_STREAM_NOW = "";
    private Fragment rockFragment, popFragment, romanticFragment, localFragment, shansonFragment;
    private ActionBar.Tab rockTab, popTab, romanticTab, localTab, shansonTab;
    public static TextView radioName;
    private static ImageView img_status;
    private SeekBar seekBar;
    private static MyTask aTask;
    private static int w_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        radioName = (TextView)findViewById(R.id.radioName);
        img_status = (ImageView)findViewById(R.id.img_status);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);

        am = (AudioManager)getSystemService(AUDIO_SERVICE);
        am.setStreamVolume(AudioManager.STREAM_MUSIC, 1, 0);
        //int i = am.getStreamMaxVolume(am.STREAM_MUSIC);

        rockFragment = new FragmentRock();
        popFragment = new FragmentPop();
        romanticFragment = new FragmentRomantic();
        localFragment = new FragmentLocal();
        shansonFragment = new FragmentShanson();

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        rockTab = actionBar.newTab().setText("РОК");
        rockTab.setTabListener(new TabListener(rockFragment));
        popTab = actionBar.newTab().setText("ПОП");
        popTab.setTabListener(new TabListener(popFragment));
        romanticTab = actionBar.newTab().setText("РОМАНТИКА");
        romanticTab.setTabListener(new TabListener(romanticFragment));
        localTab = actionBar.newTab().setText("МЕСТНОЕ");
        localTab.setTabListener(new TabListener(localFragment));
        shansonTab = actionBar.newTab().setText("ШАНСОН");
        shansonTab.setTabListener(new TabListener(shansonFragment));
        actionBar.addTab(rockTab);
        actionBar.addTab(popTab);
        actionBar.addTab(romanticTab);
        actionBar.addTab(localTab);
        actionBar.addTab(shansonTab);

        img_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isReconected){
                    img_status.setImageResource(R.drawable.play);
                    isReconected = false;
                    mediaPlayer.stop();
                    //aTask.cancel(true);
                    return;
                }
                if (!isReconected && !DATA_STREAM_NOW.equals("")) {
                    startStream(DATA_STREAM_NOW);
                    img_status.setImageResource(R.drawable.stop);
                    //moveText();
                }
            }
        });
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        w_screen = metrics.widthPixels;
    }

    public static void startStream (String DATA_STREAM) {
        moveText();
        DATA_STREAM_NOW = DATA_STREAM;
        releaseMP();
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(DATA_STREAM);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);//задаем параметры(способы воспроизведения и конекта и т.д.)Почитать подробнее
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                    img_status.setImageResource(R.drawable.stop);
                }
            });
            mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                @Override
                public void onBufferingUpdate(MediaPlayer mp, int percent) {

                }
            });
            mediaPlayer.prepareAsync();//вызов метода в отдельном потоке для запуска плеера
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (mediaPlayer == null) return;
        isReconected = true;
    }
    public static void releaseMP(){//Здесь мы освобождаем ресурсы перед запуском другого источника
        if (mediaPlayer != null) {
            try{
                mediaPlayer.release();
                mediaPlayer = null;
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDestroy() {//освобождаем рессурсы
        super.onDestroy();
        releaseMP();
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        // what - код ошибки
        // extra - доп.параметр(код ошибки ....)
        if(mp == this.mediaPlayer && what == MediaPlayer.MEDIA_ERROR_UNKNOWN){
            if(extra == MediaPlayer.MEDIA_ERROR_TIMED_OUT){
                if (!isReconected) { //если еще не подключались, то...
                    try { // Возможно нужно сделать в AsyncTask
                        Thread.sleep(5000);
                        mp.start();
                        isReconected = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else Toast.makeText(this, "Can't connect. Please, try later", Toast.LENGTH_LONG).show();
            }
        }
        return false;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        Toast.makeText(this, "Воспроизведение завершено", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        am.setStreamVolume(AudioManager.STREAM_MUSIC, progress,0);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //am.setStreamVolume(AudioManager.STREAM_MUSIC, seekBar.getProgress(),0);
    }

    public static void moveText(){
       //int length_text =  radioName.getRight() - radioName.getLeft();
        aTask = new MyTask();
        aTask.execute((int)radioName.getX(), w_screen);
    }

    private class TabListener implements ActionBar.TabListener {
        private Fragment fragment;
        public TabListener(Fragment frag) {
            fragment = frag;
        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.replace(R.id.FL, fragment);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.remove(fragment);
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }
    }
}
