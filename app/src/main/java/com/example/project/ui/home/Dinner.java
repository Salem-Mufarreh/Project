package com.example.project.ui.home;

public class Dinner {
    private String name;
    private double price;
    private int time;
    private String description;
    private int id;

    public Dinner(String name, double price, int time, String description, int id) {
        this.name = name;
        this.price = price;
        this.time = time;
        this.description = description;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
