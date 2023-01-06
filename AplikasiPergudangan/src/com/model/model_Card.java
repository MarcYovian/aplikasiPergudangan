package com.model;

public class model_Card {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public model_Card(String title, double num) {
        this.title = title;
        this.num = num;
    }
    
    public model_Card(){
    }
    
    private String title;
    private double num;
}
