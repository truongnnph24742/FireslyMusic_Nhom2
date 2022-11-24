package com.example.fireslymusic_nhom2_cp17310.DTO;

public class Song {
    private int id_m;
    private String song_name;
    private String singer;
    private int status;
    private int file;
    private int img;

    public Song(int id_m, String song_name, String singer, int status, int file, int img) {
        this.id_m = id_m;
        this.song_name = song_name;
        this.singer = singer;
        this.status = status;
        this.file = file;
        this.img = img;
    }

    public Song(int id_m, String song_name, int img, String singer) {
        this.id_m = id_m;
        this.song_name = song_name;
        this.img = img;
        this.singer = singer;
    }

    public Song(int id_m, String song_name,int img ,String singer ,int file ) {
        this.id_m = id_m;
        this.song_name = song_name;
        this.img = img;
        this.singer = singer;
        this.file = file;

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

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
