package ru.itis.inform.store.dao.models;

public class Item {

    private String itemName;

    public String getItemName() {
        return itemName;
    }

    public Item(String itemName) {
        this.itemName = itemName;
    }
}