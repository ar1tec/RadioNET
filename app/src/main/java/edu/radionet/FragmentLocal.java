package edu.radionet;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Александр on 21.09.2016.
 */
public class FragmentLocal extends Fragment implements View.OnClickListener{
    private ImageView img_evropa_plus;
    private ImageView img_kiss_fm;
    private ImageView img_nashe_radio;
    private ImageView img_hit_fm;
    //private ArrayList<>

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_local, null);

        img_evropa_plus = (ImageView)v.findViewById(R.id.img_evropa_plus);
        img_kiss_fm = (ImageView)v.findViewById(R.id.img_kiss_fm);
        img_nashe_radio = (ImageView)v.findViewById(R.id.img_nashe_radio);
        img_hit_fm = (ImageView)v.findViewById(R.id.img_hit_fm);
        img_evropa_plus.setOnClickListener(this);
        img_kiss_fm.setOnClickListener(this);
        img_nashe_radio.setOnClickListener(this);
        img_hit_fm.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        String DATA_STREAM = "";
        switch (v.getId()) {
            case R.id.img_evropa_plus:
                DATA_STREAM = "http://ep128.hostingradio.ru:8030/ep128";
                MainActivity.radioName.setText("Европа плюс");
                break;
            case R.id.img_kiss_fm:
                DATA_STREAM = "http://online-kissfm.tavrmedia.ua/KissFM";
                MainActivity.radioName.setText("Kiss FM");
                break;
            case R.id.img_nashe_radio:
                DATA_STREAM = "http://cast.radiogroup.com.ua:8000/nashe";
                MainActivity.radioName.setText("Наше радио");
                break;
            case R.id.img_hit_fm:
                DATA_STREAM = "http://online-hitfm.tavrmedia.ua/HitFM";
                MainActivity.radioName.setText("Хит FM");
                break;
        }
        MainActivity.startStream(DATA_STREAM);
    }
}
