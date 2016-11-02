package edu.radionet;

/**
 * Created by Александр on 20.09.2016.
 */
public class Station {
    private String name;
    private String DATA_STREAM;
    private Category category;
    private int img_res;


    public Station(String name, String DATA_STREAM, Category category, int img_res) {
        this.name = name;
        this.DATA_STREAM = DATA_STREAM;
        this.category = category;
        this.img_res = img_res;
    }

    public String getName() {
        return name;
    }

    public String getDATA_STREAM() {
        return DATA_STREAM;
    }

    public Category getCategory() {
        return category;
    }

    public int getImg_res() {
        return img_res;
    }
}
