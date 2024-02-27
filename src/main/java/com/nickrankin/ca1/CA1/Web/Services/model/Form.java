package com.nickrankin.ca1.CA1.Web.Services.model;

import com.nickrankin.ca1.CA1.Web.Services.helpers.FormType;

public class Form {

    public Form() {

    }

    private String title;
    private int year;

    private FormType name;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name.name();
    }

    public void setName(FormType name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Form{" +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}
