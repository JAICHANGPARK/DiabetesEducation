package com.dreamwalker.diabeteseducation;

public class CardItem {
    //    private int image;
    private String name;
    private String grade;
    private String email;
    private String call;
    private String assign;

    //    public CardItem(int image, String name, String grade, String email, String call, String assign) {
    public CardItem(String name, String grade, String email, String call, String assign) {
//        this.image = image;
        this.name = name;
        this.grade = grade;
        this.email = email;
        this.call = call;
        this.assign = assign;
    }

//    public int getImage() {
//        return image;
//    }

//    public void setImage(int image) {
//        this.image = image;
//    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public String getEmail() {
        return email;
    }

    public String getCall() {
        return call;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }
}