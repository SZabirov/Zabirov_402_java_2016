package ru.itis.inform.store.dao.models;

import com.google.common.base.MoreObjects;

import java.util.Objects;

public class Item {

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public Item(int id, String itemName, double price) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
    }

    public int getId() {

        return id;

    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    private String itemName;

    private double price;

    public Item() {
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }


    public String getItemName() {
        return itemName;
    }


    public Item(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Item that = (Item) object;

        return Objects.equals(this.itemName, that.itemName) &&
                Objects.equals(this.price, that.price);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("Price", this.price)
                .add("Name", this.itemName)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.itemName, this.price);
    }
}
