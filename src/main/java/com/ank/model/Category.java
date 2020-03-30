package com.ank.model;

public class Category {

    private String id;
    private String categoryName;

    public Category(String id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public String getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
