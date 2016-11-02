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
public class FragmentShanson extends Fragment implements View.OnClickListener {
    private ImageView img_shanson;
    private ImageView img_shanson_two;
    private ImageView img_shanson_all_day;
    private ImageView img_lirika_shansona;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_shanson, null);

        img_shanson = (ImageView)v.findViewById(R.id.img_shanson);
        img_shanson_two = (ImageView)v.findViewById(R.id.img_shanson_two);
        img_shanson_all_day = (ImageView)v.findViewById(R.id.img_shanson_all_day);
        img_lirika_shansona = (ImageView)v.findViewById(R.id.img_lirika_shansona);
        img_shanson.setOnClickListener(this);
        img_shanson_two.setOnClickListener(this);
        img_shanson_all_day.setOnClickListener(this);
        img_lirika_shansona.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        String DATA_STREAM = "";
        switch (v.getId()) {
            case R.id.img_shanson:
                DATA_STREAM = "http://music.myradio.com.ua:8000/shanson128.mp3";
                MainActivity.radioName.setText("Шансон");
                break;
            case R.id.img_shanson_two:
                DATA_STREAM = "http://radio02-cn03.akadostream.ru:8108/shanson128.mp3";
                MainActivity.radioName.setText("Шансон 2");
                break;
            case R.id.img_shanson_all_day:
                DATA_STREAM = "http://5.19.168.205:8000/;stream.nsv";
                MainActivity.radioName.setText("Шансон 24");
                break;
            case R.id.img_lirika_shansona:
                DATA_STREAM = "http://music.myradio.com.ua:8000/shansonlyrics128.mp3";
                MainActivity.radioName.setText("Лирика шансона");
                break;
        }
        MainActivity.startStream(DATA_STREAM);
    }
}
