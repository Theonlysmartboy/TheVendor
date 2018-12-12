package com.otemainc.thevendor;

public class Upload extends ClientUploads {
    public String name;
    public String url;
    public String category;
    public  String description;
    public String cost;



    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public Upload() {
    }

    public Upload(String name, String url, String category, String Description, String Cost) {
        this.name = name;
        this.url = url;
        this.category = category;
        this.description = Description;
        this.cost = Cost;

    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
    public String getDescription() {
        return description;
    }

    public String getCost() {
        return cost;
    }

    public String getCategory() {
        return category;
    }
}
