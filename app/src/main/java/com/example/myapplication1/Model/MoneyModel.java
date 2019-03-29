package com.example.myapplication1.Model;

public class MoneyModel {

    private String id,category,money;

    public MoneyModel() {
    }

    public MoneyModel(String id, String category, String money) {
        this.id = id;
        this.category = category;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String title) {
        this.category = category;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String description) {
        this.money = money;
    }


}
