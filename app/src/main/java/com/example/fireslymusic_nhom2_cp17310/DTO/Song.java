package com.example.fireslymusic_nhom2_cp17310.DTO;

public class Song {
    private int id_m;
    private String song_name;
    private String singer;
    private int status;
    private String file;
    private int img;
    private int id_ns;

    public Song(int id_m, String song_name, String singer, int status, String file, int img,int id_ns) {
        this.id_m = id_m;
        this.song_name = song_name;
        this.singer = singer;
        this.status = status;
        this.file = file;
        this.img = img;
        this.id_ns = id_ns;
    }

    public Song(int id_m, String song_name, int img,String singer , int id_ns) {
        this.id_m = id_m;
        this.song_name = song_name;
        this.singer = singer;
        this.img = img;
        this.id_ns = id_ns;
    }

    public Song() {
    }

    public Song(int id_m, String song_name, int img, String singer) {
        this.id_m = id_m;
        this.song_name = song_name;

        this.img = img;
        this.singer = singer;
    }

    public int getId_ns() {
        return id_ns;
    }

    public void setId_ns(int id_ns) {
        this.id_ns = id_ns;
    }

    public int getId_m() {
        return id_m;
    }

    public void setId_m(int id_m) {
        this.id_m = id_m;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
