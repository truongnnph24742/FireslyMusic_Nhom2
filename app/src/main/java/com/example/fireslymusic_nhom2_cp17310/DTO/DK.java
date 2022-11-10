package com.example.fireslymusic_nhom2_cp17310.DTO;

public class DK {
    String name;
    String pass;
    String repass;

    public DK() {
    }

    public DK(String name, String pass, String repass) {
        this.name = name;
        this.pass = pass;
        this.repass = repass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRepass() {
        return repass;
    }

    public void setRepass(String repass) {
        this.repass = repass;
    }
}
