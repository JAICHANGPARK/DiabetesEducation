package com.dreamwalker.diabeteseducation.introduction;

import java.util.ArrayList;

// 뷰
public class Index {
    public String index;
    public ArrayList<String> contents = new ArrayList<String>();

    public Index(String index) {
        this.index = index;
    }

    public String toString() {
        return index;
    }
}

