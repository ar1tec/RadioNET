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
public class FragmentPop extends Fragment implements View.OnClickListener{
    private ImageView img_avto_radio;
    private ImageView img_lux_fm;
    private ImageView img_rus_radio;
    private ImageView img_perec_fm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pop, null);

        img_avto_radio = (ImageView)v.findViewById(R.id.img_avto_radio);
        img_lux_fm = (ImageView)v.findViewById(R.id.img_lux_fm);
        img_rus_radio = (ImageView)v.findViewById(R.id.img_rus_radio);
        img_perec_fm = (ImageView)v.findViewById(R.id.img_perec_fm);
        img_avto_radio.setOnClickListener(this);
        img_lux_fm.setOnClickListener(this);
        img_rus_radio.setOnClickListener(this);
        img_perec_fm.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        String DATA_STREAM = "";
        switch (v.getId()) {
            case R.id.img_avto_radio:
                DATA_STREAM = "http://cast.avtoradio.ua/avtoradio";
                MainActivity.radioName.setText("Авторадио");
                break;
            case R.id.img_lux_fm:
                DATA_STREAM = "http://icecastlv.luxnet.ua/lux_mp3";
                MainActivity.radioName.setText("Люкс FM");
                break;
            case R.id.img_rus_radio:
                DATA_STREAM = "http://icecast.russkoeradio.cdnvideo.ru/rr.mp3";
                MainActivity.radioName.setText("Русское радио");
                break;
            case R.id.img_perec_fm:
                DATA_STREAM = "http://radio.urg.ua/radio-stilnoe";
                MainActivity.radioName.setText("Перец FM");
                break;
        }
        MainActivity.startStream(DATA_STREAM);
    }
}
