package com.otemainc.thevendor;

public class ClientUploads {
    public String name;
    public String category;
    public String cost;
    public String school;

    // Default constructor required for calls to
     public ClientUploads() {
    }

    public ClientUploads(String school, String name, String category, String Cost) {
       this.school = school;
        this.name = name;
        this.category = category;
        this.cost = Cost;

    }

    public String getSchool() {
        return school;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getCost() {
        return cost;
    }
}
