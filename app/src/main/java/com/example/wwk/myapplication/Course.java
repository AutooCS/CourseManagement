package com.example.wwk.myapplication;

/**
 * Created by wwk on 2015/9/30.
 */
public class Course {
    private String name;

    private String choice;

    public Course(String name, String choice) {
        this.name = name;
        this.choice = choice;
    }

    public String getName() {
        return name;
    }

    public String getChoice() {
        return choice;
    }

}
