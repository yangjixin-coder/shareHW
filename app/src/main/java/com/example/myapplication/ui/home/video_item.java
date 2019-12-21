package com.example.myapplication.ui.home;

public class video_item {
    private String courseid;
    private String name;
    private String description;


    public video_item(String courseid, String name,String description) {
        this.courseid = courseid;
        this.name = name;
        this.description = description;
    }

    public String getCourseid() {
        return courseid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
