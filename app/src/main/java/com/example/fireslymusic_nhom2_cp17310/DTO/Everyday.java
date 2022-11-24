package com.example.fireslymusic_nhom2_cp17310.DTO;

public class Everyday {
    private int id_every;
    private String everyday_name;
    private String singer;
    private int status;
    private int file;
    private int img;

    public Everyday(int id_every, String everyday_name, String singer, int status, int file, int img) {
        this.id_every = id_every;
        this.everyday_name = everyday_name;
        this.singer = singer;
        this.status = status;
        this.file = file;
        this.img = img;
    }

    public Everyday(int id_every, String everyday_name, int img) {
        this.id_every = id_every;
        this.everyday_name = everyday_name;
        this.img = img;
    }

    public Everyday(int id_every, String everyday_name, String singer, int file, int img) {
        this.id_every = id_every;
        this.everyday_name = everyday_name;
        this.singer = singer;
        this.file = file;
        this.img = img;
    }

    public int getId_every() {
        return id_every;
    }

    public void setId_every(int id_every) {
        this.id_every = id_every;
    }

    public String getEveryday_name() {
        return everyday_name;
    }

    public void setEveryday_name(String everyday_name) {
        this.everyday_name = everyday_name;
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
