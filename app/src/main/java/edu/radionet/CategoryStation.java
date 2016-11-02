package edu.radionet;

import java.util.ArrayList;

/**
 * Created by Александр on 20.09.2016.
 */
public class CategoryStation {
    private ArrayList<Station> allStation;
    private ArrayList<Station> rockStation;
    private ArrayList<Station> popStation;
    private ArrayList<Station> romanticStation;
    private ArrayList<Station> ukraineStation;
    private ArrayList<Station> shansonStation;

    public CategoryStation() {
        allStation = new ArrayList<>();
        rockStation = new ArrayList<>();
        popStation = new ArrayList<>();
        romanticStation = new ArrayList<>();
        ukraineStation = new ArrayList<>();
        shansonStation = new ArrayList<>();
        Station bickerFM = new Station("Байкер FM", "http://stream1.radiostyle.ru:8001/biker-fm", Category.ROCK, R.drawable.bicker_fm);
        allStation.add(bickerFM);
        Station radio_rok = new Station("Радио ROKS", "http://online-radioroks.tavrmedia.ua/RadioROKS", Category.ROCK, R.drawable.radio_roks);
        allStation.add(radio_rok);
        Station radio_skala = new Station("Скала", "http://85.114.140.64:8000/1105", Category.ROCK, R.drawable.radio_skala);
        allStation.add(radio_skala);
        Station rus_rock = new Station("Русский Рок", "http://music.myradio.ua:8000/RusRock128.mp3", Category.ROCK, R.drawable.rus_rock);
        allStation.add(rus_rock);
        Station shanson = new Station("Шансон", "http://music.myradio.com.ua:8000/shanson128.mp3", Category.SHANSON, R.drawable.shanson);
        allStation.add(shanson);
        Station shanson2 = new Station("Шансон 2", "http://radio02-cn03.akadostream.ru:8108/shanson128.mp3", Category.SHANSON, R.drawable.shanson_two);
        allStation.add(shanson2);
        Station lirika_shansona = new Station("Лирика шансона", "http://music.myradio.com.ua:8000/shansonlyrics128.mp3", Category.SHANSON, R.drawable.lirika_shansona);
        allStation.add(lirika_shansona);
        Station shanson_24 = new Station("Шансон 24", "http://5.19.168.205:8000/;stream.nsv", Category.SHANSON, R.drawable.shanso_all_day);
        allStation.add(shanson_24);
        Station evropa_plus = new Station("Европа плюс", "http://ep128.hostingradio.ru:8030/ep128", Category.UKRAINE, R.drawable.evropa_plus);
        allStation.add(evropa_plus);
        Station kiss_fm = new Station("Kiss FM", "http://online-kissfm.tavrmedia.ua/KissFM", Category.UKRAINE, R.drawable.kiss_fm);
        allStation.add(kiss_fm);
        Station nashe_radio = new Station("Наше радио", "http://cast.radiogroup.com.ua:8000/nashe", Category.UKRAINE, R.drawable.nashe_radio);
        allStation.add(nashe_radio);
        Station hit_fm = new Station("Хит FM", "http://online-hitfm.tavrmedia.ua/HitFM", Category.UKRAINE, R.drawable.hit_fm);
        allStation.add(hit_fm);
        Station avtoradio = new Station("Авторадио", "http://cast.avtoradio.ua/avtoradio", Category.POP, R.drawable.avtoradio);
        allStation.add(avtoradio);
        Station lux_fm = new Station("Люкс FM", "http://icecastlv.luxnet.ua/lux_mp3", Category.POP, R.drawable.lux_fm);
        allStation.add(lux_fm);
        Station rus_radio = new Station("Русское радио", "http://icecast.russkoeradio.cdnvideo.ru/rr.mp3", Category.POP, R.drawable.rus_radio);
        allStation.add(rus_radio);
        Station perec_fm = new Station("Перец FM", "http://radio.urg.ua/radio-stilnoe", Category.POP, R.drawable.perec_fm);
        allStation.add(perec_fm);
        Station lounge_fm = new Station("Lounge FM", "http://cast.loungefm.com.ua/loungefm?1474388176765.mp3", Category.ROMANTIC, R.drawable.lounge_fm);
        allStation.add(lounge_fm);
        Station relax_fm = new Station("Relax FM", "http://ic6.101.ru:8000/v13_1", Category.ROMANTIC, R.drawable.relax_fm);
        allStation.add(relax_fm);
        Station renesans = new Station("Ренесанс", "http://217.20.164.163:8014/;stream.nsv", Category.ROMANTIC, R.drawable.renesans);
        allStation.add(renesans);
        Station psy_radio = new Station("PSI FM", "http://stream.psyradio.com.ua:8000/256kbps", Category.ROMANTIC, R.drawable.psy_radio);
        allStation.add(psy_radio);

        for (Station station : allStation) {
            if (station.getCategory() == Category.ROCK) rockStation.add(station);
            if (station.getCategory() == Category.POP) popStation.add(station);
            if (station.getCategory() == Category.ROMANTIC) romanticStation.add(station);
            if (station.getCategory() == Category.UKRAINE) ukraineStation.add(station);
            if (station.getCategory() == Category.SHANSON) shansonStation.add(station);
        }
    }

    public ArrayList<Station> getAllStation() {
        return allStation;
    }

    public ArrayList<Station> getRockStation() {
        return rockStation;
    }

    public ArrayList<Station> getPopStation() {
        return popStation;
    }

    public ArrayList<Station> getRomanticStation() {
        return romanticStation;
    }

    public ArrayList<Station> getUkraineStation() {
        return ukraineStation;
    }

    public ArrayList<Station> getShansonStation() {
        return shansonStation;
    }
}
