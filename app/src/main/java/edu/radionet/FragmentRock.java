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
public class FragmentRock extends Fragment implements View.OnClickListener{
    private ImageView img_radio_rok;
    private ImageView img_rus_rock;
    private ImageView img_biker_fm;
    private ImageView img_radio_skala;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_rock, null);

        img_radio_rok = (ImageView)v.findViewById(R.id.img_radio_rok);
        img_rus_rock = (ImageView)v.findViewById(R.id.img_rus_rock);
        img_biker_fm = (ImageView)v.findViewById(R.id.img_biker_fm);
        img_radio_skala = (ImageView)v.findViewById(R.id.img_radio_skala);
        img_radio_rok.setOnClickListener(this);
        img_rus_rock.setOnClickListener(this);
        img_biker_fm.setOnClickListener(this);
        img_radio_skala.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        String DATA_STREAM = "";
        switch (v.getId()) {
            case R.id.img_radio_rok:
                DATA_STREAM = "http://online-radioroks.tavrmedia.ua/RadioROKS";
                MainActivity.radioName.setText("Радио РОКС");
                break;
            case R.id.img_rus_rock:
                MainActivity.radioName.setText("Русский Рок");
                DATA_STREAM = "http://music.myradio.ua:8000/RusRock128.mp3";
                break;
            case R.id.img_biker_fm:
                DATA_STREAM = "http://stream1.radiostyle.ru:8001/biker-fm";
                MainActivity.radioName.setText("Байкер FM");
                break;
            case R.id.img_radio_skala:
                DATA_STREAM = "http://85.114.140.64:8000/1105";
                MainActivity.radioName.setText("Радио СКАЛА");
                break;
        }
        MainActivity.startStream(DATA_STREAM);
    }
}
