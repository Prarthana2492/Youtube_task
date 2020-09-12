package com.example.farmpe_stream;


public class Video_Bean {



    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecong_name() {
        return secong_name;
    }

    public void setSecong_name(String secong_name) {
        this.secong_name = secong_name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    String secong_name;
    int image;



    public Video_Bean(String name, String secong_name, int image) {

        this.name = name;
        this.secong_name = secong_name;
        this.image = image;

    }
}


