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
public class FragmentRomantic extends Fragment implements View.OnClickListener {
    private ImageView img_lounge_fm;
    private ImageView img_relax_fm;
    private ImageView img_renesans;
    private ImageView img_psy_radio;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_romantic, null);

        img_lounge_fm = (ImageView)v.findViewById(R.id.img_lounge_fm);
        img_relax_fm = (ImageView)v.findViewById(R.id.img_relax_fm);
        img_renesans = (ImageView)v.findViewById(R.id.img_renesans);
        img_psy_radio = (ImageView)v.findViewById(R.id.img_psy_radio);
        img_lounge_fm.setOnClickListener(this);
        img_relax_fm.setOnClickListener(this);
        img_renesans.setOnClickListener(this);
        img_psy_radio.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        String DATA_STREAM = "";
        switch (v.getId()) {
            case R.id.img_lounge_fm:
                DATA_STREAM = "http://cast.loungefm.com.ua/loungefm?1474388176765.mp3";
                MainActivity.radioName.setText("Lounge FM");
                break;
            case R.id.img_relax_fm:
                DATA_STREAM = "http://ic6.101.ru:8000/v13_1";
                MainActivity.radioName.setText("Relax FM");
                break;
            case R.id.img_renesans:
                DATA_STREAM = "http://217.20.164.163:8014/;stream.nsv";
                MainActivity.radioName.setText("Ренесанс");
                break;
            case R.id.img_psy_radio:
                DATA_STREAM = "http://stream.psyradio.com.ua:8000/256kbps";
                MainActivity.radioName.setText("PSI FM");
                break;
        }
        MainActivity.startStream(DATA_STREAM);
    }
}
