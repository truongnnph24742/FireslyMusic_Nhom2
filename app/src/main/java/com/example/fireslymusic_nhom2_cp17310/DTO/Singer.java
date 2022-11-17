package com.example.fireslymusic_nhom2_cp17310.DTO;

public class Singer {
    private String singer_name;
    private int img_singer;

    public Singer(String singer_name, int img_singer) {
        this.singer_name = singer_name;
        this.img_singer = img_singer;
    }

    public String getSinger_name() {
        return singer_name;
    }

    public void setSinger_name(String singer_name) {
        this.singer_name = singer_name;
    }

    public int getImg_singer() {
        return img_singer;
    }

    public void setImg_singer(int img_singer) {
        this.img_singer = img_singer;
    }
}
