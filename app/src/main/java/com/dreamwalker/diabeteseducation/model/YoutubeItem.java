package com.dreamwalker.diabeteseducation.model;

// 영상 아이템
public class YoutubeItem {
    private int Image;
    private String text;

    public YoutubeItem(int Image, String text){
        this.Image = Image;
        this.text = text;
    }

    public void setImage(int image) {
        Image = image;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {

        return Image;
    }

    public String getText() {
        return text;
    }
}
