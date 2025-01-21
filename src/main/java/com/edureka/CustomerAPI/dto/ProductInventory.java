package com.edureka.CustomerAPI.dto;


public class ProductInventory {

    private Integer itemID;
    private boolean isAvailable;

    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
